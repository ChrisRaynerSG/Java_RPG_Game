package appwindow;

import entities.Enemy;
import entities.GameObject;
import entities.Player;
import entities.Rogue;
import entities.enemies.Enemies;
import entities.enemies.Kobold;
import gameloop.EnemyFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static appwindow.AppWindow.*;
import static java.lang.Thread.sleep;
import static log.LogController.log;

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
            gameText.setText("Welcome");
            try{
                player.setCurrentHealth(player.getCurrentHealth()-10);
                sleep(1000);
                gameText.setText(String.valueOf(player.getCurrentHealth()));
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            isGameRunning = player.isPlayerDead();
        }
    }
}
