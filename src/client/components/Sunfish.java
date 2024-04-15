package client.components;
import javax.swing.*;
import java.awt.*;
    public class Sunfish extends JLabel {
        private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

        private static final int SUNFISH_WIDTH = 100; // 새로운 이미지의 너비
        private static final int SUNFISH_HEIGHT = 100; // 새로운 이미지의 높이

        private ImageIcon sunfishImage;

        public Sunfish() {

            ImageIcon originalImageIcon = new ImageIcon(SUNFISH_IMAGE_PATH);
            // 이미지를 새로운 크기로 조정
            Image originalImage = originalImageIcon.getImage();
            Image scaledImage = originalImage.getScaledInstance(SUNFISH_WIDTH, SUNFISH_HEIGHT, Image.SCALE_SMOOTH);
            // Load Sunfish image
            sunfishImage = new ImageIcon(scaledImage);

            // Set Sunfish image as the icon
            setIcon(sunfishImage);

            // Set bounds for Sunfish label to position it
            int x = (1280 - sunfishImage.getIconWidth()) / 2; // 가로 중앙 정렬
            int y = (980 - sunfishImage.getIconHeight()) / 2; // 세로 중앙 정렬
            setBounds(x, y, sunfishImage.getIconWidth(), sunfishImage.getIconHeight());
        }
    }