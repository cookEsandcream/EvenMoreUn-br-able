import configuration.ConfigurationEnvironment;
import obfuscations.ObfuscationCoordinator;


public class Main
{

    public static void main ( String[] args )
    {
        String originalLocationPath = args[ 0 ];
        String backupLocationPath = args[ 1 ];
        String manifestPath = args[ 2 ];
        String xmlLocationPath = args[ 3 ];

        ConfigurationEnvironment.createConfigurationInstance( originalLocationPath );

        new ObfuscationCoordinator( originalLocationPath, backupLocationPath, manifestPath, xmlLocationPath );
    }

}
