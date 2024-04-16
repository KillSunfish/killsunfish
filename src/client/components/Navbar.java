package client.components;

import javax.swing.*;
import java.awt.*;
import client.components.Sunfish;

public class Navbar extends JPanel {
    private int orangeWidth = 0; // 주황색 칸의 너비
    private double weight = 0.1; // 무게
    private int level = 1; // 레벨
    private Sunfish sunfish;

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
        g2d.fillRect(10, 8, 1000, 60);

        // 세 번째 직사각형 그리기 (크기가 작은 사각형)
        g2d.setColor(Color.BLACK);
        g2d.fillRect(10, 75, 1000, 28);

        // 주황색 칸 그리기
        g2d.setColor(Color.ORANGE);
        g2d.fillRect(10, 75, orangeWidth, 28);
        // 텍스트 그리기
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 50)); // 폰트 설정
        g2d.drawString("LV." + level + " : 개복치", 20, 55); // 텍스트 그리기

        // Weight 값 표시
        g2d.drawString(String.format("%.1f", weight) + "KG", 830, 55); // 텍스트 그리기
    }

    // 주황색 칸의 너비를 설정하는 메서드
    public void setOrangeWidth(double weightIncrease) {
        int maxOrangeWidth = 1000; // 주황색 칸의 최대 너비
        double maxWeight = 10.0; // 주황색 칸이 가득 차게 하는 최대 무게
//        int increaseWidth = (int) (maxOrangeWidth * (weightIncrease / maxWeight)); // 주황색 칸의 증가 너비 계산
//        this.orangeWidth = Math.min(this.orangeWidth + increaseWidth, maxOrangeWidth); // 주황색 칸의 너비를 증가시키되 최대 너비를 초과하지 않도록 함
        this.orangeWidth += weightIncrease * 100;
        if (this.orangeWidth >=1000){
            this.orangeWidth = this.orangeWidth-1000;
            levelUp(); // 레벨 업
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
    // 레벨을 증가시키는 메서드
    private void levelUp() {
        level++;
    }

}
