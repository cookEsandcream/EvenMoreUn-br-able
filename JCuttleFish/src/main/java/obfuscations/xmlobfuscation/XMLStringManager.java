package obfuscations.xmlobfuscation;

import obfuscations.FileHelper;
import providers.ObfuscatedNamesProvider;
import util.enums.ObfuscatedNamesVariations;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLStringManager {

    private File stringFile;
    private ArrayList<File> javaFiles;
    private ArrayList<File> layoutFiles;
    private HashMap<String, String> stringNameMappings = new HashMap<>(); //Key is original name and Value is obfuscated name

    public XMLStringManager(File stringFile, ArrayList<File> javaFiles, ArrayList<File> layoutFiles) {
        this.stringFile = stringFile;
        this.javaFiles = javaFiles;
        this.layoutFiles = layoutFiles;
    }

    public void obfuscateJavaFiles() {
        for (File file : javaFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(file);

            //Update java file references
            for(Map.Entry<String, String> entry : stringNameMappings.entrySet()){
                String regex = "(R[.]string[.])("+entry.getKey()+")([),])";
                String replacement = "$1"+entry.getValue()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedFile(file, sourceCode);
        }
    }

    public void obfuscateLayoutFiles() {
        for (File file : layoutFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(file);

            //Update java file references
            for(Map.Entry<String, String> entry : stringNameMappings.entrySet()) {
                String regex = "(@string[/])("+entry.getKey()+")(\")"; //assume this works
                String replacement = "$1"+entry.getValue()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedFile(file, sourceCode);
        }
    }

    public void populateStringNameMappings(){

            String sourceCode = FileHelper.getSourceCodeFromFile(stringFile);
            String regex = "[\"].*[\"]";

            ObfuscatedNamesProvider obfuscatedNamesProvider = new ObfuscatedNamesProvider();
            //TODO: RePlace ALPHABET with .STRING_VARS
            Deque<String> obfuscatedNames = obfuscatedNamesProvider.getObfuscatedNames( ObfuscatedNamesVariations.ALPHABET );

            //Find all names in the file
            List<String> allMatches = new ArrayList<String>();
            Matcher m = Pattern.compile(regex).matcher(sourceCode);
            while (m.find()) {
                allMatches.add(m.group());
            }

            //Store obfuscated names in a map
            for(String name : allMatches){
                stringNameMappings.put(name, obfuscatedNames.pollFirst());
            }
    }
}
