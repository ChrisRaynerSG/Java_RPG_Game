package dbm;

import fileReading.FileAccessObject;

import java.sql.ResultSet;
import java.util.List;

public interface Queryable {

    String DATABASE_NAME = "rpg_database";
    String CREATE_DATABASE = "CREATE DATABASE " + DATABASE_NAME;
    String CREATE_TABLE = "CREATE TABLE ";
    String INSERT_INTO = "INSERT INTO ";
    String GAME_ITEMS_TABLE = "game_items";
    String PLAYERS_TABLE = "players";
    String INVENTORY_TABLE = "inventory";
    String HIGH_SCORES_TABLE = "high_scores";
    String SELECT = "SELECT ";
    String WHERE = "WHERE";

    String ITEMS_TABLE_COLUMNS = "(item_name, item_value, is_key_item, item_description, healing_amount, armour_bonus, attack_bonus, damage_bonus)";

    List<String> GAME_ITEMS_LIST = FileAccessObject.getItemsAsStrings();

    ResultSet getInventoryResults(int PlayerID);
    ResultSet getResult(String query);
    void updateTable(String query);
    void addToInventory(int itemID, int playerID);
    void removeFromInventory(int itemID, int playerID);
    int createNewPlayer(String playerName);
    void updatePlayerScore(int playerID, int score);
    void updatePlayerHighScore(int PlayerID);



}
