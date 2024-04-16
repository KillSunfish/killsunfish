package client.frame.miniGame;

import client.frame.HomeScreen;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


    public class MenuButton extends JPanel {
        private static final String GAME_MENU_PATH = "src/client/assets/game_menu.png";
        private static final String TEXT = "미니게임";

        private Image buttonImage;
        private HomeScreen homeScreen;
        private boolean isMouseOver = false;

        public MenuButton(HomeScreen homeScreen) {
            this.homeScreen = homeScreen;
            try {
                buttonImage = ImageIO.read(new File(GAME_MENU_PATH));
                buttonImage = buttonImage.getScaledInstance(130, 120, Image.SCALE_SMOOTH);
            } catch (IOException e) {
                e.printStackTrace();
            }

            setPreferredSize(new Dimension(buttonImage.getWidth(this), buttonImage.getHeight(this)));
            setOpaque(false);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isMouseOver = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isMouseOver = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            if (isMouseOver) {
                // 마우스가 감지되면 조금 커지도록 크기를 늘립니다.
                width += 5;
                height += 5;
            }

            g.drawImage(buttonImage, 0, 0, width, height, this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("NanumGothic", Font.BOLD, 15));
            FontMetrics metrics = g.getFontMetrics();
            int x = (width - metrics.stringWidth(TEXT)) / 2;
            int y = (height - metrics.getHeight()) / 2 + metrics.getAscent() + 10;
            g.drawString(TEXT, x, y);
        }

    }

