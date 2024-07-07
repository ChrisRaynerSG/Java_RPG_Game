package entities.player;

import java.util.logging.Level;

import static log.LogController.log;

public class Cleric extends Player{

    public Cleric(){
        log(Level.CONFIG, "New cleric player created");
        setClassName("Cleric");
        setMaxHealth(200);
        setAttackBonus(2);
        setDamageModifier(1);
        setCurrentWeapon("Mace");
    }

    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
        setMaxHealth(getMaxHealth()+50);
        setDamageModifier(getDamageModifier()+1);
        if(getLevel()%4==0){
            setTotalAbilities
                    (getTotalAbilities()+1);
        }
    }

    @Override
    public String[] useAbility(){
        String[] abilityReturn = {"",""};
        if(hasNoAbilitiesRemaining()){
            log(Level.FINE, "Ability was unable to be used as no ability points remaining");
            return abilityReturn;
        }
        else{
            setAbilitiesRemaining(getAbilitiesRemaining()-1);
            double healDouble = (Math.random()*50)*getLevel();
            int healAmount = (int) healDouble;
            if(isOverMaxHealth(healAmount)){
                log(Level.FINE, "Cleric class made use of ability: HEAL\n1 Ability point used." +
                        "\nCleric player healed by "  + (getMaxHealth()-getCurrentHealth()) + "HP.\n Cleric player returned to full health.");
                int healAmountOverMaxHealth = getMaxHealth()-getCurrentHealth();
                abilityReturn[0] = String.valueOf(healAmountOverMaxHealth);
                abilityReturn[1] = "You pray to your god and suddenly feel rejuvenated! You heal " + healAmountOverMaxHealth + "HP!";
                return abilityReturn;
            }
            else{
                setCurrentHealth(getCurrentHealth()+healAmount);
                log(Level.FINE, "Cleric class made use of ability: HEAL\n1 Ability point used." +
                        "\nCleric player healed by "  + healAmount + "HP.\n Cleric player now at "
                        + getCurrentHealth()+ "HP.");

                abilityReturn[0] = String.valueOf(healAmount);
                abilityReturn[1] = "You pray to your god and suddenly feel rejuvenated! You heal " + healAmount + "HP!";
                return abilityReturn;

            }
        }
    }
}
