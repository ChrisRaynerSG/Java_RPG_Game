package appwindow;


import dbm.DatabaseConnection;
import dbm.DatabaseQuery;
import dbm.DatabaseResults;
import log.LogController;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        LogController logController = new LogController();
        SettingsFileInit settingsFileInit = new SettingsFileInit();
        AppWindow window = new AppWindow();

    }
}
