package client.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class EndingPageComponent extends JComponent {
    private JButton btn_returnHome;
    private BufferedImage endingImage;
    public EndingPageComponent() {
        setSize(1280, 960);

        btn_returnHome = new JButton("홈으로");
        btn_returnHome.setFont(new Font(null, Font.BOLD, 35));
        btn_returnHome.setBounds(540, 750, 200, 80);
        btn_returnHome.setBackground(Color.WHITE);
        btn_returnHome.setBorder(new LineBorder(Color.BLACK));
        addBtnActionListener(btn_returnHome);
        this.add(btn_returnHome);

        try {
            this.endingImage = ImageIO.read(new File("src/client/assets/ending.png"));
        } catch (IOException e) {
            System.out.println("failed to load ending image");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(endingImage, 400, 150, this);
    }

    private void addBtnActionListener(AbstractButton btn) {
        ActionListener actionListener = (e) -> {
            this.setVisible(false);
            repaint();
        };
        btn.addActionListener(actionListener);
    }
}
