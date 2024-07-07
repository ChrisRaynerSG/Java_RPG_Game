package entities.player;

import dbm.DatabaseConnection;
import dbm.DatabaseQuery;
import dbm.ItemValues;
import entities.GameObject;

import java.util.logging.Level;

import static log.LogController.log;

public abstract class Player extends GameObject implements PlayerActions{

    //todo Player has S.P.E.C.I.A.L. / Abilities?

    private String playerName;
    private String className;
    private int databaseID;
    private int level =1;
    private int experience;
    private int totalExperience;
    private int maxHealth;
    private int currentHealth;
    private int attackBonus;
    private int damageModifier;
    private int armourClass;
    private int totalAbilities;
    private int abilitiesRemaining;
    private int gold;
    private String currentWeapon;
    private String currentArmour;

    public Player(){
        log(Level.CONFIG, "New player created");
        setObjectName("Player");
        setLevel(1);
        setExperience(0);
        setTotalExperience(0);
        setCurrentHealth(getMaxHealth());
        setDamageModifier(3);
        setTotalAbilities(3);
        setAbilitiesRemaining(getTotalAbilities());
        setArmourClass(10);
        setDescription("The player!");

    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
        if(databaseID == 0){
            initialPlayerDbSetup();
        }
    }

    public String getPlayerName(){
        return playerName;
    }

    public int getDatabaseID(){
        return databaseID;
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

    public void setAttackBonus(int attackBonus){
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus(){
        return attackBonus;
    }

    public void setDamageModifier(int damageModifier){
        this.damageModifier = damageModifier;
    }

    public int getDamageModifier(){
        return damageModifier;
    }

    public void setArmourClass(int armourClass){
        this.armourClass = armourClass;
    }

    public int getArmourClass(){
        return armourClass;
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

    public void setCurrentWeapon(String currentWeapon){
        this.currentWeapon = currentWeapon;
    }
    public String getCurrentWeapon(){
        return currentWeapon;
    }

    public void setCurrentArmour(String currentArmour){
        this.currentArmour = currentArmour;
    }

    public String getCurrentArmour(){
        return currentArmour;
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

    public boolean isPlayerDead(){
        return this.currentHealth > 0;
    }
    public boolean isOverMaxHealth(int healAmount){
        return currentHealth + healAmount > maxHealth;
    }
    public boolean hasNoAbilitiesRemaining(){
        return abilitiesRemaining == 0;
    }
    private void initialPlayerDbSetup(){
        DatabaseQuery initialDbSetup = new DatabaseQuery(DatabaseConnection.getConnection());
        databaseID = initialDbSetup.createNewPlayer(playerName);
        initialDbSetup.addToInventory(ItemValues.getItemId("Leather armour"), databaseID);
        switch (className){
            case "Rogue" -> initialDbSetup.addToInventory(ItemValues.getItemId("dagger"), databaseID);
            case "Cleric" -> initialDbSetup.addToInventory(ItemValues.getItemId("mace"), databaseID);
            case "Fighter" -> initialDbSetup.addToInventory(ItemValues.getItemId("hand axe"), databaseID);
            case "Wizard" -> initialDbSetup.addToInventory(ItemValues.getItemId("club"), databaseID);
        }
    }

    public void equipArmour(String armourName){
        DatabaseQuery equipArmour = new DatabaseQuery(DatabaseConnection.getConnection());
        if(currentArmour.isEmpty()){
            equipArmour(armourName, equipArmour);
        }
        else{
            unequipArmour();
            equipArmour(armourName, equipArmour);
        }
    }

    public void unequipArmour(){
        if(currentArmour.isEmpty()){
            log(Level.INFO, "Player was unable to unequip armour, as player had no armour equipped.");
        }
        else {
            DatabaseQuery unequipArmourQuery = new DatabaseQuery(DatabaseConnection.getConnection());
            int acBonus = unequipArmourQuery.getArmourBonus(ItemValues.getItemId(currentArmour.toLowerCase()));
            unequipArmourQuery.addToInventory(ItemValues.getItemId(currentArmour.toLowerCase()), databaseID);
            log(Level.INFO, "Player removed " + currentArmour + " from their equipped items.");
            armourClass = -acBonus;
            currentArmour = "";
        }
    }

    private void equipArmour(String armourName, DatabaseQuery equipArmour) {
        int newArmourBonus = equipArmour.getArmourBonus(ItemValues.getItemId(currentArmour.toLowerCase()));
        equipArmour.removeFromInventory(ItemValues.getItemId(armourName.toLowerCase()),databaseID);
        armourClass += newArmourBonus;
        currentArmour = armourName;
        log(Level.INFO, "Player equipped " + currentArmour + " from their inventory.");
    }

    public void equipWeapon(String weaponName){
        if(currentWeapon.isEmpty()){
            equipWeapon(weaponName);
        }
        else{
            unequipWeapon();
            equipWeapon(weaponName);
        }
    }

    public void unequipWeapon(){
        if(currentWeapon.isEmpty()){
            log(Level.INFO, "Player was unable to unequip weapon, as player had no weapon equipped.");
        }
        else {
            DatabaseQuery unequipWeaponQuery = new DatabaseQuery(DatabaseConnection.getConnection());
            int[] attackModifiers = unequipWeaponQuery.getWeaponModifiers(ItemValues.getItemId(currentWeapon));
            unequipWeaponQuery.addToInventory(ItemValues.getItemId(currentWeapon.toLowerCase()), databaseID);
            log(Level.INFO, "Player removed " + currentWeapon + " from their equipped items.");
            attackBonus -= attackModifiers[0];
            damageModifier -= attackModifiers[1];
            currentWeapon = "";
        }
    }

    private void equipWeapon(String weaponName, DatabaseQuery equipWeapon){
        int[] attackModifiers = equipWeapon.getWeaponModifiers(ItemValues.getItemId(currentWeapon.toLowerCase()));
        equipWeapon.removeFromInventory(ItemValues.getItemId(weaponName.toLowerCase()),databaseID);
        attackBonus += attackModifiers[0];
        damageModifier += attackModifiers[1];
        currentWeapon = weaponName;
        log(Level.INFO, "Player equipped " + currentWeapon + " from their inventory.");
    }
}
