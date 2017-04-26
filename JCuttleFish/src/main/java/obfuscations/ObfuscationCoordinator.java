package obfuscations;

import extractor.PathsExtractor;
import extractor.filefilters.SuffixFolderFilter;
import extractor.filefilters.enums.SuffixFilters;
import obfuscations.filenameobfuscation.FilenameManager;
import obfuscations.layoutobfuscation.JavaManager;
import obfuscations.layoutobfuscation.LayoutManager;
import obfuscations.manifestobfuscation.ManifestManager;
import obfuscations.xmlobfuscation.XMLManager;
import obfuscations.xmlobfuscation.XMLStringManager;
import org.apache.commons.io.FileUtils;
import parser.UnitSourceInitiator;
import pojo.UnitNode;
import pojo.UnitSource;
import util.BackupFilesHelper;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static obfuscations.filenameobfuscation.FilenameManager.fileNameMapping;
import static obfuscations.xmlobfuscation.XMLManager.xmlFileNameMapping;


//manages the different types of obfuscations and the order they will be applied.
public class ObfuscationCoordinator
{

    public ObfuscationCoordinator ( String originalAbsolutePath, String backupAbsolutePath, String mainPath )
    {
        File originalLocation = new File( originalAbsolutePath );
        File backupLocation = new File( backupAbsolutePath );
        File manifestFile = new File(mainPath+"\\AndroidManifest.xml");
        File xmlLocation = new File( mainPath+"\\res\\layout" );
        BackupFilesHelper.backupFiles( originalLocation, backupLocation, xmlLocation, manifestFile );
        Collection<File> originalFiles = this.getAbsolutePaths( originalLocation.getAbsolutePath() );

        UnitSourceInitiator initiator = new UnitSourceInitiator();

        Collection<UnitSource> unitSources = initiator.fetchUnitSourceCollection( originalFiles );
        Collection<UnitNode> unitNodes = new NodeFinder().getUnitNodesCollectionFromUnitSources( unitSources );

        LayoutManager layoutManager = new LayoutManager();
        layoutManager.obfuscate( unitNodes );

        FilenameManager filenameManager = new FilenameManager( originalLocation );
        filenameManager.obfuscate( unitNodes );

        ManifestManager manifestManager = new ManifestManager(manifestFile, fileNameMapping);
        manifestManager.obfuscate();

        this.saveUnitSourcesToFiles( unitSources );

        ArrayList<File> xmlFiles = (ArrayList) this.getAbsolutePathsXML( xmlLocation.getAbsolutePath() );
        XMLManager xmlManager = new XMLManager(xmlFiles, fileNameMapping);
        xmlManager.obfuscate();

        ArrayList<File> javaFiles = (ArrayList) this.getAbsolutePaths( originalLocation.getAbsolutePath() );
        JavaManager javaManager = new JavaManager(javaFiles, xmlFileNameMapping);
        javaManager.obfuscate();
    }

    private void saveUnitSourcesToFiles ( Collection<UnitSource> unitSources )
    {
        for ( UnitSource unitSource : unitSources )
        {
            try
            {
                FileUtils.writeStringToFile( unitSource.getFile(), unitSource.getDocument().get() );
            } catch ( IOException ioe )
            {
                ioe.printStackTrace();
            }
        }
    }

    private Collection<File> getAbsolutePaths ( String rootAbsolutePath )
    {
        PathsExtractor pathsExtractor = new PathsExtractor( rootAbsolutePath );
        return pathsExtractor.getFilesInstances( new SuffixFolderFilter( SuffixFilters.JAVA ) );
    }

    private Collection<File> getAbsolutePathsXML ( String rootAbsolutePath )
    {
        PathsExtractor pathsExtractor = new PathsExtractor( rootAbsolutePath );
        return pathsExtractor.getFilesInstances( new SuffixFolderFilter( SuffixFilters.XML ) );
    }
}