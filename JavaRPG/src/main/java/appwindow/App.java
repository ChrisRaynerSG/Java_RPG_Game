package appwindow;


import dbm.DatabaseConnection;
import log.LogController;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {

//        LogController logController = new LogController();
//        SettingsFileInit settingsFileInit = new SettingsFileInit();
//        AppWindow window = new AppWindow();

        System.out.println(DatabaseConnection.getConnection());
        DatabaseConnection.closeConnection();

    }
}
