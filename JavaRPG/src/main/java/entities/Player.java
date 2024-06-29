package Entities;

public abstract class Player extends GameObject implements PlayerActions{
    private String playerName;
    private String className;
    private int level =1;
    private int experience;
    private int totalExperience;
    private int maxHealth;
    private int currentHealth;
    private int damageModifier;
    private int totalAbilities;
    private int abilitiesRemaining;

    public Player(){
        setObjectName("Player");
        setLevel(1);
        setExperience(0);
        setTotalExperience(0);
        setCurrentHealth(getMaxHealth());
        setDamageModifier(3);
        setTotalAbilities(3);
        setAbilitiesRemaining(getTotalAbilities());
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName(){
        return playerName;
    }

    public void setClassName(String className){
        this.className = className;
    }

    public String getClassName(){
        return className;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel(){
        return this.level;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public int getExperience(){
        return this.experience;
    }

    public void setTotalExperience(int totalExperience){
        this.totalExperience = totalExperience;
    }

    public int getTotalExperience(){
        return totalExperience;
    }

    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public void setCurrentHealth(int currentHealth){
        this.currentHealth = currentHealth;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public void setDamageModifier(int damageModifier){
        this.damageModifier = damageModifier;
    }

    public int getDamageModifier(){
        return damageModifier;
    }

    public void setTotalAbilities(int totalAbilities){
        this.totalAbilities = totalAbilities;
    }

    public int getTotalAbilities(){
        return totalAbilities;
    }

    public void setAbilitiesRemaining(int abilitiesRemaining){
        this.abilitiesRemaining = abilitiesRemaining;
    }

    public int getAbilitiesRemaining(){
        return abilitiesRemaining;
    }

    public int isExperienceEnoughToLevelUp(int experience, int level){
        this.level = level;
        if(experience >= experienceNeeded()){
            while(experience >= experienceNeeded()){
                experience -= experienceNeeded();
                levelUp();
            }
            return experience;
        }
        return experience;
    }

    public abstract void levelUp();


    private int experienceNeeded(){
        return level*1000;
    }

    @Override
    public void playerRest(){
        this.abilitiesRemaining = totalAbilities;
    }

}
