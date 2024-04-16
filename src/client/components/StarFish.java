package client.components;

public class StarFish extends SeaCreature {
    private static final String STARFISH_IMAGE_PATH = "src/client/assets/starFish.png";
    private static final int STARFISH_WIDTH = 70; // 새로운 이미지의 너비
    private static final int STARFISH_HEIGHT = 70; // 새로운 이미지의 높이

    public StarFish(int xSpeed, int ySpeed) {
        super(STARFISH_IMAGE_PATH, STARFISH_WIDTH, STARFISH_HEIGHT, xSpeed, ySpeed);
    }
}



