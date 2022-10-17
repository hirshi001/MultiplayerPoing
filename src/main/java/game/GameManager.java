package game;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager{

    public static final int FRAME_RATE = 60;
    public static final int WIDTH = 800, HEIGHT = 600;
    JFrame frame;


    public GameManager() {
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);

        GameCanvas canvas = new GameCanvas(WIDTH, HEIGHT);
        canvas.setSize(WIDTH, HEIGHT);
        frame.add(canvas);

        canvas.start();

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                canvas.repaint();
            }
        }, 0, 1000 / FRAME_RATE);
    }


}
