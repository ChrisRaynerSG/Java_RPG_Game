package appwindow;

import java.awt.*;
import java.util.logging.Level;

import static log.LogController.log;

public class ScreenDimensions {
    private static Dimension dimension;

    public static void setDimension(int width, int height){
        log(Level.CONFIG, "Screen dimension updated to: " + width + "x" + height);
        dimension = new Dimension(width,height);
    }

    public static Dimension getDimenison(){
        return dimension;
    }
}
