package main;

import entities.Player;

import java.awt.*;

public class Game implements Runnable{
    private Gamewindow gamewindow;
    private GamePanel gamePanel;
    //单独运行线程
    private Thread gameThread;
    private final int PFS_SET = 120;
    private final int UPS_SET = 120;
    private Player player;
    public Game(){
        initClasses();
        gamePanel = new GamePanel(this);
        gamewindow = new Gamewindow(gamePanel);
        //必须添加 不然不能触发方法
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        startGameLoop();

    }

    private void initClasses() {
        player = new Player(200,200);
    }

    //刷新画面
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //固定120帧
    private void update() {
       player.update();
    }
    public  void render(Graphics g){
        player.render(g);
    }
    @Override
    public void run() {
        double tomePerFrame = 1000000000.0/PFS_SET;
        double tomePerUpdate = 1000000000.0/UPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        long previousTime = System.nanoTime();
        int frames = 0;
        int update = 0;
        long lastCheck = System.currentTimeMillis();

        double delatU = 0;
        double delatF = 0;

        while (true){
            now = System.nanoTime();
            long currentTime = System.nanoTime();

            delatU +=(currentTime - previousTime) / tomePerUpdate;
            delatF +=(currentTime - previousTime) / tomePerFrame;
            previousTime = currentTime;

            if (delatU >=1){
                update();
                update++;
                delatU--;
            }
            if (delatF>=1){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
                delatF--;
            }
//            if(now - lastFrame >= tomePerFrame){
//                gamePanel.repaint();
//                lastFrame = now;
//                frames++;
//            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck =  System.currentTimeMillis();
                System.out.println("fps0" + frames + "| ups" + update);
                frames=0;
                update = 0;
            }
        }
    }
    public Player getPLayer(){
        return player;
    }

}
