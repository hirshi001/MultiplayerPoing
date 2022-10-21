package game.startup;

import game.GameCanvas;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager{

    public static final int FRAME_RATE = 60;
    public static final int DEFAULT_WIDTH = 800, DEFAULT_HEIGHT = 600;
    public JFrame frame;


    public GameManager() {
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);

        GameCanvas canvas = new GameCanvas(this);
        canvas.setFocusable(true);
        frame.add(canvas);
        frame.revalidate();

        canvas.start();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                canvas.tick();
            }
        }, 0, 1000 / FRAME_RATE);
    }


}
