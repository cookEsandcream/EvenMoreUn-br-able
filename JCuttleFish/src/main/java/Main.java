import configuration.ConfigurationEnvironment;
import obfuscations.Condenser;
import obfuscations.ObfuscationCoordinator;


public class Main
{

    public static void main ( String[] args )
    {
        if (args[0].equals("condense")) {
            String originalLocationPath = args[1];
            String mainPath = args[3];

            Condenser.condense(originalLocationPath, mainPath );
        } else {
            String originalLocationPath = args[0];
            String backupLocationPath = args[1];
            String mainPath = args[2];

            ConfigurationEnvironment.createConfigurationInstance(originalLocationPath);

            new ObfuscationCoordinator(originalLocationPath, backupLocationPath, mainPath);
        }
    }

}
