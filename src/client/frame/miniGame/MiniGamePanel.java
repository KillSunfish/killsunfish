package client.frame.miniGame;

import client.components.Navbar;
import client.components.Sunfish;
import client.components.Shark;
import client.frame.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class MiniGamePanel extends JPanel implements ActionListener {
    private static final String INGAME_BACKGROUND_PATH = "src/client/assets/ingame_background.png";
    private JButton startButton;
    private ImageIcon backgroundImage;
    private Sunfish sunfish;
    private ArrayList<Shark> sharks;
    private int sunfishSpeed = 10;
    private Timer countTimer;
    private Timer gameTimer;
    private JLabel timerLabel;
    private Timer sharkTimer;
    private final MiniGameDeadPanel gameDeadPanel;

    private int gameTimeRemaining;

    public MiniGamePanel(HomeScreen homeScreen, Navbar navbar) {
        backgroundImage = new ImageIcon(INGAME_BACKGROUND_PATH);
        setLayout(null);

        timerLabel = new JLabel();
        timerLabel.setFont(new Font("NanumGothic", Font.BOLD, 35));
        timerLabel.setForeground(Color.BLACK);
        timerLabel.setBounds(40, 40, 300, 30);
        add(timerLabel);

        startButton = new CustomButton("게임 시작 !");
        add(startButton);

        sunfish = new Sunfish(navbar);
        add(sunfish);

        sharks = new ArrayList<>();

        setFocusable(true);
        startButton.addActionListener(this);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                startButton.setBounds((getWidth() - 300) / 2, getHeight() - 250, 300, 80);
            }
        });

        gameTimer = new Timer(1000 / 60, this);
        sharkTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRandomShark();
            }
        });
        countTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameTimeRemaining > 1) {
                    gameTimeRemaining--;
                    updateTimerLabel();
                } else {
                    // 메뉴로 돌아가기
                    // 몸무게 증량
                }
            }
        });

        gameDeadPanel = new MiniGameDeadPanel(homeScreen);
        gameDeadPanel.setVisible(false);
        add(gameDeadPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
        for (Shark shark : sharks) {
            shark.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            gameTimeRemaining = 30;
            updateTimerLabel();
            countTimer.start();
            startButton.setVisible(false);
            timerLabel.setVisible(true);
            requestFocusInWindow();

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    int keyCode = e.getKeyCode();
                    switch (keyCode) {
                        case KeyEvent.VK_UP:
                            sunfish.moveUp(sunfishSpeed);
                            break;
                        case KeyEvent.VK_DOWN:
                            sunfish.moveDown(sunfishSpeed);
                            break;
                        case KeyEvent.VK_LEFT:
                            sunfish.moveLeft(sunfishSpeed);
                            if (sunfish.isFlipped()) {
                                sunfish.flipImage();
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            sunfish.moveRight(sunfishSpeed);
                            if (!sunfish.isFlipped()) {
                                sunfish.flipImage();
                            }
                            break;
                    }
                }
            });
            gameTimer.start();
            sharkTimer.start();
        } else if (e.getSource() == gameTimer) {
            for (int i = 0; i < sharks.size(); i++) {
                Shark shark = sharks.get(i);
                shark.move(shark.getSpeed());
                if (shark.getX() < -shark.getWidth() || shark.getX() > getWidth() ||
                        shark.getY() < -shark.getHeight() || shark.getY() > getHeight()-80) {
                    sharks.remove(i);
                    i--;
                }
                Rectangle sharkBounds = shark.getBounds();
                Rectangle sunfishBounds = sunfish.getBounds();

                int padding = 30; // 패딩 값 설정
                sunfishBounds.setBounds(sunfishBounds.x + padding, sunfishBounds.y - padding,
                        sunfishBounds.width - padding * 2, sunfishBounds.height - padding * 2);

                if (sunfishBounds.intersects(sharkBounds)) {
                    gameOver();
                    return;
                }
            }
            repaint();
        }
    }

    private void addRandomShark() {
        Random random = new Random();
        int side = random.nextInt(2); // 0 또는 1로 랜덤하게 결정
        int x, y, directionX, speed;
        if (side == 0) {
            x = -Shark.SHARK_WIDTH;
            directionX = 1;
        } else {
            x = getWidth();
            directionX = -1;
        }
        y = random.nextInt(getHeight() - Shark.SHARK_HEIGHT);
        speed = random.nextInt(8) + 8;
        Shark newShark = new Shark(x, y, directionX, speed);
        sharks.add(newShark);
        sharkTimer.setDelay(random.nextInt(3000));
    }

    private void updateTimerLabel() {
        timerLabel.setText("Timer : " + gameTimeRemaining);
    }

    private void gameOver() {
        gameTimer.stop();
        sharkTimer.stop();
        timerLabel.setVisible(false);
        add(gameDeadPanel);
        gameDeadPanel.setBounds(0, 0, getWidth(), getHeight());
        gameDeadPanel.setVisible(true);
        sunfish.setVisible(false);
    }
}