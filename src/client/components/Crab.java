package client.components;

import javax.swing.*;
import java.awt.*;
public class Crab extends SeaCreature{
    private static final String CRAB_IMAGE_PATH = "src/client/assets/crab.png";
    private static final int CRAB_WIDTH = 70; // 새로운 이미지의 너비
    private static final int CRAB_HEIGHT = 70; // 새로운 이미지의 높이

    public Crab(int xSpeed, int ySpeed) {
        super(CRAB_IMAGE_PATH, CRAB_WIDTH, CRAB_HEIGHT, xSpeed , ySpeed);
    }
}