package client.frame;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

    private ImageIcon backgroundImage;
    private ImageIcon sunfishImage;

    public HomeScreen() {
        // Load images
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);
        sunfishImage = new ImageIcon(SUNFISH_IMAGE_PATH);

        // Set frame properties
        setTitle("Sunfish Game");
        setSize(1280, 980); // 화면 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create JLabels for background image and Sunfish image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        JLabel sunfishLabel = new JLabel(sunfishImage);

        // Set layout to null to freely position components
        setLayout(null);

        // Set bounds for background label to cover the entire frame
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());

        // Calculate the position to center the Sunfish image
        int x = (getWidth() - sunfishImage.getIconWidth()) / 2;
        int y = (getHeight() - sunfishImage.getIconHeight()) / 2;

        // Set bounds for Sunfish label
        sunfishLabel.setBounds(x, y, sunfishImage.getIconWidth(), sunfishImage.getIconHeight());

        // Add labels to the frame
        add(backgroundLabel);
        backgroundLabel.add(sunfishLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}
