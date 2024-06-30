package entities;

import log.LogController;

import java.util.logging.Level;

public class Wizard extends Player{

    public Wizard(){
        LogController.log(Level.CONFIG, "New wizard player created");
        setClassName("Wizard");
        setMaxHealth(100);
        setDamageModifier(1);
    }

    @Override
    public void levelUp(){
        setLevel(getLevel()+1);
        setMaxHealth(getMaxHealth()+25);
        setDamageModifier(getDamageModifier()+1);
        if(getLevel()%4==0) {
            setTotalAbilities
                    (getTotalAbilities() + 1);
        }
    }
}
