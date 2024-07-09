package appwindow;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import static log.LogController.log;

public class SettingsFileInit {

    public SettingsFileInit(){
        try{
            File settingsFile = new File("src/main/resources/Settings.cfg");
            if(settingsFile.createNewFile()){
                log(Level.INFO, "Settings file initialised: " + settingsFile.getName() + ". Initiating default settings");
                SettingsFileWrite.writeToFileInit("Settings configuration file\n" +
                        "Window size: Small\n" +
                        "End of config file.");
            }
            else{
                log(Level.INFO, "Settings file detected applying user settings.");
            }
        }
        catch (IOException e){
            log(Level.WARNING, "Error creating Settings file");
            throw new RuntimeException(e);
        }
    }

}
