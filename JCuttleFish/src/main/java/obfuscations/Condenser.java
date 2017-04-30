package obfuscations;

import extractor.PathsExtractor;
import extractor.filefilters.SuffixFolderFilter;
import extractor.filefilters.enums.SuffixFilters;

import java.io.File;
import java.util.Collection;

public class Condenser {

    public static void condense(String originalAbsolutePath, String mainPath) {
        File javaFilePath = new File( originalAbsolutePath );
        File layoutPath = new File( mainPath+"\\res\\layout" );
        File valuesPath = new File( mainPath+"\\res\\values");


        Collection<File> javaFiles = getAbsolutePathsJava( javaFilePath.getAbsolutePath() );
        condenseFiles(javaFiles);

        Collection<File> layoutFiles = getAbsolutePathsXML( layoutPath.getAbsolutePath() );
        condenseFiles(layoutFiles);

        Collection<File> valuesFiles = getAbsolutePathsXML( valuesPath.getAbsolutePath() );
        condenseFiles(valuesFiles);

        File manifestFile = new File(mainPath+"\\AndroidManifest.xml");
        condenseFile(manifestFile);
    }

    public static void condenseFiles(Collection<File> files) {
        for (File file : files) {
            condenseFile(file);
        }
    }

    public static void condenseFile(File file) {
        String sourceCode = FileHelper.getSourceCodeFromFile(file);

        sourceCode = sourceCode.replaceAll("\r", "");
        sourceCode = sourceCode.replaceAll("\t", "");
        sourceCode = sourceCode.replaceAll("\n", "");

        FileHelper.saveObfuscatedFile(file, sourceCode);
    }

    private static Collection<File> getAbsolutePathsJava ( String rootAbsolutePath )
    {
        PathsExtractor pathsExtractor = new PathsExtractor( rootAbsolutePath );
        return pathsExtractor.getFilesInstances( new SuffixFolderFilter( SuffixFilters.JAVA ) );
    }

    private static Collection<File> getAbsolutePathsXML ( String rootAbsolutePath )
    {
        PathsExtractor pathsExtractor = new PathsExtractor( rootAbsolutePath );
        return pathsExtractor.getFilesInstances( new SuffixFolderFilter( SuffixFilters.XML ) );
    }
}
