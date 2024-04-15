package client.components;

import javax.swing.*;
import java.awt.*;

public abstract class SeaCreature extends JLabel {
    protected ImageIcon imageIcon;
    protected int width;
    protected int height;

    public SeaCreature(String imagePath, int width, int height) {
        this.width = width;
        this.height = height;

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
        setBounds(x, y, width, height);
    }
}
