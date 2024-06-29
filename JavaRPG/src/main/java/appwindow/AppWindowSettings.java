package AppWindow;
import java.awt.*;

public class AppWindowSettings{
    private static Dimension windowSize;

    public AppWindowSettings(){
        this.setWindowSize(1920,1080);
    }

    public Dimension getWindowSize(){
        return windowSize;
    }
    public void setWindowSize(int width, int height){
        windowSize = new Dimension(width,height);
    }


}
