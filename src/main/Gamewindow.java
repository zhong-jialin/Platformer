package main;

import javax.swing.*;

public class Gamewindow {
    private JFrame jframe;
    public Gamewindow(GamePanel gamePanel){
        jframe = new JFrame();

        //在这里创建的jframe大小包括白边状态栏
        //要用GamePanel创建类
        //close window
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
