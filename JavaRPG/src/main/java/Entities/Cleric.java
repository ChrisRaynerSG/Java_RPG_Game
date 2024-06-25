package Entities;

public class Cleric extends Player{

    public Cleric(){
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
