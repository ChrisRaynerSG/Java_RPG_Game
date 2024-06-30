package gameloop;
import entities.Player;
import entities.Rogue;

import static appwindow.AppWindow.*;

public class CharacterCreation {

    public CharacterCreation(){

        Player player = new Player() {
            @Override
            public void levelUp() {

            }
        };
        player = new Rogue();
    }
}
