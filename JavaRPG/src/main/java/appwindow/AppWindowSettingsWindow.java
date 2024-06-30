package appwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindowSettingsWindow extends JFrame {
    public AppWindowSettingsWindow(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(400,400));


        JButton _400x400 = new JButton();
        JButton _600x600 = new JButton();
        JButton _1280x720 = new JButton();
        JButton _1920x1080 = new JButton();

        add(_400x400);
        add(_600x600);
        add(_1280x720);
        add(_1920x1080);

        _400x400.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppWindowSettings windowSettings = new AppWindowSettings();
                windowSettings.setWindowSize(400,400);
            }
        });

        _600x600.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppWindowSettings windowSettings = new AppWindowSettings();
                windowSettings.setWindowSize(600,600);
            }
        });

        _1280x720.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppWindowSettings windowSettings = new AppWindowSettings();
                windowSettings.setWindowSize(1280,720);
            }
        });
        _1920x1080.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppWindowSettings windowSettings = new AppWindowSettings();
                windowSettings.setWindowSize(1920,1080);
            }
        });
        setVisible(true);
    }
}
