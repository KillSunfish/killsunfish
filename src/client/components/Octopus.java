package client.components;

import javax.swing.*;
import java.awt.*;
public class Octopus extends SeaCreature{
    private static final String OCTOPUS_IMAGE_PATH = "src/client/assets/octopus.png";
    private static final int OCTOPUS_WIDTH = 70; // 새로운 이미지의 너비
    private static final int OCTOPUS_HEIGHT = 70; // 새로운 이미지의 높이

    public Octopus(int xSpeed, int ySpeed) {

        super(OCTOPUS_IMAGE_PATH, OCTOPUS_WIDTH, OCTOPUS_HEIGHT , xSpeed, ySpeed);
    }
}
