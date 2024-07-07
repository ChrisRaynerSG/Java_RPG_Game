package dbm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;

import static log.LogController.log;

public class DatabaseResults{

    public static ArrayList<String[]> getPlayerInventory(int playerID){

        ArrayList<String[]> resultsToList = new ArrayList<>();
        HashSet<String> isItemEquippableSet = new HashSet<>();
        DatabaseQuery inventoryResults = new DatabaseQuery(DatabaseConnection.getConnection());
        ResultSet results = inventoryResults.getInventoryResults(playerID);
        ResultSet isItemEquipable = inventoryResults.equippableItemsList();

        try{

            while (isItemEquipable.next()){
                isItemEquippableSet.add(isItemEquipable.getString(1));
            }

            while(results.next()){
                String[] resultsInRow = {"","","","",""};
                resultsInRow[0] = results.getString(1);
                resultsInRow[1] = results.getString(2);
                resultsInRow[2] = results.getString(3);
                resultsInRow[3] = results.getString(4);
                if(isItemEquippableSet.contains(resultsInRow[0])){
                    resultsInRow[4] = "Equip";
                }
                else{
                    resultsInRow[4] = "Use";
                }
                resultsToList.add(resultsInRow);
            }
            return resultsToList;
        }
        catch (SQLException e){
            log(Level.INFO, "No inventory found!");
            return resultsToList;
        }
    }

    public static ArrayList<String[]> getHighScores(){
        ArrayList<String[]> resultsToList = new ArrayList<>();
        String[] highScoreHeadings = {"NAME","SCORE"};
        resultsToList.add(highScoreHeadings);
        DatabaseQuery highScoreResults = new DatabaseQuery(DatabaseConnection.getConnection());
        ResultSet results = highScoreResults.getHighScoreResults();
        try{
            while(results.next()){
                String[] resultsInRow = {"",""};
                resultsInRow[0] = results.getString(1);
                resultsInRow[1] = results.getString(2);
                resultsToList.add(resultsInRow);
            }
            return resultsToList;
        }
        catch (SQLException e){
            log(Level.INFO,"No high scores found!");
            return resultsToList;
        }
    }

    public static int getSingleIntResult(ResultSet singleIntResultSet){
        try {
            while(singleIntResultSet.next()){
                return singleIntResultSet.getInt(1);
            }
            return singleIntResultSet.getInt(1);
        }
        catch (SQLException e){
            log(Level.WARNING, "Unable to get single int result!");
            return -1;
        }
    }
    public static int[] getTwoIntResult(ResultSet twoIntResultSet) {
        int[] results = {0,0};
        try {
            while (twoIntResultSet.next()) {
                results[0] = twoIntResultSet.getInt(1);
                results[1] = twoIntResultSet.getInt(2);
            }
            return results;
        }
        catch (SQLException e) {
            log(Level.WARNING, "Unable to get single int result!");
            return results;
        }
    }
}
