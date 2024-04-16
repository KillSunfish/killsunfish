package client.components;

import javax.swing.*;
import java.awt.*;

public class Sunfish extends JLabel {
    private static final String[] SUNFISH_IMAGE_PATHS = {
            "src/client/assets/sunfish.jpg",    // Level 1 image path
            "src/client/assets/sunfish_2.jpg"   // Level 2 image path
    };

    private static final int SUNFISH_WIDTH = 100; // Image width
    private static final int SUNFISH_HEIGHT = 100; // Image height

    private ImageIcon[] sunfishImages;

    public Sunfish() {
        // Load all images
        sunfishImages = new ImageIcon[SUNFISH_IMAGE_PATHS.length];
        for (int i = 0; i < SUNFISH_IMAGE_PATHS.length; i++) {
            ImageIcon originalImageIcon = new ImageIcon(SUNFISH_IMAGE_PATHS[i]);
            Image originalImage = originalImageIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
            sunfishImages[i] = new ImageIcon(scaledImage);
        }

        // Set default image (level 1)
        setIcon(sunfishImages[0]);

        // Set bounds for Sunfish label to position it
        int x = (1280 - SUNFISH_WIDTH) / 2; // Horizontal center alignment
        int y = (960 - SUNFISH_HEIGHT) / 2; // Vertical center alignment
        setBounds(x, y, SUNFISH_WIDTH, SUNFISH_HEIGHT);
    }

    // Method to update Sunfish image based on level
    public void updateImage(int level) {
        if (level >= 1 && level <= SUNFISH_IMAGE_PATHS.length) {
            setIcon(sunfishImages[level - 1]); // Level starts from 1, array index starts from 0
        } else {
            System.out.println("Invalid level: " + level);
        }
    }
}
