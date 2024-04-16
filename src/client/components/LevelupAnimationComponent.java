package client.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LevelupAnimationComponent extends JPanel implements ActionListener {
    private int diameter = 100; // Initial diameter of the circle
    private Color backgroundColor = new Color(57, 57, 57, 128);
    private Timer timer;

    public LevelupAnimationComponent() {
        timer = new Timer(100, this); // Timer with 100 milliseconds delay
        timer.start(); // Start the timer
        setBackground(backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(centerX - diameter / 2, centerY - diameter / 2, diameter, diameter);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Increase the diameter by 5 pixels in each step
        diameter += 10;
        repaint(); // Redraw the circle

        if(diameter > 300) {
            this.setVisible(false);
            timer.stop();
        }
    }
}
