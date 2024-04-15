package client.components;

import client.utils.StringDrawUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class DeathImageComponent extends JComponent {
    private BufferedImage deathImage;
    private int deathCode;

    private String[] deathMessages = new String[] {
            "사망 ㅋ", "잘못 먹어서 사망", "과식해서 사망", "아사해서 사망", "무서워서 사망",
            "너무 만져서 사망", "온도 안 맞아서 사망", "너무 맛있어서 사망",
    };

    public DeathImageComponent(int deathCode) {
        this.deathCode = checkInRange(deathCode) ? deathCode : 0;
        setSize(1280, 960);
        try {
//            this.deathImage = ImageIO.read(new File("src/client/assets/death.png"));
            this.deathImage = ImageIO.read(new File("src/client/assets/death_1.png"));
        } catch (IOException e) {
            System.out.println("failed to load death image");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String deathMessage = deathMessages[deathCode];

        Font font = new Font(null, Font.BOLD, 80);
        g.setFont(font);

        FontMetrics metrics = g.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = (this.getWidth() - metrics.stringWidth(deathMessage)) / 2;

        StringDrawUtil.drawStringOutline(g, deathMessage, x, 280, Color.WHITE, Color.BLACK);

        g.drawImage(deathImage, 330, 300, this);
    }

    private boolean checkInRange(int idx) {
        if(idx < 0 || idx >= this.deathMessages.length) return false;

        return true;
    }
}
