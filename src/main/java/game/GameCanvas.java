package game;

import game.screens.Screen;
import game.screens.SinglePlayerGameScreen;
import game.startup.GameManager;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    public GameManager manager;
    public Screen screen;


    public GameCanvas(GameManager manager) {
        this.manager = manager;

    }

    public void setScreen(Screen screen){
        removeAll();
    }

    /**
     * Called when the canvas is first created, before the paint method is called.
     */
    public void start() {
        screen = new SinglePlayerGameScreen(this);
        screen.show();
    }


    /**
     * Called at a constant rate, this is the main game loop.
     */
    public void tick(){
        // tick
        screen.tick();


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        screen.draw((Graphics2D) g);
    }
}
