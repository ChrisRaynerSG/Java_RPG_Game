package entities.enemies;

public class Orc extends Enemy {
    public Orc(){
        this.setObjectName("Orc");
        this.setMaxHealth(200);
        this.setCurrentHealth(getMaxHealth());
        this.setExperienceGiven(100);
    }
}
