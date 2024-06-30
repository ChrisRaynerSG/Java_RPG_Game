package appwindow;


import log.LogController;

public class App {
    public static void main(String[] args) {

        LogController logController = new LogController();
        SettingsFileInit settingsFileInit = new SettingsFileInit();
        AppWindow window = new AppWindow(500,500);

    }
}
