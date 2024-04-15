package client.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import client.components.Navbar;
import client.components.CustomButton;
import client.components.StarFish;
import client.components.Sunfish;
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;
import client.components.RottenFish;
import client.components.ShellFish;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

    private ImageIcon backgroundImage;
    private Navbar navbar;
    private CustomButton btn_plus;
    private CustomButton btn_minus;
    private JLabel lbl_temperature;
    private Sunfish sunfish;
    private Shrimp shrimp;

    private ShellFish shellFish;

    private StarFish starfish;
    private Octopus octopus;
    private Crab crab;
    private RottenFish rottenfish;

    private double temperature = 20.0;
    private int weight = 30;
    private int tempDeath = 0; // 온도차로 사망할 때
    private int touchDeath = 0;  // 많이 만져서 사망할 때

    public HomeScreen() {
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);
        navbar = new Navbar();
        setTitle("Sunfish Game");
        setSize(1280, 960);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        navbar.setBounds(65, 40, 1150, 110);
        add(navbar);

        btn_plus = new CustomButton("+");
        btn_plus.setBounds(1080, 180, 60, 40);
        addBtnPlusActionListener(btn_plus);
        add(btn_plus);

        btn_minus = new CustomButton("-");
        btn_minus.setBounds(1150, 180, 60, 40);
        addBtnMinusActionListener(btn_minus);
        add(btn_minus);

        lbl_temperature = new JLabel("" + temperature + "°C");
        lbl_temperature.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_temperature.setBounds(1120, 150, 200, 30);
        add(lbl_temperature);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, -100, getWidth(), getHeight());

        sunfish = new Sunfish();
        octopus = new Octopus(-250, -250);
        crab = new Crab(5,5);

        sunfish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                touchDeath++;
                System.out.println("새로운 변수 클릭 횟수: " + touchDeath);
            }
        });

        add(backgroundLabel);
        backgroundLabel.add(sunfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab);
    }


        // Add background label to the frame
        add(backgroundLabel);


        octopus.startMoving();
        crab.startMoving();

        for (int i = 0; i < 5; i++) {
            RottenFish rottenFish = new RottenFish(5, 5); // 움직임 설정
            backgroundLabel.add(rottenFish);
            rottenFish.startMoving();
        }

        for (int i = 0; i < 3; i++) {
            StarFish starfish = new StarFish(1,1); // 움직임 설정
            backgroundLabel.add(starfish);
            starfish.startMoving();
        }

        for (int i = 0; i < 2; i++) {
            Shrimp shrimp = new Shrimp(15,15); // 움직임 설정
            ShellFish shellFish = new ShellFish(-10, -10);
            backgroundLabel.add(shrimp);
            backgroundLabel.add(shellFish);
            shrimp.startMoving();
            shellFish.startMoving();
        }

    private void addBtnPlusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature += 1;
            updateTemperatureLabel();
            checkTemperatureRange();
            navbar.setOrangeWidth((int) weight * 10); // 온도에 따라 주황색 칸의 너비 변경
        };

        btn.addActionListener(actionListener);
    }

    private void addBtnMinusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature -= 1;
            updateTemperatureLabel();
            checkTemperatureRange();
            navbar.setOrangeWidth((int) weight * 100); // 온도에 따라 주황색 칸의 너비 변경
        };

        btn.addActionListener(actionListener);
    }

    private void updateTemperatureLabel() {
        lbl_temperature.setText("" + String.format("%.1f", temperature) + "°C");
    }

    // 25도 초과, 15도 미만일 때 사망.
    private void checkTemperatureRange() {
        if (temperature < 15 || temperature > 25) {
            tempDeath = -1; // 새로운 변수 초기화
            System.out.println("온도가 15도 미만이거나 25도를 초과하여 개복치가 죽었습니다.: " + tempDeath);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}
