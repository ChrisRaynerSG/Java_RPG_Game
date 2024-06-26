package Entities;

public class Fighter extends Player{

    public Fighter(){
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
