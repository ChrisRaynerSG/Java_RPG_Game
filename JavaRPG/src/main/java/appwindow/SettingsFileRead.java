package appwindow;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import static log.LogController.log;

public class SettingsFileRead {

    public static Dimension readSettingsFileWindowSize(){
        try{
            BufferedReader settingsFileReader = new BufferedReader(new FileReader("src/main/resources/Settings.cfg"));
            String line = null;
            log(Level.FINER, "Reading settings file to find window size");
            while ((line = settingsFileReader.readLine())!=null){
                log(Level.FINEST, "Looping through settings lines current line is:" + line);
                if (line.contains("Window size:")){
                    if(line.contains("Small")){
                        return new Dimension(500,500);
                    } else if (line.contains("Medium")) {
                        return new Dimension(1280,720);
                    } else if (line.contains("Large")) {
                        return new Dimension(1920,1080);
                    }
                }
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        return new Dimension(500,500);
    }

    public static ArrayList<String> readSettingsFileLines(){
        ArrayList<String> lines = new ArrayList<>();
        try{
            BufferedReader settingsFileReader = new BufferedReader(new FileReader("src/main/resources/Settings.cfg"));
            String line = null;
            while ((line = settingsFileReader.readLine())!=null){
                lines.add(line);
                log(Level.FINE, line + "added to settings.cfg Array List");
            }
            return lines;

        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
