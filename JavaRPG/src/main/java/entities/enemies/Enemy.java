package entities.enemies;

import entities.GameObject;

public class Enemy extends GameObject {
    private int maxHealth;
    private int currentHealth;
    private int experienceGiven;
    private int goldGiven;

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getExperienceGiven() {
        return experienceGiven;
    }

    public void setExperienceGiven(int experienceGiven) {
        this.experienceGiven = experienceGiven;
    }

    public int getGoldGiven(){
        return goldGiven;
    }
    public void setGoldGiven(int goldGiven){
        this.goldGiven = goldGiven;
    }

    public boolean isDead(){
        return currentHealth < 0;
    }
}
