package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.Directions.*;
import static utilz.Constants.Directions.RIGHT;
import static utilz.Constants.PlayerConstants.*;

public class Player extends Entities{
    private int aniTick,aniIndex,aniSpeed = 18;
    private int playerAction = IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    private BufferedImage[][] animations;
    public Player(float x, float y) {

        super(x, y);
        loadAnimations();
    }
    public void update(){
        updateAnimationTick();
        setAnimation();
        updatePos();
    }
    public void render(Graphics g){
        g.drawImage(animations[playerAction][aniIndex],(int) x,(int)y,210,140,null);
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
                case LEFT -> x -=3;
                case UP -> y -=3;
                case DOWN -> x +=3;
                case RIGHT-> y +=3;
            }
        }
    }



    private void loadAnimations() {
        //在项目原文件标记为源文件根目录在可以用这个路径
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");
        try {
            BufferedImage img = ImageIO.read(is);
            animations = new BufferedImage[9][6];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i*64,j*40,64,40);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
