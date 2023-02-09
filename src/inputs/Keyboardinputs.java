package inputs;

import main.GamePanel;
import main.Gamewindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

public class Keyboardinputs  implements KeyListener {
    private GamePanel gamePanel;
    public Keyboardinputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.changeYDelta(-5);
            case KeyEvent.VK_A -> gamePanel.changeXDelta(-5);
            case KeyEvent.VK_S -> gamePanel.changeYDelta(5);
            case KeyEvent.VK_D -> gamePanel.changeXDelta(5);
        }
    }
}
