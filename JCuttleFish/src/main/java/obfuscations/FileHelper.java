package obfuscations;

import org.apache.commons.io.FileUtils;
import providers.FileSourceCodeProvider;

import java.io.File;
import java.io.IOException;

public class FileHelper {

    public static String getSourceCodeFromFile ( File file )
    {
        FileSourceCodeProvider fileSourceCodeProvider = new FileSourceCodeProvider();
        return fileSourceCodeProvider.get( file );
    }

    public static void saveObfuscatedFile (File file, String obfuscatedCode)
    {
        try
        {
            FileUtils.writeStringToFile( file, obfuscatedCode );
        } catch ( IOException ioe )
        {
            ioe.printStackTrace();
        }
    }
}
