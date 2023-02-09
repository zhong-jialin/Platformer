package main;

public class Game {
    private Gamewindow gamewindow;
    private GamePanel gamePanel;
    public Game(){
        gamePanel = new GamePanel();
        gamewindow = new Gamewindow(gamePanel);
        //必须添加 不然不能触发方法
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
    }
}
