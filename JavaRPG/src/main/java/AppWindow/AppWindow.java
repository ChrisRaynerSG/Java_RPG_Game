package AppWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow extends JFrame {
    public AppWindow(){
        AppWindowSettings windowSettings = new AppWindowSettings();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(windowSettings.getWindowSize());

        JButton settings = new JButton("SETTINGS");
        add(settings, BorderLayout.SOUTH);
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppWindowSettingsWindow windowSettingsWindow = new AppWindowSettingsWindow();
                while (windowSettingsWindow.isVisible()){
                    setSize(windowSettings.getWindowSize());
                }


            }
        });
        setVisible(true);
    }
}
