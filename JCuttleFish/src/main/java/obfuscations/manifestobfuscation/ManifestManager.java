package obfuscations.manifestobfuscation;

import org.apache.commons.io.FileUtils;
import providers.FileSourceCodeProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManifestManager {

    private File manifestFile;
    private HashMap<String, String> fileNameMappings;

    public ManifestManager(File manifestFile, HashMap<String, String> fileNameMappings) {
        this.manifestFile = manifestFile;
        this.fileNameMappings = fileNameMappings;
    }

    public void obfuscate() {
        String sourceCode = getSourceCodeFromFile(manifestFile);

        for(Map.Entry<String, String> entry : fileNameMappings.entrySet()){
            String regex = "(.)("+entry.getKey()+")(\")";
            String replacement = "$1"+entry.getValue()+"$3";
            sourceCode = sourceCode.replaceAll(regex, replacement);
        }

        saveObfuscatedManifestFile(sourceCode);
    }

    private String getSourceCodeFromFile ( File file )
    {
        FileSourceCodeProvider fileSourceCodeProvider = new FileSourceCodeProvider();
        return fileSourceCodeProvider.get( file );
    }

    private void saveObfuscatedManifestFile (String obfuscatedCode)
    {
        try
        {
            FileUtils.writeStringToFile( manifestFile, obfuscatedCode );
        } catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }
}
