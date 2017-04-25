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
    private File rootPath;
    private HashMap<String, String> javaFileNameMappings;

    public XMLManager(ArrayList<File> xmlLayoutFiles, File rootPath,  HashMap<String, String> javaFileNameMappings) {
        this.xmlLayoutFiles = xmlLayoutFiles;
        this.rootPath = rootPath;
        this.javaFileNameMappings = javaFileNameMappings;
    }

    public void obfuscate() {

        this.obfuscateFilenames();

        for (File xmlLayoutFile : xmlLayoutFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(xmlLayoutFile);

            for(Map.Entry<String, String> entry : javaFileNameMappings.entrySet()){
                String regex = "([.])("+entry.getKey()+")(\")";
                String replacement = "$1"+entry.getValue()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedManifestFile(xmlLayoutFile, sourceCode);
        }
    }

    private void obfuscateFilenames ()
    {
        ObfuscatedNamesProvider obfuscatedNamesProvider = new ObfuscatedNamesProvider();
        Deque<String> obfuscatedNames = obfuscatedNamesProvider.getObfuscatedNames( ObfuscatedNamesVariations.ALPHABET );

        ArrayList<File> newXMLFiles = new ArrayList<>();

        for (File xmlLayoutFile : xmlLayoutFiles) {
            String obfuscatedFileName = obfuscatedNames.pollFirst();
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
