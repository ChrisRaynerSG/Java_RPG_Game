package appwindow;

import log.LogController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;

import static log.LogController.log;

public class AppWindow extends JFrame implements ActionListener {

    private static Dimension windowSize;
    private final String gameString = "Game";
    private final String menuString = "Menu";
    private final String saveString = "Save";
    private final String loadString = "Load";
    private final String settingsString = "Settings";

    JButton playButton = new JButton("Resume");
    JButton settingsButton = new JButton("Settings");
    JButton saveButton = new JButton("Save Game");
    JButton loadButton = new JButton("Load Game");
    JButton menuButtonGame = new JButton("Menu");
    JButton menuButtonSettings = new JButton("Menu");
    JButton menuButtonSave = new JButton("Menu");
    JButton menuButtonLoad = new JButton("Menu");
    JButton exitButton = new JButton("Exit");
    JButton smallWindow = new JButton("Small");
    JButton mediumWindow = new JButton("Medium");
    JButton largeWindow = new JButton("Large");

    CardLayout layout = new CardLayout();

    JPanel mainPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JPanel saveScreenPanel = new JPanel();
    JPanel loadScreenPanel = new JPanel();


    public AppWindow(int width, int height){
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
        playButton.addActionListener(this);
        exitButton.addActionListener(this);
        menuButtonGame.addActionListener(this);
        menuButtonSettings.addActionListener(this);
        menuButtonSave.addActionListener(this);
        menuButtonLoad.addActionListener(this);
        settingsButton.addActionListener(this);
        saveButton.addActionListener(this);
        smallWindow.addActionListener(this);
        mediumWindow.addActionListener(this);
        largeWindow.addActionListener(this);

        menuPanel.add(settingsButton);
        menuPanel.add(saveButton);
        menuPanel.add(loadButton);
        menuPanel.add(exitButton);

        menuPanel.setLayout(new FlowLayout());

        gamePanel.add(menuButtonGame);

        settingsPanel.add(smallWindow);
        settingsPanel.add(mediumWindow);
        settingsPanel.add(largeWindow);
        settingsPanel.add(menuButtonSettings);
        settingsPanel.setLayout(new FlowLayout());

        saveButtons();
        saveScreenPanel.add(menuButtonSave);



        mainPanel.add(menuPanel,menuString);
        mainPanel.add(gamePanel, gameString);
        mainPanel.add(settingsPanel,settingsString);
        mainPanel.add(saveScreenPanel, saveString);
        mainPanel.add(loadScreenPanel,loadString);

        add(mainPanel);
        layout.show(mainPanel,gameString);
        log(Level.FINE, "Window populated.");
    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        String buttonPressed = "Button pressed";
        if(source == exitButton){
            log(Level.INFO, buttonPressed);
            System.exit(0);
        } else if (source == menuButtonGame) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, menuString);
        } else if (source == menuButtonSettings) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, menuString);
        } else if (source == menuButtonSave) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, menuString);
        } else if (source == menuButtonLoad) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, menuString);
        } else if (source==settingsButton) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel,settingsString);
        } else if (source == saveButton) {
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel,saveString);
        }else if (source == loadButton){
            log(Level.INFO, buttonPressed);
            layout.show(mainPanel, loadString);
        } else if(source == smallWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Small");
            windowSize(500,500);
        }else if(source == mediumWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Medium");
            windowSize(1280,720);
        }else if(source == largeWindow){
            log(Level.INFO, buttonPressed);
            SettingsFileWrite.writeToFileWindowSize("Window size: Large");
            windowSize(1920,1080);
        }
    }
    private void windowSize(int width, int height){
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
}
