package client.frame.miniGame;

import client.controller.FrontController;
import client.frame.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MiniGameDeadPanel extends JPanel {
    private final ImageIcon backgroundImage;
    private static final String MINIGAME_BACKGROUND_PATH = "src/client/assets/mini_game_dead_page.png";
    private JButton menuButton;

    public MiniGameDeadPanel(HomeScreen homeScreen) {
        backgroundImage = new ImageIcon(MINIGAME_BACKGROUND_PATH);
        setLayout(null);

        // 버튼 생성
        menuButton = new CustomButton("그만두고...  메뉴로 !");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeScreen.setVisible(true);
//                homeScreen.getContentPane().remove(1);
                homeScreen.revalidate();
                homeScreen.repaint();
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // 컴포넌트 크기가 변경될 때마다 버튼의 위치와 크기 조정
                menuButton.setBounds((getWidth() / 2) - 135, getHeight() - 280, 300, 80);
            }
        });
        // 버튼 추가
        add(menuButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 배경 이미지 그리기
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}


