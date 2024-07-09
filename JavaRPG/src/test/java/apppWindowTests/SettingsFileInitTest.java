package apppWindowTests;

import appwindow.SettingsFileInit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;

public class SettingsFileInitTest {

    @Test
    public void testSettingsFileInit() {
        SettingsFileInit settingsFileInit = new SettingsFileInit();
        File settingsFile = new File("src/main/resources/Settings.cfg");
        Assertions.assertTrue(settingsFile.exists());
    }


}
