package client.components;

import javax.swing.*;
import java.awt.*;
public class RottenFish extends SeaCreature{
    private static final String ROTTENFISH_IMAGE_PATH = "src/client/assets/rottenFish.png";
    private static final int ROTTENFISH_WIDTH = 70; // 새로운 이미지의 너비
    private static final int ROTTENFISH_HEIGHT = 70; // 새로운 이미지의 높이
    public RottenFish(int xSpeed, int ySpeed){

        super(ROTTENFISH_IMAGE_PATH, ROTTENFISH_WIDTH, ROTTENFISH_HEIGHT, xSpeed , ySpeed );
    }
}
