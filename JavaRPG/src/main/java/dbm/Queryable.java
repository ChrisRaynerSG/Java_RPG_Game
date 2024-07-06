package dbm;

import java.sql.ResultSet;

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
    String WEAK_POTION = "('Weak healing potion', 20, false, 'A weak potion healing 50HP.', 50, NULL, NULL, NULL );";
    String AVERAGE_POTION = "('Average healing potion', 50, false, 'An average potion healing 100HP.', 100, NULL, NULL, NULL );";
    String STRONG_POTION = "('Strong healing potion', 100, false, 'A strong potion healing 200HP.', 200, NULL, NULL, NULL );";
    String MAX_POTION = "('Max healing potion', 250, false, 'A very strong potion healing all health lost.', 2147483647, NULL, NULL, NULL );";
    String ABILITY_POTION = "('Ability potion', 200, false, 'A potion that restores all ability points.', NULL, NULL, NULL, NULL );";
    String ABILITY_UP_POTION = "('Ability up potion', 1000, false, 'A potion that permanently grants an additional ability point.', NULL, NULL, NULL, NULL );";
    String XP_POTION = "('XP potion', 500, false, 'A potion that instantly grants 1000xp.', NULL, NULL, NULL, NULL );";
    String ELIXIR = "('Elixir of undying', 1000, false, 'A magical drink that will prevent death the next time health drops below 0.', NULL, NULL, NULL, NULL );";
    String LEATHER_ARMOUR = "('Leather armour', 250, false, 'A set of Leather armour providing +1 AC.', NULL, 1, NULL, NULL );";
    String PADDED_ARMOUR = "('Padded armour', 400, false, 'A set of padded armour providing +2 AC.', NULL, 2, NULL, NULL );";
    String CHAIN_ARMOUR = "('Chain armour', 600, false, 'A set of chain armour providing +3 AC.', NULL, 3, NULL, NULL );";
    String SPLINT_ARMOUR = "('Splint armour', 800, false, 'A set of splint armour providing +4 AC.', NULL, 4, NULL, NULL );";
    String HALF_PLATE_ARMOUR = "('Half plate', 1000, false, 'Half plate armour providing +6 AC.', NULL, 6, NULL, NULL );";
    String PLATE_ARMOUR = "('Full plate', 1500, false, 'Full plate armour providing +8 AC.', NULL, 8, NULL, NULL );";
    String MAGIC_ARMOUR = "('Magic plate', 2000, false, 'Magical full plate providing +10 AC.', NULL, 10, NULL, NULL );";
    String DAGGER = "('Dagger', 50, false, 'A simple dagger granting +1 attack bonus and x2 damage modifier.', NULL, NULL, 1, 2 );";
    String SHORT_SWORD = "('Short sword', 100, false, 'A simple short sword granting +2 attack bonus and x2 damage modifier.', NULL, NULL, 2, 2 );";
    String RAPIER = "('Rapier', 300, false, 'An elegant rapier granting +2 attack bonus and x4 damage modifier.', NULL, NULL, 2, 4 );";
    String BROADSWORD = "('Broadsword', 300, false, 'An imposing broadsword granting +3 attack bonus and x3 damage modifier.', NULL, NULL, 3, 3 );";
    String LONGSWORD = "('Longsword', 500, false, 'A deadly longsword granting +4 attack bonus and x3 damage modifier.', NULL, NULL, 4, 3 );";
    String BASTARD_SWORD = "('Bastard sword', 750, false, 'Why are you laughing? A mighty sword granting +2 attack bonus and x5 damage modifier.', NULL, NULL, 2, 5 );";
    String GREATSWORD = "('Greatsword', 1000, false, 'A comically large greatsword granting +2 attack bonus and x6 damage modifier.', NULL, NULL, 2, 6 );";
    String MAGIC_GREATSWORD = "('Magical greatsword', 2500, false, 'A magical weapon of gods granting +5 attack bonus and x10 damage modifier.', NULL, NULL, 5, 10 );";
    String HAND_AXE = "('Hand axe', 100, false, 'A simple axe granting +0 attack bonus and x3 damage modifier.', NULL, NULL,0, 3 );";
    String BATTLE_AXE = "('Battle axe', 200, false, 'A dangerous axe granting +0 attack bonus and x4 damage modifier.', NULL, NULL, 0, 4 );";
    String GREAT_AXE = "('Great axe', 400, false, 'A mighty Axe granting -1 attack bonus and x8 damage modifier.', NULL, NULL, -1, 8 );";
    String CLUB = "('Club', 10, false, 'A glorified stick granting +1 attack bonus and x1 damage modifier.', NULL, NULL, 1, 1 );";
    String MACE = "('Mace', 75, false, 'Try not to get it in your eyes - blunt weapon granting +1 attack bonus and x3 damage modifier.', NULL, NULL, 1, 3 );";
    String HEAVY_MACE = "('Heavy mace', 250, false, 'Like a mace, just bigger granting +1 attack bonus and x4 damage modifier.', NULL, NULL, 1, 4 );";
    String GREAT_MACE = "('Great mace', 500, false, 'Like a heavy mace, but a lot bigger granting +0 attack bonus and x8 damage modifier.', NULL, NULL, 0, 8 );";
    String DOM = "('Dagger of Murder', 4000, false, 'A lightweight magical dagger, covered in the blood of baby giraffes granting +10 attack bonus and x10 damage modifier.', NULL, NULL, 10, 10 );";
    String SWORD_OF_SLICING = "('Sword of slicing', 4000, false, 'Is it even possible to miss with this? A magical sword granting +20 attack bonus and x6 damage modifier.', NULL, NULL, 20, 6 );";
    String MOB = "('Mace of ten thousand bruises', 5000, false, 'This weapon does the most damage in the game, bruises hurt okay. A magical mace granting +4 attack bonus and x15 damage modifier.', NULL, NULL, 4, 15 );";
    String RUBBER_CHICKEN = "('Rubber chicken', 5, false, 'Why would you even equip this? A joke chicken granting -4 attack bonus and x1 damage modifier.', NULL, NULL, -4, 1 );";
    String DUNGEON_KEY = "('Dungeon key', 1, true, 'A key to unlock doors in a dungeon, but which one?', NULL, NULL, NULL, NULL );";
    String CASTLE_KEY = "('Castle key', 1, true, 'A key to unlock doors in a castle, but where is the castle?', NULL, NULL, NULL, NULL );";
    String TOMB_KEY = "('Tomb key', 1, true, 'A key to unlock doors in the tomb of one million giant bunnies of doom and despair and general chaos. But why would you want to go there?', NULL, NULL, NULL, NULL );";
    String ORB_OF_ORBING = "('Orb of orbing', 1000000, true, 'With this magical orb, you can orb all you like, because its the orb of orbing of course. The most valuable item in the game, shame you wont be able to sell it.', NULL, NULL, NULL, NULL );";

    String[] GAME_ITEMS_ARRAY = {WEAK_POTION,AVERAGE_POTION,STRONG_POTION,MAX_POTION,ABILITY_POTION,ABILITY_UP_POTION,XP_POTION,ELIXIR,LEATHER_ARMOUR,PADDED_ARMOUR,CHAIN_ARMOUR,SPLINT_ARMOUR,HALF_PLATE_ARMOUR
    ,PLATE_ARMOUR,MAGIC_ARMOUR,DAGGER,SHORT_SWORD,RAPIER,BROADSWORD,LONGSWORD,BASTARD_SWORD,GREATSWORD,MAGIC_GREATSWORD,HAND_AXE,BATTLE_AXE,GREAT_AXE,CLUB,MACE,HEAVY_MACE,GREAT_MACE,DOM,SWORD_OF_SLICING
    ,MOB,RUBBER_CHICKEN,DUNGEON_KEY,CASTLE_KEY,TOMB_KEY,ORB_OF_ORBING};

    ResultSet getInventoryResults(int PlayerID);
    ResultSet getResult(String query);
    void updateTable(String query);
    void addToInventory(int itemID, int playerID);
    void removeFromInventory(int itemID, int playerID);
    void createNewPlayer(String playerName);
    void updatePlayerScore(int playerID, int score);
    void updatePlayerHighScore(int PlayerID);



}
