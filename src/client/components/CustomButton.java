package client.components;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private Color backgroundColor = new Color(0x289aff);
    private Color hoverColor = new Color(89, 119, 222);

    public CustomButton(String text) {
        super(text);
        setOpaque(false); // 배경 불투명도 비활성화
        setContentAreaFilled(false); // 내용 영역 채우기 비활성화
        setBorderPainted(false); // 테두리 그리기 비활성화
        setForeground(Color.BLACK);
        setFont(new Font("Arial", Font.BOLD, 20));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.TOP); // 텍스트를 버튼의 맨 위로 설정
        setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 수평 가운데로 설정
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,getWidth(),getHeight());

        Color color = new Color(0x289aff);
        g2d.setColor(color);
        g2d.fillRect(3,3,54,34);
        super.paintComponent(g);

    }

    @Override
    protected void paintBorder(Graphics g) {
        // 테두리 그리기 비활성화
    }
}
