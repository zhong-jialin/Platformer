package main;

import javax.swing.*;

public class Gamewindow {
    private JFrame jframe;
    public Gamewindow(GamePanel gamePanel){
        jframe = new JFrame();
        jframe.setSize(400,400);

        //close window
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setVisible(true);
    }
}
