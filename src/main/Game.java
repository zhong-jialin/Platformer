package main;

public class Game {
    private Gamewindow gamewindow;
    private GamePanel gamePanel;
    public Game(){
        gamePanel = new GamePanel();
        gamewindow = new Gamewindow(gamePanel);
    }
}
