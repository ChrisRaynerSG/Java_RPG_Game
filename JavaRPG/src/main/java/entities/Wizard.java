package Entities;

public class Wizard extends Player{

    public Wizard(){
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
