
package client.components;

public class ShellFish extends SeaCreature {
    private static final String SHELLFISH_IMAGE_PATH = "src/client/assets/shellFish.png";
    private static final int SHELLFISH_WIDTH = 70; // 새로운 이미지의 너비
    private static final int SHELLFISH_HEIGHT = 70; // 새로운 이미지의 높이

    public ShellFish(int xSpeed, int ySpeed) {
        super(SHELLFISH_IMAGE_PATH, SHELLFISH_WIDTH, SHELLFISH_HEIGHT, xSpeed, ySpeed);
    }
}
