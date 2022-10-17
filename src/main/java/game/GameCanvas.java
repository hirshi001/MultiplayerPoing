package game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameCanvas extends Canvas{

    private static final int START_PADDLE_DISTANCE_WALL = 50;
    private static final int PADDLE_WIDTH = 10;


    public Paddle leftPaddle, rightPaddle;
    private final int width, height;

    public GameCanvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Called when the canvas is first created, before the paint method is called.
     */
    public void start() {
        KeyPaddleController leftController = new KeyPaddleController(KeyEvent.VK_W, KeyEvent.VK_S);
        addKeyListener(leftController);
        leftPaddle = new Paddle(START_PADDLE_DISTANCE_WALL, Paddle.startY, PADDLE_WIDTH, Paddle.HEIGHT, leftController);

        KeyPaddleController rightController = new KeyPaddleController(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        addKeyListener(rightController);
        rightPaddle = new Paddle(START_PADDLE_DISTANCE_WALL, Paddle.startY, PADDLE_WIDTH, Paddle.HEIGHT, rightController);

    }

    /**
     * Called at a constant rate, this is the main game loop.
     */
    public void render(){
        Graphics2D g = (Graphics2D) getGraphics();

    }

}
