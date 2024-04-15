package client.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import client.components.Navbar;
import client.components.CustomButton;
import client.components.StarFish;
import client.components.Sunfish; // Sunfish 클래스 임포트
import client.components.Shrimp;
import client.components.ShellFish;
import client.components.Octopus;
import client.components.Crab;

public class HomeScreen extends JFrame {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
    private static final String SUNFISH_IMAGE_PATH = "src/client/assets/sunfish.jpg";

    private ImageIcon backgroundImage;
    private Navbar navbar; // Navbar 객체 선언
    private CustomButton btn_plus;
    private CustomButton btn_minus;
    private JLabel lbl_temperature;
    private Sunfish sunfish; // Sunfish 객체 선언
    private Shrimp shrimp;
    private ShellFish shellfish;

    private StarFish starfish;
    private Octopus octopus;
    private Crab crab;

    private double temperature = 37.0;

    public HomeScreen() {
        // Load images
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);
        

        navbar = new Navbar(); // Navbar 객체 생성

        // Set frame properties
        setTitle("Sunfish Game");
        setSize(1280, 960); // 화면 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Navbar 위치 지정
        navbar.setBounds(65, 40, 1150, 110); // Navbar의 위치 설정
        add(navbar); // Navbar를 프레임에 추가

        // 버튼 생성 및 리스너 추가
        btn_plus = new CustomButton("+");
        btn_plus.setBounds(1080, 180, 60, 40); // 버튼 위치 및 크기 설정
        addBtnPlusActionListener(btn_plus);
        add(btn_plus); // 토글 버튼을 프레임에 추가

        // 버튼 생성 및 리스너 추가
        btn_minus = new CustomButton("-");
        btn_minus.setBounds(1150, 180, 60, 40); // 두 번째 버튼 위치 및 크기 설정
        addBtnMinusActionListener(btn_minus);
        add(btn_minus); // 두 번째 버튼을 프레임에 추가

        // 온도를 표시하는 JLabel 생성
        lbl_temperature = new JLabel("" + temperature+"°C");
        lbl_temperature.setFont(new Font("Arial", Font.BOLD, 30));

        lbl_temperature.setBounds(1120, 150, 200, 30);
        add(lbl_temperature);

        // 배경 이미지 JLabel 생성 및 설정
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, -100, getWidth(), getHeight());
      
        // Create Sunfish instance
        sunfish = new Sunfish();
        shrimp = new Shrimp();
        shellfish = new ShellFish();
        starfish = new StarFish();
        octopus = new Octopus();
        crab = new Crab();
      
        // Add Sunfish instance to background label
        add(backgroundLabel);
        backgroundLabel.add(sunfish);
        backgroundLabel.add(shrimp);
        backgroundLabel.add(shellfish);
        backgroundLabel.add(starfish);
        backgroundLabel.add(octopus);
        backgroundLabel.add(crab);

        // 태양물고기 이미지 JLabel 생성 및 설정
        JLabel sunfishLabel = new JLabel(sunfishImage);
        int x = (getWidth() - sunfishImage.getIconWidth()) / 2;
        int y = (getHeight() - sunfishImage.getIconHeight()) / 2;
        sunfishLabel.setBounds(x, y, sunfishImage.getIconWidth(), sunfishImage.getIconHeight());
        backgroundLabel.add(sunfishLabel);
    }

    private void addBtnPlusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature += 0.1;
            updateTemperatureLabel();
        };

        btn.addActionListener(actionListener);
    }

    private void addBtnMinusActionListener(CustomButton btn) {
        ActionListener actionListener = (e) -> {
            temperature -= 0.1;
            updateTemperatureLabel();
        };

        btn.addActionListener(actionListener);
    }

    // 온도 라벨 업데이트 메서드
    private void updateTemperatureLabel() {
        lbl_temperature.setText("" + String.format("%.1f", temperature)+"°C");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomeScreen homeScreen = new HomeScreen();
            homeScreen.setVisible(true);
        });
    }
}
