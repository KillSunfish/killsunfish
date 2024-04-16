package client.components;

public class Shrimp extends SeaCreature {
    private static final String SHRIMP_IMAGE_PATH = "src/client/assets/shrimp.png";
    private static final int SHRIMP_WIDTH = 70; // 새로운 이미지의 너비
    private static final int SHRIMP_HEIGHT = 70; // 새로운 이미지의 높이

    public Shrimp(int xSpeed, int ySpeed) {
        super(SHRIMP_IMAGE_PATH, SHRIMP_WIDTH, SHRIMP_HEIGHT, xSpeed, ySpeed);
    }
}


