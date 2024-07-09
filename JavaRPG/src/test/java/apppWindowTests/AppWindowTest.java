package apppWindowTests;

import appwindow.AppWindow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AppWindowTest {

    @Test
    public void testConstructorBuildsAppWindow() {
        AppWindow appWindow = new AppWindow();

        Assertions.assertTrue(appWindow.isShowing());
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 250, 890})
    public void testAppWindow(int size) {
        AppWindow appWindow = new AppWindow();

        appWindow.setSize(size,size);

        Assertions.assertEquals(size,appWindow.getHeight());
        Assertions.assertEquals(size,appWindow.getWidth());
    }
}
