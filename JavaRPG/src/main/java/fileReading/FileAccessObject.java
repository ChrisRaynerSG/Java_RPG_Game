package fileReading;

import log.LogController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class FileAccessObject {
    public static List<String> getItemsAsStrings(){

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileName()))){
            return bufferedReader.lines()
                    .skip(1)
                    .toList();
        }
        catch (IOException e){
            LogController.log(Level.WARNING, "File to read not found returning empty");
            e.printStackTrace();
            return List.of();
        }
    }

    public static String getFileName() {
        return "src/main/resources/items.csv";
    }
}
