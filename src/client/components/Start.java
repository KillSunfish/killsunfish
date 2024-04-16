package client.components;

import client.frame.MainView;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JComponent {
    private JButton btn_signIn;
    private JButton btn_signUp;

    private Images img_sunfish;
    private Images img_titleText;
    private MainView mainView;


    public Start (MainView mainView) {
        this.mainView = mainView;
        this.btn_signIn = new JButton("로그인");
        this.btn_signUp = new JButton("회원가입");
        this.img_sunfish = new Images("src/client/assets/sunfish_Lv1.png");
        this.img_titleText = new Images("src/client/assets/titleText.png");

        // signIn btn
        btn_signIn.setBounds(450, 500, 170, 65);
        btn_signIn.setBackground(Color.white);
        btn_signIn.setFont(new Font("",Font.BOLD,30));
        this.add(btn_signIn);
        btn_signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.switchView("signIn", null);
            }
        });

        // signUp btn
        btn_signUp.setBounds(750, 500, 170, 65);
        btn_signUp.setBackground(Color.white);
        btn_signUp.setFont(new Font("",Font.BOLD,30));
        this.add(btn_signUp);
        btn_signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.switchView("signUp", null);
            }
        });

        // sunfish img
        img_sunfish.setBounds(250, 255, 300, 280);
        this.add(img_sunfish);

        // titleText img
        img_titleText.setBounds(450, 300, 700, 100);
        this.add(img_titleText);

    }


}
