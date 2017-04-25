package obfuscations.xmlobfuscation;

import obfuscations.FileHelper;
import org.apache.commons.io.FileUtils;
import providers.FileSourceCodeProvider;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class XMLManager {

    private Collection<File> xmlLayoutFiles;
    private HashMap<String, String> fileNameMappings;


    public XMLManager(Collection<File> xmlLayoutFiles, HashMap<String, String> fileNameMappings) {
        this.xmlLayoutFiles = xmlLayoutFiles;
        this.fileNameMappings = fileNameMappings;
    }

    public void obfuscate() {
        for (File xmlLayoutFile : xmlLayoutFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(xmlLayoutFile);

            for(Map.Entry<String, String> entry : fileNameMappings.entrySet()){
                String regex = "([.])("+entry.getKey()+")(\")";
                String replacement = "$1"+entry.getValue()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedManifestFile(xmlLayoutFile, sourceCode);
        }
    }
}
