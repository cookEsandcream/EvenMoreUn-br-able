package obfuscations.xmlobfuscation;

import obfuscations.FileHelper;
import providers.ObfuscatedNamesProvider;
import util.enums.ObfuscatedNamesVariations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class XMLManager {

    private ArrayList<File> xmlLayoutFiles;
    private HashMap<String, String> javaFileNameMappings;
    public static HashMap<String, String> xmlFileNameMapping = new HashMap<>();

    public XMLManager(ArrayList<File> xmlLayoutFiles, HashMap<String, String> javaFileNameMappings) {
        this.xmlLayoutFiles = xmlLayoutFiles;
        this.javaFileNameMappings = javaFileNameMappings;
    }

    public void obfuscate() {

        //Obfuscate Filenames
        this.obfuscateFilenames();

        for (File xmlLayoutFile : xmlLayoutFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(xmlLayoutFile);

            //Update java file references
            for(Map.Entry<String, String> entry : javaFileNameMappings.entrySet()){
                String regex = "([.])("+entry.getValue()+")(\")";
                String replacement = "$1"+entry.getKey()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            //Update xml id references
            String fileName = xmlLayoutFile.getName();
            fileName = fileName.substring(0, fileName.length()-4);

            String regex = "(@[+]id/)("+xmlFileNameMapping.get(fileName)+")(\")";
            String replacement = "$1"+fileName+"$3";
            sourceCode = sourceCode.replaceAll(regex, replacement);

            //Remove XML Comments
            regex = "(<!--)(.*)(-->)";
            replacement = "";
            sourceCode = sourceCode.replaceAll(regex, replacement);

            FileHelper.saveObfuscatedFile(xmlLayoutFile, sourceCode);
        }
    }

    private void obfuscateFilenames ()
    {
        ObfuscatedNamesProvider obfuscatedNamesProvider = new ObfuscatedNamesProvider();
        Deque<String> obfuscatedNames = obfuscatedNamesProvider.getObfuscatedNames( ObfuscatedNamesVariations.ALPHABET );

        ArrayList<File> newXMLFiles = new ArrayList<>();

        for (File xmlLayoutFile : xmlLayoutFiles) {
            String obfuscatedFileName = obfuscatedNames.pollFirst();
            String fileName = xmlLayoutFile.getName();
            fileName = fileName.substring(0, fileName.length()-4);
            xmlFileNameMapping.put(obfuscatedFileName, fileName);

            File newFile = this.renameXMLFileTo( xmlLayoutFile, obfuscatedFileName);

            newXMLFiles.add(newFile);
        }

        this.xmlLayoutFiles = newXMLFiles;
    }

    private File renameXMLFileTo ( File file, String newNameWithoutPrefix )
    {
        Path renamedFile = null;
        try
        {
            renamedFile = Files.move( file.toPath(), file.toPath().resolveSibling( newNameWithoutPrefix + ".xml" ) );
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
        assert renamedFile != null;
        return renamedFile.toFile();
    }
}
