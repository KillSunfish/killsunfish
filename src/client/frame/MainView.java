package client.frame;

import client.components.User;
import client.components.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import client.components.Navbar; // Navbar를 import합니다.

public class MainView extends JFrame {

    private final BackgroundImagePanel backgroundImagePanel;
    private final Start startComponent;
    private User userComponent;
    private final Navbar navbar;

    private String backgroundType;

    private JButton btn_toggleBackground;


    public MainView() {
        // deps
        this.backgroundType = "intro";
        this.btn_toggleBackground = new JButton("toggle");
        this.navbar = new Navbar(); // Navbar 추가


        // background panel
        this.backgroundImagePanel = new BackgroundImagePanel("intro");
        this.setContentPane(backgroundImagePanel);

        this.startComponent = new Start(this);
        startComponent.setBounds(0, 0, 1280, 960);
        this.add(startComponent);

        // init
        setTitle("sunfish game");
        setSize(1280, 960);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);




        // Navbar 위치 지정
        navbar.setBounds(0, 100, getWidth(), 50);
        add(navbar);

        // test - toggle btn
//        btn_toggleBackground.setBounds(100, 0, 100, 30);
//        btn_toggleBackground.setBackground(Color.BLUE);
//        addBtnActionListener(btn_toggleBackground);
//        this.add(btn_toggleBackground);

        // add
    }

//    private void addBtnActionListener(AbstractButton btn) {
//        ActionListener actionListener = (e) -> {
//
//            // intro or in game image
//            this.backgroundImagePanel.modifyBackgroundImage("ingame".equals(this.backgroundType) ? "intro" : "ingame");
//            // field to test toggle
//            this.backgroundType = "ingame".equals(this.backgroundType) ? "intro" : "ingame";
//
//            // repaint after updated
//            repaint();
//
//        };
//
//        btn.addActionListener(actionListener);
//    }

    public void switchView(String type) {
        userComponent = new User(this, type);
        remove(startComponent);
        userComponent.setBounds(0,0,1280,960);
        add(userComponent);
        revalidate();
        repaint();
    }
}
