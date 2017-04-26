package obfuscations.manifestobfuscation;

import obfuscations.FileHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class ManifestManager {

    private File manifestFile;
    private HashMap<String, String> fileNameMappings;

    public ManifestManager(File manifestFile, HashMap<String, String> fileNameMappings) {
        this.manifestFile = manifestFile;
        this.fileNameMappings = fileNameMappings;
    }

    public void obfuscate() {
        String sourceCode = FileHelper.getSourceCodeFromFile(manifestFile);

        for(Map.Entry<String, String> entry : fileNameMappings.entrySet()){
            String regex = "([.])("+entry.getValue()+")(\")";
            String replacement = "$1"+entry.getKey()+"$3";
            sourceCode = sourceCode.replaceAll(regex, replacement);
        }

        FileHelper.saveObfuscatedFile(manifestFile, sourceCode);
    }
}
