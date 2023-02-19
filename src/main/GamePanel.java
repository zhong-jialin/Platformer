package main;

import inputs.Keyboardinputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventListener;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

import static utilz.Constants.PlayerConstants.IDLE;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100,yDelta = 100;
    //引入图片
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick,aniIndex,aniSpeed = 18;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    //随机颜色
    public GamePanel(){
        mouseInputs = new MouseInputs(this);
        //引入图片
        importImg();
        loadAnimations();
        setPanelSize();
        addKeyListener(new Keyboardinputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    //循环角色动作
    //角色图片设为数组

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i*64,j*40,64,40);
            }
        }
    }

    private void importImg() {
        //在项目原文件标记为源文件根目录在可以用这个路径
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    public void setDirection(int direction){
        this.playerDir = direction;
        moving = true;
    }
    public void SetMoving(boolean moving){
        this.moving = moving;
    }

    public void updateAnimationTick(){
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >=GetSpriteAmount(playerAction)){
                aniIndex = 0;
            }
        }
    }
    private void setAnimation() {
        if (moving){
            playerAction = RUNNING;
        }else
            playerAction = IDLE;
    }
    private void updatePos() {
        if (moving){
            switch (playerDir){
                case LEFT -> xDelta -=3;
                case UP -> yDelta -=3;
                case DOWN -> xDelta +=3;
                case RIGHT-> yDelta +=3;
            }
        }
    }
    public void updateGame(){
        updateAnimationTick();
        setAnimation();
        updatePos();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        setAnimation();
        updatePos();
        //getsubimage 在图像中截取部分
        g.drawImage(animations[playerAction][aniIndex],(int) xDelta,(int)yDelta,210,140,null);


    }


}
