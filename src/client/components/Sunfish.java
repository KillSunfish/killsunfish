
package client.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sunfish extends JLabel {
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

    private static final int SUNFISH_WIDTH = 100; // 새로운 이미지의 너비
    private static final int SUNFISH_HEIGHT = 100; // 새로운 이미지의 높이

    private ImageIcon sunfishImage;
    private int x;
    private int y;
    private boolean isFlipped = false; // 좌우 반전 여부

    public Sunfish() {

        ImageIcon originalImageIcon = new ImageIcon(SUNFISH_IMAGE_PATH);
        // 이미지를 새로운 크기로 조정
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
        // Load Sunfish image
        sunfishImage = new ImageIcon(scaledImage);

        // Set Sunfish image as the icon
        setIcon(sunfishImage);

        // Set bounds for Sunfish label to position it
        x = (1280 - sunfishImage.getIconWidth()) / 2; // 가로 중앙 정렬
        y = (980 - sunfishImage.getIconHeight()) / 2; // 세로 중앙 정렬
        setBounds(x, y, sunfishImage.getIconWidth(), sunfishImage.getIconHeight());
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
