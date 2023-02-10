package inputs;

import main.GamePanel;
import main.Gamewindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;
import static utilz.Constants.Directions.*;

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.setDirection(UP);
            case KeyEvent.VK_A -> gamePanel.setDirection(LEFT);
            case KeyEvent.VK_S -> gamePanel.setDirection(RIGHT);
            case KeyEvent.VK_D -> gamePanel.setDirection(DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W : ;
            case KeyEvent.VK_A : ;
            case KeyEvent.VK_S : ;
            case KeyEvent.VK_D :
                gamePanel.SetMoving(false);
                break;
        }
    }
}
