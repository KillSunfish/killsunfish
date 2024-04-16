package client.components;

import client.controller.FrontController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeathPageComponent extends JComponent {
    private JPanel pnl_backgroundPanel;

    private JButton btn_returnHome;

    private DeathImageComponent deathImageComponent;

    private FrontController frontController;

    public DeathPageComponent(int deathCode) {
        this.frontController = FrontController.getInstance();

        pnl_backgroundPanel = new JPanel();
        pnl_backgroundPanel.setBackground(new Color(57, 57, 57, 128));
        pnl_backgroundPanel.setSize(1280, 960);
        this.add(pnl_backgroundPanel);

        deathImageComponent = new DeathImageComponent(deathCode);
        this.add(deathImageComponent);

        btn_returnHome = new JButton("홈으로");
        btn_returnHome.setFont(new Font(null, Font.BOLD, 35));
        btn_returnHome.setBounds(540, 750, 200, 80);
        btn_returnHome.setBackground(Color.WHITE);
        btn_returnHome.setBorder(new LineBorder(Color.BLACK));
        addBtnActionListener(btn_returnHome);
        this.add(btn_returnHome);

        setComponentZOrder(pnl_backgroundPanel, 1);
        setComponentZOrder(btn_returnHome, 0);
        setComponentZOrder(deathImageComponent, 0);
    }

    private void addBtnActionListener(AbstractButton btn) {
        ActionListener actionListener = (e) -> {
            frontController.returnToMainPage();
//            this.setVisible(false);
//            repaint();
        };
        btn.addActionListener(actionListener);
    }
}

