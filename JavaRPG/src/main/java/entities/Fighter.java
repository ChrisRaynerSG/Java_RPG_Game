package entities;

import log.LogController;

import java.util.logging.Level;

public class Fighter extends Player{

    public Fighter(){
        LogController.log(Level.CONFIG, "New fighter player created");
        setClassName("Fighter");
        setMaxHealth(200);
        setDamageModifier(2);
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
}
