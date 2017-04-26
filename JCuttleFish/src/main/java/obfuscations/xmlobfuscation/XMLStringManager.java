package obfuscations.xmlobfuscation;

import obfuscations.FileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
                String regex = "(R[.]string[.])("+entry.getValue()+")([),])";
                String replacement = "$1"+entry.getKey()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedFile(file, sourceCode);
        }
    }

    public void obfuscateLayoutFiles() {
        
    }
}
