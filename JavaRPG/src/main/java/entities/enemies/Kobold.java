package entities.enemies;

import entities.Enemy;

public class Kobold extends Enemy {
    public Kobold(){
        this.setObjectName("Kobold");
        this.setMaxHealth(75);
        this.setCurrentHealth(getMaxHealth());
        this.setExperienceGiven(25);
    }
}
