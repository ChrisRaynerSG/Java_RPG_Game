package entities.player;

import log.LogController;

import java.util.logging.Level;

import static log.LogController.log;

public class Rogue extends Player{

    public Rogue(){
        LogController.log(Level.CONFIG, "New rogue player created");
        setClassName("Rogue");
        setMaxHealth(100);
        setAttackBonus(3);
        setDamageModifier(3);
        setCurrentWeapon("Dagger");

    }

    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
        setMaxHealth(getMaxHealth()+50);
        setDamageModifier(getDamageModifier()+3);
        if(getLevel()%4==0) {
            setTotalAbilities
                    (getTotalAbilities() + 1);
        }
    }
    @Override
    public String[] useAbility() {
        String[] abilityReturn = {"",""};
        if (hasNoAbilitiesRemaining()) {
            log(Level.FINE, "Ability was unable to be used as no ability points remaining");
            return abilityReturn;
        }
        else{
            String currentWeapon = getCurrentWeapon();
            double damageDealtRandomizer = ((Math.random()*10)*10)*getDamageModifier();
            int damageDealt = (int) damageDealtRandomizer;
            log(Level.FINE, "ROGUE class made use of ability: SNEAK ATTACK\n" +
                    "ROGUE class dealt " + damageDealt + " damage.");
            abilityReturn[0] = String.valueOf(damageDealt);
            abilityReturn[1] = "Studying your enemy, you strike at its vitals with your bloodthirsty " + currentWeapon + ", dealing " + damageDealt + " damage!" ;
            return abilityReturn;
        }
    }
}
