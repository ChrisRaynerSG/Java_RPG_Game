package entities.player;

import log.LogController;

import java.util.logging.Level;

import static log.LogController.log;

public class Wizard extends Player{

    public Wizard(){
        LogController.log(Level.CONFIG, "New wizard player created");
        setClassName("Wizard");
        setMaxHealth(100);
        setAttackBonus(1);
        setDamageModifier(1);
        setCurrentWeapon("Club");
    }

    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
        setMaxHealth(getMaxHealth()+25);
        setDamageModifier(getDamageModifier()+1);
        if(getLevel()%2==0) {
            setTotalAbilities
                    (getTotalAbilities() + 1);
        }
    }
    public String[] useAbility() {
        String[] abilityReturn = {"",""};
        if (hasNoAbilitiesRemaining()) {
            log(Level.FINE, "Ability was unable to be used as no ability points remaining");
            return abilityReturn;
        }
        else{
            String currentWeapon = getCurrentWeapon();
            double damageDealtRandomizer = ((Math.random()*10)*20);
            int damageDealt = (int) damageDealtRandomizer;
            log(Level.FINE, "WIZARD class made use of ability: FIREBALL\n" +
                    "WIZARD class dealt " + damageDealt + " damage.");
            abilityReturn[0] = String.valueOf(damageDealt);
            abilityReturn[1] = "With a deft hand movement and a muttering of words, you launch a fireball at your opponent! The explosion deals " + damageDealt + " damage!" ;
            return abilityReturn;
        }
    }
}
