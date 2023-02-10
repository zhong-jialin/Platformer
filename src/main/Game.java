package main;

public class Game implements Runnable{
    private Gamewindow gamewindow;
    private GamePanel gamePanel;
    //单独运行线程
    private Thread gameThread;
    private final int PFS_SET = 120;
    public Game(){
        gamePanel = new GamePanel();
        gamewindow = new Gamewindow(gamePanel);
        //必须添加 不然不能触发方法
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }
    //刷新画面
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    //固定120帧

    @Override
    public void run() {
        double tomePerFrame = 1000000000.0/PFS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        while (true){
            now = System.nanoTime();
            if(now - lastFrame >= tomePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck =  System.currentTimeMillis();
                System.out.println("fps0" + frames);
                frames=0;
            }
        }
    }
}
