package client.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


import server.VO.UserVO;
import client.components.Navbar;
import client.components.CustomButton;
import client.components.StarFish;
import client.components.Sunfish;
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;
import client.components.RottenFish;

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
    private double weight = 0.1; // 초기 weight 값
    private int tempDeath = 0; // 온도차로 사망할 때
    private int touchDeath = 0;  // 많이 만져서 사망할 때
    private Timer clickTimer; // 타이머 변수 선언
    private int clickFish = 0;
    private final int RESET_INTERVAL = 5000; // 5초마다 초기화

    public HomeScreen(UserVO userVO) {
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
                clickFish++;
                if (clickFish>7){
                    touchDeath = -1;
                    System.out.println("새로운 변수 클릭 횟수: " + clickFish+ "번 만져서 개복치 사망");
                }
                else{
                    System.out.println("새로운 변수 클릭 횟수: " + clickFish);
                }

            }
        });

        octopus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                increaseWeightAndMoveSunfish(octopus, 0.6);

            }
        });

        shellFish = new ShellFish(-10, -10);
        shellFish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                increaseWeightAndMoveSunfish(shellFish, 0.2);
            }
        });

        starfish = new StarFish(1,1);
        crab = new Crab(5,5);
        shrimp = new Shrimp(15,15);

        // Shrimp, ShellFish, Octopus, Crab, StarFish 객체의 MouseListener를 한 번에 추가
        MouseAdapter foodMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component foodComponent = (Component) e.getSource();
                if (foodComponent instanceof Shrimp) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.35);
                    navbar.setOrangeWidth(0.35);
                } else if (foodComponent instanceof ShellFish) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.2);
                    navbar.setOrangeWidth(0.2);
                } else if (foodComponent instanceof Octopus) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.6);
                    navbar.setOrangeWidth(0.6);
                } else if (foodComponent instanceof Crab) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.3);
                    navbar.setOrangeWidth(0.3);
                } else if (foodComponent instanceof StarFish) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.25);
                    navbar.setOrangeWidth(0.25);
                }
            }
        };

        shrimp.addMouseListener(foodMouseListener);
        shellFish.addMouseListener(foodMouseListener);
        octopus.addMouseListener(foodMouseListener);
        crab.addMouseListener(foodMouseListener);
        starfish.addMouseListener(foodMouseListener);

        add(backgroundLabel);
        backgroundLabel.add(sunfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab);

        clickTimer = new Timer(RESET_INTERVAL, (e) -> {
            clickFish = 0; // 클릭 횟수 초기화
            System.out.println("클릭 횟수가 초기화되었습니다."+clickFish);
        });
        clickTimer.start();
        backgroundLabel.add(shrimp);
        backgroundLabel.add(shellFish);
        backgroundLabel.add(starfish);

        octopus.startMoving();
        crab.startMoving();
        shrimp.startMoving();
        shellFish.startMoving();
        starfish.startMoving();

        for (int i = 0; i < 5; i++) {
            RottenFish rottenFish = new RottenFish(5, 5);
            backgroundLabel.add(rottenFish);
            rottenFish.startMoving();
        }

        navbar.setWeight(userVO.getWeight());
    }

    private void increaseWeightAndMoveSunfish(Component foodComponent, double weightIncrease) {
        weight += weightIncrease;
        navbar.setWeight(weight);

        sunfish.setLocation(foodComponent.getX(), foodComponent.getY());
        foodComponent.setVisible(false);
    }

    private void addBtnPlusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature += 1;
            updateTemperatureLabel();
            checkTemperatureRange();
            navbar.setOrangeWidth((int) weight * 10);
        };

        btn.addActionListener(actionListener);
    }

    private void addBtnMinusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature -= 1;
            updateTemperatureLabel();
            checkTemperatureRange();
            navbar.setOrangeWidth((int) weight * 100);
        };

        btn.addActionListener(actionListener);
    }

    private void updateTemperatureLabel() {
        lbl_temperature.setText("" + String.format("%.1f", temperature) + "°C");
    }

    private void checkTemperatureRange() {
        if (temperature < 15 || temperature > 25) {
            tempDeath = -1;
            System.out.println("온도가 15도 미만이거나 25도를 초과하여 개복치가 죽었습니다.: " + tempDeath);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserVO userVO = new UserVO();
            HomeScreen homeScreen = new HomeScreen(userVO);
            homeScreen.setVisible(true);
        });
    }
}
