package client.components;

import javax.swing.*;
import java.awt.*;

public class Navbar extends JPanel {
    private int orangeWidth = 30; // 주황색 칸의 너비
    private double weight = 0.1; // 무게

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

        // 주황색 칸 그리기
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(10, 75, orangeWidth, 28);
        // 텍스트 그리기
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 50)); // 폰트 설정
        g2d.drawString("LV.1 : 개복치", 20, 55); // 텍스트 그리기

        // Weight 값 표시
        g2d.drawString(String.format("%.1f", weight) + "KG", 980, 55); // 텍스트 그리기
    }

    // 주황색 칸의 너비를 설정하는 메서드
    public void setOrangeWidth(double weightIncrease) {
        int maxOrangeWidth = 1130; // 주황색 칸의 최대 너비
        int maxWidthPerKg = maxOrangeWidth / 10; // 10kg에 해당하는 최대 너비
        int increaseWidth = (int) (maxWidthPerKg * weightIncrease); // 먹이 무게에 따른 주황색 칸의 증가 너비 계산

        this.orangeWidth += increaseWidth;
        if (this.orangeWidth >= maxOrangeWidth) {
            this.orangeWidth = maxOrangeWidth;
        }
        repaint(); // 그래픽을 다시 그리도록 호출
    }

    // Weight 값을 설정하는 메서드
    public void setWeight(double weight) {
        this.weight = weight;
        repaint(); // 그래픽을 다시 그리도록 호출
    }

    // Weight 값을 반환하는 메서드
    public double getWeight() {
        return weight;
    }
}
