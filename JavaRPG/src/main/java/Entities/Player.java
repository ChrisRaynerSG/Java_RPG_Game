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
        this.level = level;
        if(experience >= experienceNeeded(level)){
            while(experience >= experienceNeeded(level)){
                levelUp();
                experience -= experienceNeeded(level);
                level++;
            }
            return experience;
        }
        return experience;
    }

    private void levelUp(){
        //Maybe call level up class here to deal with text output regarding level up?
        this.level ++;
    }

    private int experienceNeeded(int level){
        return level*1000;
    }



}
