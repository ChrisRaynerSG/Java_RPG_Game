package appwindow;


import log.LogController;

public class App {
    public static void main(String[] args) {

        LogController logController = new LogController();

        AppWindow window = new AppWindow(500,500);

    }
}
