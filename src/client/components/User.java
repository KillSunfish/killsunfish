package client.components;

import javax.swing.*;
import java.awt.*;

public class User extends JComponent {
    private JTextField tf_id = new JTextField();
    private JLabel la_id = new JLabel("아이디");
    private JTextField tf_pwd = new JTextField();
    private JLabel la_pwd = new JLabel("비밀번호");
    private JButton btn_signIn;


    public User (String type) {
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

        if (type.equals("signIn")) {
            btn_signIn = new JButton("로그인");
        } else {
            btn_signIn = new JButton("회원가입");
        }
        btn_signIn.setBounds(570, 600, 170,65);
        btn_signIn.setFont(new Font("",Font.BOLD,30));
        add(btn_signIn);

    }
}
