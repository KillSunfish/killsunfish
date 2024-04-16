package client.components;

import client.utils.StringDrawUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelupPageComponent extends JComponent {
    private JButton btn_returnHome;
    private final String[] SUNFISH_IMG_PATH = new String[] {
            "src/client/assets/sunfish.jpg",
            "src/client/assets/sunfish.jpg",
            "src/client/assets/sunfish_2.jpg",
            "src/client/assets/sunfish_3.jpg",
            "src/client/assets/sunfish_4.jpg",
    } ;
    private BufferedImage sunfishImage;
    private LevelupAnimationComponent animationComponent;
    public LevelupPageComponent(int level) {
        setSize(1280, 960);

        btn_returnHome = new JButton(level == 4 ? "홈으로" : "계속");
        btn_returnHome.setFont(new Font(null, Font.BOLD, 35));
        btn_returnHome.setBounds(540, 750, 200, 80);
        btn_returnHome.setBackground(Color.WHITE);
        btn_returnHome.setBorder(new LineBorder(Color.BLACK));
        addBtnActionListener(btn_returnHome);
        this.add(btn_returnHome);

        try {
            this.sunfishImage = ImageIO.read(new File(SUNFISH_IMG_PATH[level]));
        } catch (IOException e) {
            System.out.println("failed to load ending image");
        }

        this.animationComponent = new LevelupAnimationComponent();

        animationComponent.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(animationComponent);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String levelupMessage = "축하합니다!";

        Font font = new Font(null, Font.BOLD, 80);
        g.setFont(font);

        FontMetrics metrics = g.getFontMetrics(font);
        int x = (this.getWidth() - metrics.stringWidth(levelupMessage)) / 2;

        StringDrawUtil.drawStringOutline(g, levelupMessage, x, 280, Color.WHITE, Color.BLACK);

        g.drawImage(sunfishImage, this.getWidth()/2 - sunfishImage.getWidth()/2, this.getHeight()/2 - sunfishImage.getHeight()/2, this);
    }

    private void addBtnActionListener(AbstractButton btn) {
        ActionListener actionListener = (e) -> {
            this.setVisible(false);
            repaint();
        };
        btn.addActionListener(actionListener);
    }
}

