package entities.player;

import log.LogController;

import java.util.logging.Level;

import static log.LogController.log;

public class Fighter extends Player{

    public Fighter(){
        LogController.log(Level.CONFIG, "New fighter player created");
        setClassName("Fighter");
        setMaxHealth(250);
        setAttackBonus(2);
        setDamageModifier(2);
        setCurrentWeapon("Hand axe");
    }

    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
        setMaxHealth(getMaxHealth()+100);
        setDamageModifier(getDamageModifier()+2);
        if(getLevel()%4==0) {
            setTotalAbilities
                    (getTotalAbilities() + 1);
        }
    }
    @Override
    public String[] useAbility() {
        String[] abilityReturn = {"",""};
        if (hasNoAbilitiesRemaining()) {
            log(Level.FINE, "Ability was unable to be used as no ability points remaining.");
            abilityReturn[0] = "0";
            abilityReturn[1] = "You cannot use any more abilities!";
            return abilityReturn;
        }
        else{
            String currentWeapon = getCurrentWeapon();
            double damageDealtRandomizer = ((Math.random()*10)*10)*getDamageModifier();
            int damageDealt = (int) damageDealtRandomizer;
            log(Level.FINE, "Fighter class made use of ability: POWER ATTACK\n" +
                    "Fighter class dealt " + damageDealt + " damage.");
            abilityReturn[0] = String.valueOf(damageDealt);
            abilityReturn[1] = "With a mighty yell, you viciously swing your " + currentWeapon + ", dealing " + damageDealt + " damage!" ;
            return abilityReturn;
        }
    }
}
