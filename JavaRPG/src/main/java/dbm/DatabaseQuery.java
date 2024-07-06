package dbm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import static log.LogController.log;

public class DatabaseQuery implements Queryable {

    Connection connection;
    public DatabaseQuery(Connection connection){
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public ResultSet getResult(String query){
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }
        catch (SQLException e){
            log(Level.WARNING, "Invalid query provided to database");
            return null;
        }
    }
    @Override
    public void updateTable(String query){
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        }
        catch (SQLException e){
            log(Level.WARNING, "Unable to update Table");
        }
    }
    @Override
    public ResultSet getInventoryResults(int playerID){
            String query = "SELECT gi.item_name AS \"Item\", COUNT(inv.item_id) AS \"Amount\", gi.item_value AS \"Value\"," +
                    " gi.item_value*COUNT(inv.item_id) AS \"Total Value\"\n" +
                    "FROM rpg_database.inventory inv\n" +
                    "JOIN rpg_database.game_items gi ON inv.item_id = gi.item_id\n" +
                    "JOIN rpg_database.players pl ON inv.player_id = pl.player_id\n" +
                    "WHERE pl.player_id = " + playerID + "\n" +
                    "GROUP BY gi.item_name, gi.item_id\n" +
                    "ORDER BY gi.item_id ASC;";
            return getResult(query);
    }

    public ResultSet getHighScoreResults(){
        String query = "SELECT pl.player_name AS \"NAME\", hs.score AS \"SCORE\"\n" +
                "FROM rpg_database.high_scores hs\n" +
                "JOIN rpg_database.players pl ON pl.player_id = hs.player_id\n" +
                "ORDER BY hs.score DESC LIMIT 5;";
        return getResult(query);
    }

    @Override
    public void addToInventory(int itemID, int playerID){
        String query = INSERT_INTO + DATABASE_NAME + "." + INVENTORY_TABLE + "(item_id, player_id) VALUES (" + itemID + "," + playerID +");";
        updateTable(query);
        log(Level.FINE,"Item with ID: " + itemID + " added to player: " + playerID + "'s inventory.");
    }
    @Override
    public void removeFromInventory(int itemID, int playerID){
        String query = "DELETE FROM " + DATABASE_NAME + "." +INVENTORY_TABLE +  " " + WHERE + " item_id = " +itemID + " AND player_id = " + playerID + " LIMIT 1;";
        updateTable(query);
        log(Level.FINE,"Item with ID: " + itemID + " removed from player: " + playerID + "'s inventory.");
    }
    @Override
    public void createNewPlayer(String playerName){ //maybe int return type to manage playerID in database
        String createNewPlayerQuery = INSERT_INTO + DATABASE_NAME + "." + PLAYERS_TABLE + "(player_name, player_score) VALUES ('" + playerName + "', 0 );";
        updateTable(createNewPlayerQuery);
        String getPlayerIdQuery =  SELECT + " player_id FROM " + DATABASE_NAME + "." + PLAYERS_TABLE + " WHERE player_name = '" + playerName +"' ORDER BY player_id DESC LIMIT 1;";
        int playerID = DatabaseResults.getSingleIntResult(getResult(getPlayerIdQuery));
        log(Level.INFO, "New player " + playerName + " created with ID: " + playerID);
    }
    @Override
    public void updatePlayerScore(int playerID, int score){
        String query = "UPDATE " + DATABASE_NAME + "." + PLAYERS_TABLE + " SET player_score = " + score + " WHERE player_id = " + playerID +";";
        updateTable(query);
    }
    @Override
    public void updatePlayerHighScore(int playerID){
        String getPlayerScoreQuery = SELECT + " player_score FROM " + DATABASE_NAME + "." + PLAYERS_TABLE + " WHERE player_id = " + playerID + ";";
        int score = DatabaseResults.getSingleIntResult(getResult(getPlayerScoreQuery));
        String updatePlayerScoreToZeroQuery = "UPDATE " + DATABASE_NAME + "." + PLAYERS_TABLE + " SET player_score = 0 WHERE player_id = " + playerID + ";";
        updateTable(updatePlayerScoreToZeroQuery);
        String queryHighScoreUpdate = INSERT_INTO + DATABASE_NAME + "." + HIGH_SCORES_TABLE + "(score, player_id) VALUES (" + score + "," + playerID + ");";
        updateTable(queryHighScoreUpdate);
    }
}
