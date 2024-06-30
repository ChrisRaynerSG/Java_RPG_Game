package entities.enemies;

import entities.Enemy;

public class Troll extends Enemy{
    public Troll(){
        this.setObjectName("Troll");
        this.setMaxHealth(500);
        this.setCurrentHealth(getMaxHealth());
        this.setExperienceGiven(250);
    }
}
