package fileReading;

import log.LogController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class FileAccessObject {

    public static final String ITEMS_CSV_PATH = "src/main/resources/items.csv";

    public static List<String> getItemsAsStrings(){
        return getStringDataFromFile(ITEMS_CSV_PATH);
    }

    public static List<String> getStringDataFromFile(String fileName){
        LogController.log(Level.FINE, "Reading file: " + fileName);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
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
}

