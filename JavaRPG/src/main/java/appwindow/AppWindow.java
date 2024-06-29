package AppWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppWindow extends JFrame implements ActionListener {
    private static int width, height;

    JButton playButton = new JButton("Play");
    JButton settingsButton = new JButton("Settings");
    JButton highScoresButton = new JButton("High Scores");
    JButton saveButton = new JButton("Save Game");
    JButton loadButton = new JButton("Load Game");
    JButton menuButton = new JButton("Menu");
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
        AppWindow.width = width;
        AppWindow.height = height;
        setSize(AppWindow.width,AppWindow.height);
        setTitle("RPG Game");
        setResizable(false);

        mainPanel.setLayout(layout);
        addButtons();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
        setVisible(true);

    }
    private void addButtons(){
        playButton.addActionListener(this);
        exitButton.addActionListener(this);
        menuButton.addActionListener(this);
        settingsButton.addActionListener(this);
        menuPanel.add(settingsButton);
        menuPanel.add(saveButton);
        menuPanel.add(loadButton);
        menuPanel.add(exitButton);
        gamePanel.add(menuButton);
        settingsPanel.add(smallWindow);
        settingsPanel.add(mediumWindow);
        settingsPanel.add(largeWindow);
        settingsPanel.add(menuButton);
        ArrayList<Component> saveButtons = saveButtons();
        for(Component button : saveButtons){
            saveScreenPanel.add(button);
        }
        mainPanel.add(menuPanel,"Menu");
        mainPanel.add(gamePanel, "Game");
        mainPanel.add(settingsPanel,"Settings");
        mainPanel.add(saveScreenPanel, "Save");
        mainPanel.add(loadScreenPanel,"Load");
        add(mainPanel);
    }

    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();

        if(source == exitButton){
            System.exit(0);
        } else if (source== menuPanel) {
            layout.show(mainPanel, "Menu");
        } else if (source==settingsButton) {
            layout.show(mainPanel,"Settings");
        } else if (source == saveButton) {
            layout.show(mainPanel,"Save");
        }else if (source == loadButton){
            layout.show(mainPanel, "Load");
        } else if(source == smallWindow){
            windowSize(500,500);
        }else if(source == mediumWindow){
            windowSize(1000,1000);
        }else if(source== largeWindow){
            windowSize(1920,1080);
        }
    }
    private void windowSize(int width, int height){
        setResizable(true);
        AppWindow.height = height;
        AppWindow.width = width;
        setSize(AppWindow.width,AppWindow.height);
        setResizable(false);
    }
    private ArrayList<Component> saveButtons(){
        ArrayList<Component> saveButtons = new ArrayList<Component>();
        for (int i =0; i<6; i++){
            saveButtons.add(new JButton("Save " +i));
        }
        return saveButtons;
    }
}
