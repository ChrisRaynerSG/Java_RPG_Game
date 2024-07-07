package entities.enemies;

public class Goblin extends Enemy {
    public Goblin(){
        setObjectName("Goblin");
        setMaxHealth(100);
        setCurrentHealth(getMaxHealth());
        setExperienceGiven(50);
        setGoldGiven(10);
        setDescription("A puny goblin, foul mouthed and ill tempered");
    }
}
