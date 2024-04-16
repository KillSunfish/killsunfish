package client.components;

import javax.swing.*;
import java.awt.*;

public abstract class SeaCreature extends JLabel {
    protected ImageIcon imageIcon;
    protected int width;
    protected int height;
    protected int xSpeed;
    protected int ySpeed;

    public SeaCreature(String imagePath, int width, int height, int xSpeed, int ySpeed) {
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        // 원본 이미지를 가져옴
        ImageIcon originalImageIcon = new ImageIcon(imagePath);
        // 이미지를 새로운 크기로 조정
        Image originalImage = originalImageIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // 새로운 이미지 아이콘 생성
        imageIcon = new ImageIcon(scaledImage);

        // JLabel에 아이콘 설정
        setIcon(imageIcon);

        // Set bounds for label to position it randomly
        int x = (int) (Math.random() * (1280 - width)); // 가로 위치를 랜덤으로 설정
        int y = (int) (Math.random() * (960 - height)); // 세로 위치를 랜덤으로 설정
        // Ensure x and y are within screen boundaries
        x = Math.max(x, 0);
        y = Math.max(y, 0);
        x = Math.min(x, 1280 - width);
        y = Math.min(y, 960 - height);
        setBounds(x, y, width, height);
    }

    public void startMoving() {
        Timer timer = new Timer(1000, e -> {
            int newX = getX() + xSpeed; // X 위치에 xSpeed를 더함
            int newY = getY() + ySpeed; // Y 위치에 ySpeed를 더함

            // Check if the new position is within screen boundaries
            if (newX < 0 || newX > 1280 - width) {
                // If the new X position is outside the screen, reverse the xSpeed to change direction
                xSpeed = -xSpeed;
            }
            if (newY < 0 || newY > 960 - height) {
                // If the new Y position is outside the screen, reverse the ySpeed to change direction
                ySpeed = -ySpeed;
            }

            // Calculate the new position again with updated speed
            newX = getX() + xSpeed;
            newY = getY() + ySpeed;

            // Ensure newX and newY are within screen boundaries
            newX = Math.max(newX, 0);
            newY = Math.max(newY, 0);
            newX = Math.min(newX, 1280 - width);
            newY = Math.min(newY, 960 - height);

            // Set the new position
            setLocation(newX, newY);
        });
        timer.start();
    }

}
