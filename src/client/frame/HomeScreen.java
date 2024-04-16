package client.frame;

import javax.swing.*;

import client.components.StarFish;
import client.components.Sunfish; // Sunfish 클래스 임포트
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;
import client.frame.miniGame.MiniGamePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.frame.miniGame.MenuButton;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";

    private ImageIcon backgroundImage;
    private Sunfish sunfish; // Sunfish 객체 선언
    private Shrimp shrimp;
    private ShellFish shellfish;

    private StarFish starfish;
    private Octopus octopus;
    private Crab crab;
    private JButton minigameButton;
    private MiniGamePanel miniGamePanel;
    private JLabel backgroundLabel;

    public HomeScreen() {
        // Load background image
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);

        // Set frame properties
        setTitle("Sunfish Game");
        setSize(1280, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JLabel for background image
        backgroundLabel = new JLabel(backgroundImage);

        // Set layout to null to freely position components
        setLayout(null);

        // Set bounds for background label to cover the entire frame
        backgroundLabel.setBounds(0, -100, getWidth(), getHeight());

        // Create Sunfish instance
        sunfish = new Sunfish();
        shrimp = new Shrimp();
        shellfish = new ShellFish();
        starfish = new StarFish();
        octopus = new Octopus();
        crab = new Crab();


        // Add Sunfish instance to background label
        backgroundLabel.add(sunfish);
        backgroundLabel.add(shrimp);
        backgroundLabel.add(shellfish);
        backgroundLabel.add(starfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab);


        MenuButton menuButton = new MenuButton(this);
        menuButton.setBounds(getWidth() - 160, getHeight() - 150, 130, 120);
        backgroundLabel.add(menuButton);

        add(backgroundLabel);

        miniGamePanel = new MiniGamePanel(this);
        miniGamePanel.setBounds(0, 0, getWidth(), getHeight());
        miniGamePanel.setVisible(false);

        add(miniGamePanel);
    }

    public void showMiniGamePanel() {
        backgroundLabel.setVisible(false);
        miniGamePanel.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}

