package entities;

import log.LogController;

import java.util.logging.Level;

public class Rogue extends Player{

    public Rogue(){
        LogController.log(Level.CONFIG, "New rogue player created");
        setClassName("Rogue");
        setMaxHealth(100);
        setDamageModifier(3);

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

}
