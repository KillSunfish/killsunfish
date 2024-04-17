package client.frame;

import client.components.*;
import server.VO.UserVO;
import server.controller.UserController;
import server.VO.UserVO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private final BackgroundImagePanel backgroundImagePanel;
    private final Start startComponent = new Start(this);
    private final SignUp signUpComponent = new SignUp(this);
    private final SignIn signInComponent = new SignIn(this);
    private final Navbar navbar;
    private UserVO userVO;

    private String backgroundType;

    private JButton btn_toggleBackground;

//    private HomeScreen homeScreen;
    private JComponent mainComponent;

    private JComponent overlayComponent;

    public UserController userController = new UserController();

    public MainView() {
        // deps
        this.backgroundType = "intro";
//        this.btn_toggleBackground = new JButton("toggle");
        this.navbar = new Navbar(userVO); // Navbar 추가


        // background panel
        this.backgroundImagePanel = new BackgroundImagePanel("intro");
        this.setContentPane(backgroundImagePanel);

        startComponent.setBounds(0, 0, 1280, 960);
        this.add(startComponent);
//        this.mainComponent = new Start(this);
//        this.mainComponent.setBounds(0, 0, 1280, 960);
//        this.add(this.mainComponent);

        // init
        setTitle("sunfish game");
        setSize(1280, 960);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

    }

    public void switchView(String type, JComponent jComponent) {
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
            this.mainComponent = jComponent;
            mainComponent.setBounds(0, 0, 1280, 960);
            remove(signInComponent);
            add(mainComponent);
        } else if ("main".equals(type)) {
            this.backgroundImagePanel.modifyBackgroundImage("intro");
            remove(this.overlayComponent);
            startComponent.setBounds(0,0,1280,960);
            this.add(startComponent);
        } else if("mainGameFinished".equals(type)) {
            System.out.println("home");
            ((HomeScreen)this.mainComponent).removeMiniGamePanel();
        }

        revalidate();
        repaint();
    }

    public void switchView(JComponent jComponent) {
        remove(mainComponent);
        this.mainComponent = jComponent;
        mainComponent.setBounds(0,0,1280,960);

        add(mainComponent);
        revalidate();
        repaint();
    }

    public void setOverlay(JComponent jComponent) {
        System.out.println("set overlay");
        this.overlayComponent = jComponent;
        overlayComponent.setBounds(0,0, this.getWidth(), this.getHeight());

        backgroundImagePanel.modifyBackgroundImage("ingame");
        this.remove(mainComponent);
        this.add(overlayComponent);

        revalidate();
        repaint();
    }
}
