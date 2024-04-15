package client.components;

import javax.swing.*;
import java.awt.*;

public class Navbar extends JPanel {

    public Navbar() {
        setPreferredSize(new Dimension(1280, 50)); // Navbar의 크기 설정
        setBackground(Color.GRAY); // 배경색 설정
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Color color = new Color(0x289aff);
        // 첫 번째 직사각형 그리기 (크기가 더 큰 사각형)
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // 두 번째 직사각형 그리기 (크기가 작은 사각형)
        g2d.setColor(color);
        g2d.fillRect(10, 8, 1130, 60);

        // 세 번째 직사각형 그리기 (크기가 작은 사각형)
        g2d.setColor(Color.BLACK);
        g2d.fillRect(10, 75, 1130, 28);

        // 텍스트 그리기
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 50)); // 폰트 설정
        g2d.drawString("LV.1 : 개복치", 20, 55); // 텍스트 그리기

        g2d.drawString("0.3KG", 980, 55); // 텍스트 그리기

    }
}
