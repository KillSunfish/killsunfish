package client.components;

import javax.swing.*;
import java.awt.*;

public class Sunfish extends JLabel {
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";
    private static final String SUNFISH2_IMAGE_PATH = "src/client/assets/sunfish_2.jpg";
    private static final String SUNFISH3_IMAGE_PATH = "src/client/assets/sunfish_3.jpg";
    private static final String SUNFISH4_IMAGE_PATH = "src/client/assets/sunfish_4.jpg";

    private static final int SUNFISH_WIDTH = 100;
    private static final int SUNFISH_HEIGHT = 100;

    private ImageIcon sunfishImage;
    private Navbar navbar;

    public Sunfish(Navbar navbar) {
        this.navbar = navbar; // Navbar 객체를 전달받아 필드에 저장

        ImageIcon originalImageIcon = new ImageIcon(SUNFISH_IMAGE_PATH);
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
        sunfishImage = new ImageIcon(scaledImage);

        setIcon(sunfishImage);

        int x = (1280 - sunfishImage.getIconWidth()) / 2;
        int y = (980 - sunfishImage.getIconHeight()) / 2;
        setBounds(x, y, sunfishImage.getIconWidth(), sunfishImage.getIconHeight());

        Timer timer = new Timer(1000, e -> updateSunfishImage());
        timer.start();
    }

    public void updateSunfishImage() {
        double weight = navbar.getWeight();
        if (weight < 10.0) {
            setSunfishImage(SUNFISH_IMAGE_PATH);
        } else if (weight < 20.0) {
            setSunfishImage(SUNFISH2_IMAGE_PATH);
        } else if (weight < 30.0) {
            setSunfishImage(SUNFISH3_IMAGE_PATH);
        } else {
            setSunfishImage(SUNFISH4_IMAGE_PATH);
        }
    }

    private void setSunfishImage(String imagePath) {
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
        sunfishImage = new ImageIcon(scaledImage);

        setIcon(sunfishImage);
    }
}
