package Entities;

public class Rogue extends Player{

    public Rogue(){
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
