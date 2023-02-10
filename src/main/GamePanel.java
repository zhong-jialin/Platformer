package main;

import inputs.Keyboardinputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100,yDelta = 100;
    private float xDir = 1f,yDir = 1f;
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(150,90,60);
    //随机颜色
    private Random random;
    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int value){
        this.xDelta += value;
        repaint();
    }
    public void changeYDelta(int value){
        this.yDelta += value;
        repaint();
    }

    public void setRectPos(int x,int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta,(int) yDelta,200,50);


    }
    //防止绘画图形超过窗口大小
    public void updateRectangle(){
        xDelta+= xDir;
        if(xDelta > 400 || xDelta <0){
            xDir*=-1;
            color =getRndColor();
        }
        yDelta+=yDir;
        if(yDelta > 400 || yDelta <0){
            yDir*=-1;
            color = getRndColor();
        }
    }
    private Color getRndColor(){
        int r=random.nextInt(255),b=random.nextInt(255),
                g=random.nextInt(255);
        return new Color(r,b,g);
    }
}
