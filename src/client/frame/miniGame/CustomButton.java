package client.frame.miniGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {
    private static final int NORMAL_WIDTH = 200;
    private static final int NORMAL_HEIGHT = 50;
    private static final int ENLARGED_WIDTH = 210;
    private static final int ENLARGED_HEIGHT = 60;
    private boolean isMouseOver = false;

    public CustomButton(String text) {
        setText(text);
        setOpaque(false); // 투명 설정
        setContentAreaFilled(false); // 내용 영역 채우기 비활성화
        setBorderPainted(false); // 테두리 그리기 비활성화
        setFont(new Font("NanumGothic", Font.BOLD, 25)); // 폰트 설정
        setForeground(Color.WHITE); // 전경색 설정
        setPreferredSize(new Dimension(NORMAL_WIDTH, NORMAL_HEIGHT)); // 버튼 크기 설정

        // 마우스 리스너 추가
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                setPreferredSize(new Dimension(ENLARGED_WIDTH, ENLARGED_HEIGHT));
                getParent().revalidate(); // 크기 변경 적용
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                setPreferredSize(new Dimension(NORMAL_WIDTH, NORMAL_HEIGHT));
                getParent().revalidate(); // 크기 변경 적용
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 128, 255)); // 파란색
        if (isMouseOver) {
            g2.fillRoundRect(5, 5, ENLARGED_WIDTH, ENLARGED_HEIGHT, 20, 20); // 마우스가 올라간 경우 크기 늘리기
        } else {
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // 둥근 사각형으로 버튼 그리기
        }
        g2.setStroke(new BasicStroke(5));
        g2.setColor(Color.WHITE); // 흰색 테두리
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); // 테두리 그리기
        FontMetrics metrics = g2.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.drawString(getText(), x, y); // 버튼 텍스트 그리기
        g2.dispose();
    }
}
