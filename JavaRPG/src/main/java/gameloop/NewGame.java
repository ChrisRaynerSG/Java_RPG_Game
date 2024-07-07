package gameloop;

import entities.enemies.Enemy;
import entities.player.Player;
import entities.player.Rogue;

import java.util.HashSet;

import static java.lang.Thread.sleep;

public class NewGame{

    HashSet<Enemy> enemiesContainer = new HashSet<>();
    private static NewGame newGame;
    private static boolean isGameRunning;

    private NewGame(){
        isGameRunning = true;
    }
    public static NewGame getNewGame(){
        if(newGame == null){
            newGame = new NewGame();
        }
        return newGame;
    }

    public void startGame(){
        isGameRunning = true;
        Player player = new Rogue();

        while(isGameRunning){
            isGameRunning = player.isPlayerDead();
        }
    }
}
