package client.components;

import client.frame.MainView;
import server.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JComponent {
    private JTextField tf_id = new JTextField();
    private JLabel la_id = new JLabel("아이디");
    private JTextField tf_pwd = new JTextField();
    private JLabel la_pwd = new JLabel("비밀번호");
    private JTextField tf_nickname = new JTextField();
    private JLabel la_nickname = new JLabel("개복치 이름을 입력해주세요.");
    private JButton btn_whiteRounded;

    public SignUp (MainView mainView) {
        // Label ID
        la_id.setBounds(450,200,100,40);
        la_id.setFont(new Font("",Font.BOLD,30));
        add(la_id);
        // textField ID
        tf_id.setBounds(450,240,400,60);
        add(tf_id);

        // Label PWD
        la_pwd.setBounds(450,340,150,40);
        la_pwd.setFont(new Font("",Font.BOLD,30));
        add(la_pwd);
        // textField PWD
        tf_pwd.setBounds(450,380,400,60);
        add(tf_pwd);

        // Label nickname
        la_nickname.setBounds(450,480,500,40);
        la_nickname.setFont(new Font("",Font.BOLD,30));
        add(la_nickname);
        // textField PWD
        tf_nickname.setBounds(450,520,400,60);
        add(tf_nickname);

        btn_whiteRounded = new JButton("회원가입");
        btn_whiteRounded.setBounds(570, 650, 170,65);
        btn_whiteRounded.setFont(new Font("",Font.BOLD,30));
        add(btn_whiteRounded);

        btn_whiteRounded.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainView.userController.signUp(tf_id.getText(), tf_pwd.getText(), tf_nickname.getText())) {
                    mainView.switchView("signUpFinished");
                }

            }
        });
    }

}
