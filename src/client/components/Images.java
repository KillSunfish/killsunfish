package client.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Images extends JComponent {
    private Image img;
    private String IMG_PATH;

    public Images(String path) {
        setVisible(true);
        try {
            IMG_PATH = path;
//            img_sunfish = new ImageIcon(IMG_SUNFISH_PATH).getImage();
            this.img = ImageIO.read(new File(IMG_PATH));
        } catch (Exception e) {
            e.printStackTrace();
            img = null;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (IMG_PATH!=null && IMG_PATH.contains("sunfish")) {
            g.drawImage(img, 0, 0, 180,180, this);
        } else {
            g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
        }
    }
}
