package client.frame;

import javax.swing.*;

import client.components.StarFish;
import client.components.Sunfish; // Sunfish 클래스 임포트
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";

    private ImageIcon backgroundImage;
    private Sunfish sunfish; // Sunfish 객체 선언
    private Shrimp shrimp;
    private ShellFish shellfish;

    private StarFish starfish;
    private Octopus octopus;
    private Crab crab;

    public HomeScreen() {
        // Load background image
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);

        // Set frame properties
        setTitle("Sunfish Game");
        setSize(1280, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JLabel for background image
        JLabel backgroundLabel = new JLabel(backgroundImage);

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

        // Add background label to the frame
        add(backgroundLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}

