package client.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import client.controller.FrontController;
import server.VO.UserVO;
import client.components.Navbar;
import client.components.CustomButton;
import client.components.StarFish;
import client.components.Sunfish;
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;
import client.frame.miniGame.MiniGamePanel;
import java.awt.event.ActionEvent;
import client.frame.miniGame.MenuButton;
import client.components.RottenFish;

public class HomeScreen extends JComponent {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
//    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

    private ImageIcon backgroundImage;
    private Navbar navbar;
    private CustomButton btn_plus;
    private CustomButton btn_minus;
    private JLabel lbl_temperature;
    public Sunfish sunfish;
    private Shrimp shrimp1, shrimp2;

    private ShellFish shellFish;

    private StarFish starfish1, starfish2, starfish3;
    private Octopus octopus;
    private JButton minigameButton;
    private MiniGamePanel miniGamePanel;
    private JLabel backgroundLabel;
    private Crab crab1, crab2;
    private RottenFish rottenfish1, rottenfish2, rottenfish3, rottenfish4, rottenfish5;

    private double temperature = 20.0;
    private double weight = 0.0; // 초기 weight 값
    private int tempDeath = 0; // 온도차로 사망할 때
    private int touchDeath = 0;  // 많이 만져서 사망할 때
    private Timer clickTimer; // 타이머 변수 선언
    private int clickFish = 0;
    private final int RESET_INTERVAL = 5000; // 5초마다 초기화

    private FrontController frontController;

    private int eatDeath = 0;
    private UserVO userVO;


    public HomeScreen(UserVO userVO) {
        this.userVO = userVO;
        System.out.println(userVO.getSunfishName());
        frontController = FrontController.getInstance();

        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);
        navbar = new Navbar();
//        setTitle("Sunfish Game");
        setSize(1280, 960);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create JLabel for background image
        backgroundLabel = new JLabel(backgroundImage);
        navbar.setBounds(130, 40, 1020, 110);
        add(navbar);

        btn_plus = new CustomButton("+");
        btn_plus.setBounds(1020, 180, 60, 40);
        addBtnPlusActionListener(btn_plus);
        add(btn_plus);

        btn_minus = new CustomButton("-");
        btn_minus.setBounds(1090, 180, 60, 40);
        addBtnMinusActionListener(btn_minus);
        add(btn_minus);

