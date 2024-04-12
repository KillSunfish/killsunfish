package client.frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

class BackgroundImagePanel extends JComponent {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
    private static final String INTRO_BACKGROUND_PATH = "src/client/assets/intro_background.png";
    private Image backgroundImage;

    /**
     * Constructor
     * @param mode mode can be `'ingame' or 'intro'
     */
    public BackgroundImagePanel(String mode) {
        setBackgroundImage(mode);
    }

    /**
     * paint component with image
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }

    /**
     * load image file
     * @param mode 'intro' or 'ingame'
     * @return success or fail
     */
    private boolean setBackgroundImage(String mode) {
        try {
            this.backgroundImage = ImageIO.read(new File("intro".equals(mode) ? INTRO_BACKGROUND_PATH : INGAME_BACKGROUND_PATH));
            return true;
        } catch (Exception e) {
            System.out.println("Failed to load background image");
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * can modify background image, must repaint after modified
     * @param mode 'intro' or 'ingame'
     */
    public void modifyBackgroundImage(String mode) {
        setBackgroundImage(mode);
    }
}
