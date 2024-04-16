package client.utils;
import java.awt.*;

import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;

public class StringDrawUtil {
    static public void drawStringOutline(Graphics g, String s, int x, int y, Color c, Color cOutLine) {

        if (c == null)
            c = g.getColor();/* w ww  .j a v a  2 s .co m*/
        if (cOutLine == null)
            cOutLine = Color.black;
        if (!(g instanceof Graphics2D)) {
            g.drawString(s, x, y);
            return;
        }

        Graphics2D g2 = (Graphics2D) g;
        Color cb = g2.getColor();
        Object aliasing = g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        AffineTransform t = g2.getTransform();
        try {
            Font f = g2.getFont();
            FontMetrics fm = g2.getFontMetrics(f);
            GlyphVector v = f.createGlyphVector(fm.getFontRenderContext(), s);
            Shape s1 = v.getOutline();
            g2.translate(x, y);
            Stroke st = g2.getStroke();
            g2.setStroke(new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
            g.setColor(cOutLine);
            g2.draw(s1);
            g2.setStroke(st);
            g2.setColor(c);
            //          g2.translate(-0.3,-0.3);
            g2.fill(s1);
        } finally {
            g2.setTransform(t);
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, aliasing);
        g2.setColor(cb);
    }
}