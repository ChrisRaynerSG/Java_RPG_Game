package Entities;

public abstract class Player extends GameObject{
    private String playerName;
    private int level =1;
    private int experience;
    private int totalExperience;
    private int maxHealth;
    private int currentHealth;
    private int damageModifier;


    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }



    public int isExperienceEnoughToLevelUp(int experience, int level){
        if(experience >= experienceNeeded(level)){
            while(experience>= experienceNeeded(level)){
            experience -= experienceNeeded(level);
            levelUp();
            }
            return experience;
        }
        return experience;
    }

    public void levelUp(){
        this.level ++;
    }

    public int experienceNeeded(int level){
        return level*1000;
    }



}
