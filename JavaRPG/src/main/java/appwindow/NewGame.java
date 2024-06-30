package appwindow;

import entities.Enemy;
import entities.GameObject;
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
        for(int i = 0; i < 101; i++){
            int randomInt = (int)(Math.random()*4);
            enemiesContainer.add(EnemyFactory.getEnemy(Enemies.getEnemyType(randomInt)));
            log(Level.FINER, "Enemy of type: " +Enemies.getEnemyType(randomInt) + " added to enemy pool");
        }
        for(Enemy enemy: enemiesContainer){
            log(Level.FINEST, enemy.getObjectName());
        }
        while(isGameRunning){
            gameText.setText("Welcome");
            //todo stuff for the game to happen.
            isGameRunning = false;

        }
    }
}
