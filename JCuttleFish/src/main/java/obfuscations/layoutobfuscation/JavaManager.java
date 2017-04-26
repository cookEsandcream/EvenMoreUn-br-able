package obfuscations.layoutobfuscation;

import obfuscations.FileHelper;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JavaManager {

    private ArrayList<File> javaFiles;
    private HashMap<String, String> xmlFileNameMapping;

    public JavaManager(ArrayList<File> javaFiles, HashMap<String, String> xmlFileNameMapping) {
        this.javaFiles = javaFiles;
        this.xmlFileNameMapping = xmlFileNameMapping;
    }

    public void obfuscate() {

        for (File file : javaFiles) {
            String sourceCode = FileHelper.getSourceCodeFromFile(file);

            //Update java file references
            for(Map.Entry<String, String> entry : xmlFileNameMapping.entrySet()){
                String regex = "(R[.]layout[.])("+entry.getValue()+")([),])";
                String replacement = "$1"+entry.getKey()+"$3";
                sourceCode = sourceCode.replaceAll(regex, replacement);
            }

            FileHelper.saveObfuscatedFile(file, sourceCode);
        }
    }
}
