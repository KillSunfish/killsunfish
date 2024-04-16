package client.components;

import client.frame.MainView;
import server.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JComponent {
    private JTextField tf_id = new JTextField();
    private JLabel la_id = new JLabel("아이디");
    private JTextField tf_pwd = new JTextField();
    private JLabel la_pwd = new JLabel("비밀번호");
    private JButton btn_whiteRounded;

    public SignIn (MainView mainView) {
        // Label ID
        la_id.setBounds(450,260,100,40);
        la_id.setFont(new Font("",Font.BOLD,30));
        add(la_id);
        // textField ID
        tf_id.setBounds(450,300,400,60);
        add(tf_id);

        // Label PWD
        la_pwd.setBounds(450,400,150,40);
        la_pwd.setFont(new Font("",Font.BOLD,30));
        add(la_pwd);
        // textField PWD
        tf_pwd.setBounds(450,440,400,60);
        add(tf_pwd);

        btn_whiteRounded = new JButton("로그인");
        btn_whiteRounded.setBounds(570, 550, 170,65);
        btn_whiteRounded.setFont(new Font("",Font.BOLD,30));
        add(btn_whiteRounded);

        btn_whiteRounded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainView.userController.login(tf_id.getText(), tf_pwd.getText())!=null) {
                    mainView.switchView("signInFinished");
                }
            }
        });
    }
}
