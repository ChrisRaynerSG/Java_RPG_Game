package appwindow;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import static log.LogController.log;

public class SettingsFileWrite {

    public static void writeToFileInit(String config){
        try{
            FileWriter writeToFile = new FileWriter("src/main/resources/Settings.cfg");
            writeToFile.write(config);
            writeToFile.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    
    public static void writeToFileWindowSize(String config){
        try{
            ArrayList<String> lines = SettingsFileRead.readSettingsFileLines();
            lines.set(1,config);
            log(Level.FINE, lines.toString());

            FileWriter writeToFile = new FileWriter("src/main/resources/Settings.cfg");
            for(String line : lines){
                log(Level.FINER, line);
                writeToFile.write(line + "\n");
            }
            writeToFile.close();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
