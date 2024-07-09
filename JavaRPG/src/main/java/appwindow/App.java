package appwindow;

import log.LogController;

import java.util.logging.Level;


public class App {
    public static void main(String[] args) {

        LogController.log(Level.INFO,"Running main method in App");
        SettingsFileInit settingsFileInit = new SettingsFileInit();
        AppWindow window = new AppWindow();

    }
}
