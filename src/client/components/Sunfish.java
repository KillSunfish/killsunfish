package client.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sunfish extends JLabel {
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";
    private static final String SUNFISH2_IMAGE_PATH = "src/client/assets/sunfish_2.jpg";
    private static final String SUNFISH3_IMAGE_PATH = "src/client/assets/sunfish_3.jpg";
    private static final String SUNFISH4_IMAGE_PATH = "src/client/assets/sunfish_4.jpg";

    private static final int SUNFISH_WIDTH = 100;
    private static final int SUNFISH_HEIGHT = 100;

    private ImageIcon sunfishImage;
    private int x;
    private int y;
    private boolean isFlipped = false; // 좌우 반전 여부
    private Navbar navbar;

    public Sunfish(Navbar navbar) {
        this.navbar = navbar; // Navbar 객체를 전달받아 필드에 저장

        ImageIcon originalImageIcon = new ImageIcon(SUNFISH_IMAGE_PATH);
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
        sunfishImage = new ImageIcon(scaledImage);

        setIcon(sunfishImage);

        // Set bounds for Sunfish label to position it
        x = (1280 - sunfishImage.getIconWidth()) / 2; // 가로 중앙 정렬
        y = (980 - sunfishImage.getIconHeight()) / 2; // 세로 중앙 정렬
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

    public void flipImage() {
        if (!isFlipped) {
            sunfishImage.setImage(createFlippedImage(sunfishImage.getImage()));
            isFlipped = true;
        } else {
            sunfishImage.setImage(createFlippedImage(sunfishImage.getImage()));
            isFlipped = false;
        }
        repaint();
    }

    private Image createFlippedImage(Image image) {
        int width = image.getWidth(null);
        int height = image.getHeight(null);
        BufferedImage flippedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = flippedImage.createGraphics();
        g2d.drawImage(image, width, 0, -width, height, null);
        g2d.dispose();
        return flippedImage;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(sunfishImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    // 위로 이동하는 메서드
    public void moveUp(int distance) {
        y = Math.max(y - distance, 0);
        setLocation(x, y);
    }

    // 아래로 이동하는 메서드
    public void moveDown(int distance) {
        int bottomBound = getParent().getHeight() - getHeight();
        y = Math.min(y + distance, bottomBound-70);
        setLocation(x, y);
    }

    // 왼쪽으로 이동하는 메서드
    public void moveLeft(int distance) {
        x = Math.max(x - distance, 0);
        setLocation(x, y);
    }

    // 오른쪽으로 이동하는 메서드
    public void moveRight(int distance) {
        int rightBound = getParent().getWidth() - getWidth();
        x = Math.min(x + distance, rightBound);
        setLocation(x, y);
    }

}
