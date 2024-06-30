package entities.enemies;

import entities.Enemy;

public class Orc extends Enemy {
    public Orc(){
        this.setObjectName("Orc");
        this.setMaxHealth(200);
        this.setCurrentHealth(getMaxHealth());
        this.setExperienceGiven(100);
    }
}
