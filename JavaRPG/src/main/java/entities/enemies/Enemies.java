package entities.enemies;

public enum Enemies {
    GOBLIN(0, "Goblin"),
    KOBOLD(1, "Kobold"),
    ORC(2, "Orc"),
    TROLL(3,"Troll"),
    ZOMBIE(4,"Zombie"),
    BRIGAND(5,"Brigand"),
    ASSASSIN(6,"Assassin");

    private int enemyTypeID;
    private String enemyType;

    Enemies(int enemyTypeID, String enemyType){
        this.enemyTypeID = enemyTypeID;
        this.enemyType = enemyType;
    }
    public int getEnemyID(){
        return enemyTypeID;
    }
    public static String getEnemyType(int enemyID){
        return switch(enemyID){
            case 0 -> GOBLIN.enemyType;
            case 1 -> KOBOLD.enemyType;
            case 2 -> ORC.enemyType;
            case 3 -> TROLL.enemyType;
            default -> null;
        };
    }
}

