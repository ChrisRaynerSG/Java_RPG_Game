package entities.enemies;

public class Goblin extends Enemy {
    public Goblin(){
        this.setObjectName("Goblin");
        this.setMaxHealth(100);
        this.setCurrentHealth(getMaxHealth());
        this.setExperienceGiven(50);
    }
}
