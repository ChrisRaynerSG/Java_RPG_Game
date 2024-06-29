package entities;

import log.LogController;

import java.util.logging.Level;

public abstract class GameObject{
    private static int initialID;
    private int ID;
    private String objectName;
    private int xCoordinate;
    private int yCoordinate;
    private boolean isVisible;

    public GameObject(){
        LogController.log(Level.CONFIG, "New game object created with ID: " + ID);
        ID = initialID;
        initialID++;
    }

    public int getID() {
        return ID;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
