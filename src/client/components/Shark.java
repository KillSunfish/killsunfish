package client.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Shark extends JLabel {
    private static final String SHARK_IMAGE_PATH = "src/client/assets/shark.png";
    public static final int SHARK_WIDTH = 250;
    public static final int SHARK_HEIGHT = 180;
    private ImageIcon sharkImage;
    private int x;
    private int y;
    private int direction; // 이동 방향: -1 (왼쪽), 1 (오른쪽)
    private int speed;

    public Shark(int x, int y, int direction, int speed) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        sharkImage = new ImageIcon(SHARK_IMAGE_PATH);
        setIcon(sharkImage);
        setBounds(x, y, SHARK_WIDTH, SHARK_HEIGHT);
    }

    public void move(int distance) {
        x += direction * distance;
        setLocation(x, y);
    }

    public void draw(Graphics g) {
        BufferedImage bufferedImage = new BufferedImage(sharkImage.getIconWidth(), sharkImage.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(sharkImage.getImage(), 0, 0, null);
        g2d.dispose();

        if (direction == 1) {
            // 좌우 반전
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-bufferedImage.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            bufferedImage = op.filter(bufferedImage, null);
        }

        g.drawImage(bufferedImage, x, y, SHARK_WIDTH, SHARK_HEIGHT, null);
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed(){
        return speed;
    }
}
