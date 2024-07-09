package appwindow;

import gameloop.NewGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.logging.Level;

import static log.LogController.log;

public class AppWindow extends JFrame implements ActionListener {

    public static Dimension windowSize;
    public static final String GAME_STRING = "Game";
    public static final String MAIN_MENU_STRING = "Main Menu";
    public static final String MENU_STRING = "Game Menu";
    public static final String SAVE_STRING = "Save";
    public static final String LOAD_STRING = "Load";
    public static final String SETTINGS_STRING = "Settings";
    public static final String INVENTORY_STRING = "Inventory";
    public static String gameTextString = "";

    JButton newGameButton = new JButton("New Game");
    JButton loadGameMenuButton = new JButton ("Load Game");
    JButton exitButton = new JButton("Exit");

    public static JButton resumeButton = new JButton("Resume");
    public static JButton settingsButton = new JButton("Settings");
    public static JButton saveButton = new JButton("Save Game");
    public static JButton loadButton = new JButton("Load Game");
    public static JButton menuButtonGame = new JButton("Menu");
    public static JButton mainMenuButtonSettings = new JButton("Back");
    public static JButton menuButtonSave = new JButton("Menu");
    public static JButton menuButtonLoad = new JButton("Menu");
    public static JButton mainMenuButtonGameMenu = new JButton ("Main Menu");
    public static JButton smallWindow = new JButton("Small");
    public static JButton mediumWindow = new JButton("Medium");
    public static JButton largeWindow = new JButton("Large");
    public static JTextArea gameText = new JTextArea();

    public static CardLayout layout = new CardLayout();

    public static JPanel mainPanel = new JPanel();
    public static JPanel startMenuPanel = new JPanel();
    public static JPanel gamePanel = new JPanel();
    public static JPanel gameMenuPanel = new JPanel();
    public static JPanel settingsPanel = new JPanel();
    public static JPanel saveScreenPanel = new JPanel();
    public static JPanel loadScreenPanel = new JPanel();
    public static InventoryPanel inventoryPanel = new InventoryPanel(1);

    BoxLayout mainMenuLayout = new BoxLayout(startMenuPanel,BoxLayout.Y_AXIS);
    BoxLayout gamePanelLayout = new BoxLayout(gameMenuPanel,BoxLayout.Y_AXIS);

    public AppWindow(){
        windowSize = SettingsFileRead.readSettingsFileWindowSize();
        log(Level.INFO,"Application started at " + LocalTime.now());
        mainPanel.setLayout(layout);
        setSize(windowSize);
        setTitle("RPG Game");
        setResizable(false);
        addButtons();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
        setVisible(true);

    }
    private void addButtons(){
        //Button action listeners
        for (JButton jButton : Arrays.asList(resumeButton, exitButton, menuButtonGame, mainMenuButtonSettings, menuButtonSave, menuButtonLoad, settingsButton, saveButton, smallWindow, mediumWindow, largeWindow, newGameButton, loadGameMenuButton, mainMenuButtonGameMenu)) {
            jButton.addActionListener(this);
        }

        setupStartMenuPanel();
        setupGameMenuPanel();

        gamePanel.add(menuButtonGame);
        gameText.setSize(400,400);
        gameText.setLineWrap(true);
        gameText.setWrapStyleWord(true);
        gamePanel.add(gameText);

        for (JButton jButton : Arrays.asList(smallWindow, mediumWindow, largeWindow, mainMenuButtonSettings)) {
            settingsPanel.add(jButton);
        }
        settingsPanel.setLayout(new FlowLayout());

        saveButtons();
        saveScreenPanel.add(menuButtonSave);


        mainPanel.add(startMenuPanel, MAIN_MENU_STRING);
        mainPanel.add(gameMenuPanel, MENU_STRING);
        mainPanel.add(gamePanel, GAME_STRING);
        mainPanel.add(settingsPanel, SETTINGS_STRING);
        mainPanel.add(saveScreenPanel, SAVE_STRING);
        mainPanel.add(loadScreenPanel, LOAD_STRING);
        mainPanel.add(inventoryPanel, INVENTORY_STRING);

        add(mainPanel);
        layout.show(mainPanel, MAIN_MENU_STRING);
        log(Level.FINE, "Window populated.");
    }

    private void setupStartMenuPanel() {
        for (JButton jButton : Arrays.asList(newGameButton, loadGameMenuButton, settingsButton, exitButton)) {
            startMenuPanel.add(jButton);
        }

        startMenuPanel.setLayout(mainMenuLayout);
    }

    private static void setupGameMenuPanel() {
        for (JButton jButton : Arrays.asList(resumeButton, saveButton, loadButton, mainMenuButtonGameMenu)) {
            gameMenuPanel.add(jButton);
        }

        gameMenuPanel.setLayout(new FlowLayout());
    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

        String buttonPressed = "Button pressed";
        if(source == exitButton){
            log(Level.INFO, buttonPressed);
            System.exit(0);
        }
        else if (source == menuButtonGame) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, MENU_STRING);
        }
        else if (source == mainMenuButtonSettings) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, MAIN_MENU_STRING);
        }
        else if (source == menuButtonSave) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, MENU_STRING);
        }
        else if (source == menuButtonLoad) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, MENU_STRING);
        }
        else if (source == settingsButton) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, SETTINGS_STRING);
        }
        else if (source == saveButton) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, SAVE_STRING);
        }
        else if (source == loadButton){
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, LOAD_STRING);
        }
        else if (source == newGameButton) {
            layout.show(mainPanel, INVENTORY_STRING);
            NewGame newGame = NewGame.getNewGame();
            newGame.startGame();

        }
        else if (source == resumeButton) {
            layout.show(mainPanel, GAME_STRING);
        }
        else if (source == mainMenuButtonGameMenu) {
            layout.show(mainPanel, MAIN_MENU_STRING);
        }
        else if(source == smallWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Small");
            setWindowSize(screenDimensions.width/2,screenDimensions.height/2);
        }
        else if(source == mediumWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Medium");
            setWindowSize(screenDimensions.width/4*3,screenDimensions.height/4*3);
        }
        else if(source == largeWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Large");
            setWindowSize(screenDimensions.width,screenDimensions.height);
        }
    }

    private void setWindowSize(int width, int height){
        setResizable(true);
        windowSize = new Dimension(width,height);
        setSize(windowSize);
        setLocationRelativeTo(null);
        requestFocus();
        setResizable(false);
    }

    private void saveButtons(){
        for (int i =0; i<6; i++){
            saveScreenPanel.add(new JButton("Save " +i));
        }
    }

    public static void setGameTextString(String string){
        gameTextString = string;
    }
    public static String getGameTextString(){
        return gameTextString;
    }
    public static String getGameString(){
        return GAME_STRING;
    }
    public static String getMenuString(){
        return MENU_STRING;
    }
}
