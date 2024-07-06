package appwindow;


import dbm.DatabaseConnection;
import dbm.DatabaseQuery;
import dbm.DatabaseResults;
import log.LogController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

//        LogController logController = new LogController();
//        SettingsFileInit settingsFileInit = new SettingsFileInit();
//        AppWindow window = new AppWindow();

//        System.out.println(DatabaseConnection.getConnection());
//        DatabaseConnection.closeConnection();

        DatabaseQuery databaseTests = new DatabaseQuery(DatabaseConnection.getConnection());
        databaseTests.addToInventory(1,1);
        databaseTests.addToInventory(15,1);
        databaseTests.addToInventory(6,1);
        databaseTests.addToInventory(3,1);
        databaseTests.addToInventory(6,1);
        databaseTests.addToInventory(6,1);
        databaseTests.addToInventory(6,1);
        databaseTests.removeFromInventory(8,1);
        for (int i = 0; i<15; i++) {
            databaseTests.removeFromInventory(6, 1);
        }
        ArrayList<String[]> inventory = DatabaseResults.getPlayerInventory(1);
        for(String[] row : inventory){
            System.out.println(Arrays.toString(row));
        }

        ArrayList<String[]> highScores = DatabaseResults.getHighScores();
        for(String[] row : highScores){
            System.out.println(Arrays.toString(row));
        }
    }
}
