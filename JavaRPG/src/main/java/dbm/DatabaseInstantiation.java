package dbm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static log.LogController.*;
import static dbm.Queryable.*;

public class DatabaseInstantiation {

    private final String itemsTable = "game_items" +
            " (item_id int NOT NULL AUTO_INCREMENT, item_name varchar(255) NOT NULL, item_value int NOT NULL, is_Key_Item BOOLEAN NOT NULL, item_description varchar(10000), healing_amount int, armour_bonus int, attack_bonus int, damage_bonus int, PRIMARY KEY (item_id) ); ";
    private final String highScoresTable ="high_scores" +
            " (high_score_id int NOT NULL AUTO_INCREMENT, score int , player_id int, PRIMARY KEY (high_score_id), FOREIGN KEY (player_id) REFERENCES players(player_id) ); ";
    private final String players = "players" +
            " (player_id int NOT NULL AUTO_INCREMENT, player_name varchar(20), player_score int, PRIMARY KEY (player_id) );";
    private final String inventory = "inventory" +
            " (inventory_id int NOT NULL AUTO_INCREMENT, item_id int, player_id int, PRIMARY KEY (inventory_id), FOREIGN KEY (item_id) REFERENCES game_items (item_id), FOREIGN KEY (player_id) REFERENCES players (player_id) );";

    private final String[] dbTables = {players, itemsTable, highScoresTable, inventory};

    public DatabaseInstantiation(Connection connection){
        try {
            Statement createTable = connection.createStatement();
            log(Level.FINE, "Entered creation of tables");

            for(String tableName : dbTables){
                createTable.execute(CREATE_TABLE + tableName);
                log(Level.FINER, "rpg_database table created");
            }
            log(Level.FINE, "rpg_database tables initialised");
            for(String values : GAME_ITEMS_LIST){
                createTable.execute(INSERT_INTO + GAME_ITEMS_TABLE + " " + ITEMS_TABLE_COLUMNS + " VALUES (" + values +")");
                log(Level.FINER, "Successfully added game item");
            }
            log(Level.FINE, "Game items successfully populated");
        }
        catch (SQLException e){
            log(Level.SEVERE, "Database failed to instantiate");
            e.printStackTrace();
        }
    }
}
