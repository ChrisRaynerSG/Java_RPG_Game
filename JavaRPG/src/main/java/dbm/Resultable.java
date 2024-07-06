package dbm;

import java.util.ArrayList;

public interface Resultable {

    ArrayList<String[]> getPlayerInventory(int playerID);
    ArrayList<String[]> getHighScores();


}
