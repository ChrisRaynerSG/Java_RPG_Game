package gameloop;

import entities.enemies.*;

public class EnemyFactory {
    public static Enemy getEnemy(String enemyName){
        return switch (enemyName){
            case "Goblin" -> new Goblin();
            case "Troll" -> new Troll();
            case "Orc" -> new Orc();
            case "Kobold" -> new Kobold();
            default -> null;
        };
    }
}
