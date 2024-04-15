package client.frame;

import javax.swing.*;

import client.components.StarFish;
import client.components.Sunfish; // Sunfish 클래스 임포트
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;
import client.components.RottenFish;
import client.components.ShellFish;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";

    private ImageIcon backgroundImage;
    private Sunfish sunfish; // Sunfish 객체 선언
    private Shrimp shrimp;
    private ShellFish shellFish;
    private StarFish starfish;
    private Octopus octopus;
    private Crab crab;
    private RottenFish rottenfish;

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
        octopus = new Octopus(-250, -250);
        crab = new Crab(5,5);


        // Add Sunfish instance to background label
        backgroundLabel.add(sunfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab);



        // Add background label to the frame
        add(backgroundLabel);


        octopus.startMoving();
        crab.startMoving();

        for (int i = 0; i < 5; i++) {
            RottenFish rottenFish = new RottenFish(5, 5); // 움직임 설정
            backgroundLabel.add(rottenFish);
            rottenFish.startMoving();
        }

        for (int i = 0; i < 3; i++) {
            StarFish starfish = new StarFish(1,1); // 움직임 설정
            backgroundLabel.add(starfish);
            starfish.startMoving();
        }

        for (int i = 0; i < 2; i++) {
            Shrimp shrimp = new Shrimp(15,15); // 움직임 설정
            ShellFish shellFish = new ShellFish(-10, -10);
            backgroundLabel.add(shrimp);
            backgroundLabel.add(shellFish);
            shrimp.startMoving();
            shellFish.startMoving();
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}

