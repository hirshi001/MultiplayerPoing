package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPaddleController implements PaddleController, KeyListener {
    
    boolean upPressed, downPressed;
    int upKey, downKey;
    
    public KeyPaddleController(int upKey, int downKey) {
        upPressed = false;
        downPressed = false;
        this.upKey = upKey;
        this.downKey = downKey;
    }
    
    @Override
    public boolean isUpPressed() {
        return false;
    }

    @Override
    public boolean isDownPressed() {
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==upKey){
            upPressed = true;
        }
        if(e.getKeyCode()==downKey){
            downPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==upKey){
            upPressed = false;
        }
        if(e.getKeyCode()==downKey){
            downPressed = false;
        }
    }
}
