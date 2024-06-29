package entities;

import log.LogController;

import java.util.logging.Level;

public class Cleric extends Player{

    public Cleric(){
        LogController.log(Level.CONFIG, "New cleric player created");
        setClassName("Cleric");
        setMaxHealth(200);
        setDamageModifier(1);
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
}
