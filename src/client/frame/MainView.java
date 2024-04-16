package client.frame;

import client.components.*;
import server.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private final BackgroundImagePanel backgroundImagePanel;
    private final Start startComponent = new Start(this);
    private final SignUp signUpComponent = new SignUp(this);
    private final SignIn signInComponent = new SignIn(this);
    private final Navbar navbar;

    private String backgroundType;

    private JButton btn_toggleBackground;

    public UserController userController = new UserController();

    public MainView() {
        // deps
        this.backgroundType = "intro";
        this.btn_toggleBackground = new JButton("toggle");
        this.navbar = new Navbar(); // Navbar 추가


        // background panel
        this.backgroundImagePanel = new BackgroundImagePanel("intro");
        this.setContentPane(backgroundImagePanel);

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
//        navbar.setBounds(0, 100, getWidth(), 50);
//        add(navbar);

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
        if (type.equals("signIn")) {

            signInComponent.setBounds(0,0,1280,960);
            remove(startComponent);
            add(signInComponent);
        } else if (type.equals("signUp")) {
            signUpComponent.setBounds(0,0,1280,960);
            remove(startComponent);
            add(signUpComponent);
        } else if (type.equals("signUpFinished")) {
            startComponent.setBounds(0,0,1280,960);
            remove(signUpComponent);
            add(startComponent);
        } else if (type.equals("signInFinished")) {
            startComponent.setBounds(0,0,1280,960);
            remove(signInComponent);
            add(startComponent);
        }

        revalidate();
        repaint();
    }
}