        lbl_temperature = new JLabel("" + temperature + "°C");
        lbl_temperature.setFont(new Font("Arial", Font.BOLD, 30));
        lbl_temperature.setBounds(1050, 150, 200, 30);
        add(lbl_temperature);

        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, -100, getWidth(), getHeight());

        sunfish = new Sunfish(navbar);
        octopus = new Octopus(-250, -250);

        sunfish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickFish++;
                if (clickFish > 7) {
                    touchDeath = -1;
                    frontController.sunfishDiesByCode(5);

                    System.out.println("새로운 변수 클릭 횟수: " + clickFish + "번 만져서 개복치 사망");
                } else {
                    System.out.println("새로운 변수 클릭 횟수: " + clickFish);
                }
            }
        });

        shellFish = new ShellFish(-10, -10);
        starfish1 = new StarFish(3, 3);
        starfish2 = new StarFish(3, 3);
        starfish3 = new StarFish(3, 3);

        crab1 = new Crab(5, 5);
        crab2 = new Crab(5, 5);

        shrimp1 = new Shrimp(15, 15);
        shrimp2 = new Shrimp(-7, -7);

        // Shrimp, ShellFish, Octopus, Crab, StarFish 객체의 MouseListener를 한 번에 추가
        MouseAdapter foodMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component foodComponent = (Component) e.getSource();
                if (foodComponent instanceof Shrimp) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.3);
                    navbar.setOrangeWidth(0.3);
                } else if (foodComponent instanceof ShellFish) {
                    increaseWeightAndMoveSunfish(foodComponent, 0.2);
                    navbar.setOrangeWidth(0.2);
                } else if (foodComponent instanceof Octopus) {
                    increaseWeightAndMoveSunfish(foodComponent, 1);
                    navbar.setOrangeWidth(1);
                } else if (foodComponent instanceof Crab) {

                    increaseWeightAndMoveSunfish(foodComponent, 0.4);
                    navbar.setOrangeWidth(0.4);
                } else if (foodComponent instanceof StarFish) {

                    increaseWeightAndMoveSunfish(foodComponent, 0.3);
                    navbar.setOrangeWidth(0.3);
                }

                // 모든 먹이가 없어졌을 때 다시 보이도록 설정
                if (!shrimp1.isVisible() && !shrimp2.isVisible() && !shellFish.isVisible() && !octopus.isVisible() && !crab1.isVisible() && !crab2.isVisible() &&
                        !starfish1.isVisible() && !starfish2.isVisible() && !starfish3.isVisible()) {
                    shrimp1.setVisible(true);
                    shrimp2.setVisible(true);
                    shellFish.setVisible(true);
                    octopus.setVisible(true);
                    crab1.setVisible(true);
                    crab2.setVisible(true);
                    starfish1.setVisible(true);
                    starfish2.setVisible(true);
                    starfish3.setVisible(true);
                }
            }
        };

        shrimp1.addMouseListener(foodMouseListener);
        shrimp2.addMouseListener(foodMouseListener);
        shellFish.addMouseListener(foodMouseListener);
        octopus.addMouseListener(foodMouseListener);
        crab1.addMouseListener(foodMouseListener);
        crab2.addMouseListener(foodMouseListener);
        starfish1.addMouseListener(foodMouseListener);
        starfish2.addMouseListener(foodMouseListener);
        starfish3.addMouseListener(foodMouseListener);

        rottenfish1 = new RottenFish(5, 5);
        rottenfish2 = new RottenFish(5, 5);
        rottenfish3 = new RottenFish(5, 5);
        rottenfish4 = new RottenFish(5, 5);
        rottenfish5 = new RottenFish(5, 5);

        backgroundLabel.add(rottenfish1);
        backgroundLabel.add(rottenfish2);
        backgroundLabel.add(rottenfish3);
        backgroundLabel.add(rottenfish4);
        backgroundLabel.add(rottenfish5);

        rottenfish1.startMoving();
        rottenfish2.startMoving();
        rottenfish3.startMoving();
        rottenfish4.startMoving();
        rottenfish5.startMoving();

        // RottenFish를 클릭하면 개복치가 죽음
        MouseAdapter rottenFishMouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                eatDeath = -1;
                frontController.sunfishDiesByCode(1);
                System.out.println("RottenFish를 클릭하여 개복치가 죽었습니다.: " + eatDeath);
            }
        };

        rottenfish1.addMouseListener(rottenFishMouseListener);
        rottenfish2.addMouseListener(rottenFishMouseListener);
        rottenfish3.addMouseListener(rottenFishMouseListener);
        rottenfish4.addMouseListener(rottenFishMouseListener);
        rottenfish5.addMouseListener(rottenFishMouseListener);

        add(backgroundLabel);
        backgroundLabel.add(sunfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab1);
        backgroundLabel.add(crab2);

        clickTimer = new Timer(RESET_INTERVAL, (e) -> {
            clickFish = 0; // 클릭 횟수 초기화
            System.out.println("클릭 횟수가 초기화되었습니다." + clickFish);
        });
        clickTimer.start();
        backgroundLabel.add(shrimp1);
        backgroundLabel.add(shrimp2);
        backgroundLabel.add(shellFish);
        backgroundLabel.add(starfish1);
        backgroundLabel.add(starfish2);
        backgroundLabel.add(starfish3);

        octopus.startMoving();
        crab1.startMoving();
        crab2.startMoving();
        shrimp1.startMoving();
        shrimp2.startMoving();
        shellFish.startMoving();
        starfish1.startMoving();
        starfish2.startMoving();
        starfish3.startMoving();

        navbar.setWeight(userVO.getWeight());


        MenuButton menuButton = new MenuButton(this);
        menuButton.setBounds(getWidth() - 160, getHeight() - 150, 130, 120);
        backgroundLabel.add(menuButton);
        add(backgroundLabel);

        menuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backgroundLabel.setVisible(false);
                miniGamePanel.setVisible(true);
            }
        });


        miniGamePanel = new MiniGamePanel(this, navbar);
        miniGamePanel.setBounds(0, 0, getWidth(), getHeight());
        miniGamePanel.setVisible(false);
        add(miniGamePanel);

    }

    public void showMiniGamePanel() {
        clickTimer = new Timer(RESET_INTERVAL, (e) -> {
            clickFish = 0; // 클릭 횟수 초기화
            System.out.println("클릭 횟수가 초기화되었습니다." + clickFish);
        });
        clickTimer.start();
        backgroundLabel.add(shrimp1);
        backgroundLabel.add(shrimp2);
        backgroundLabel.add(shellFish);
        backgroundLabel.add(starfish1);
        backgroundLabel.add(starfish2);
        backgroundLabel.add(starfish3);

        octopus.startMoving();
        crab1.startMoving();
        crab2.startMoving();
        shrimp1.startMoving();
        shrimp2.startMoving();
        shellFish.startMoving();
        starfish1.startMoving();
        starfish2.startMoving();
        starfish3.startMoving();

        navbar.setWeight(userVO.getWeight());
    }

    public void removeMiniGamePanel() {
        backgroundLabel.setVisible(true);
        miniGamePanel.setVisible(false);

        showMiniGamePanel();
        repaint();
    }

    private void increaseWeightAndMoveSunfish(Component foodComponent, double weightIncrease) {
        System.out.println(weightIncrease);
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
        };

        btn.addActionListener(actionListener);
    }

    private void addBtnMinusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature -= 1;
            updateTemperatureLabel();
            checkTemperatureRange();
        };

        btn.addActionListener(actionListener);
    }

    private void updateTemperatureLabel() {
        lbl_temperature.setText("" + String.format("%.1f", temperature) + "°C");
    }

    private void checkTemperatureRange() {
        if (temperature < 15 || temperature > 25) {
            tempDeath = -1;
            frontController.sunfishDiesByCode(6);
            System.out.println("온도가 15도 미만이거나 25도를 초과하여 개복치가 죽었습니다.: " + tempDeath);
        }
    }

//     public void updateSunfishLevel(int level) {
//         sunfish.updateImage(level);
//     }


//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            UserVO userVO = new UserVO();
//            HomeScreen homeScreen = new HomeScreen(userVO);
//            homeScreen.setVisible(true);
//        });
//    }
}

