package game.screens;

import game.GameCanvas;
import game.GameData;
import game.controller.KeyPaddleController;
import game.items.Ball;
import game.items.Paddle;
import game.startup.Startup;
import game.states.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Properties;

public class SinglePlayerGameScreen extends Screen{

    GameData data;
    Properties properties;

    public SinglePlayerGameScreen(GameCanvas canvas) {
        super(canvas);
    }

    @Override
    public void create() {
        data = new GameData();

        // get properties
        properties = new Properties();
        try {
            properties.load(Startup.class.getClassLoader().getResourceAsStream("LevelProperties"));
        } catch (IOException e) {
            System.err.println("Could not load properties file");
            e.printStackTrace();
            System.exit(-1);
        }

        // set size
        int width = Integer.parseInt(properties.getProperty("width", "800"));
        int height = Integer.parseInt(properties.getProperty("height", "600"));

        canvas.manager.frame.setSize(width, height + 20);
        canvas.setSize(width, height + 20);

        // add size to data
        data.height = height;
        data.width = width;


        createLeftPaddle();
        createRightPaddle();
        createBall();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void tick() {

        Paddle leftPaddle = data.leftPaddle;
        Paddle rightPaddle = data.rightPaddle;
        Ball ball = data.ball;

        if(data.gameState == GameState.PAUSED){
            repaint();
            return;
            // do nothing
        }

        if(data.gameState == GameState.PLAYING) {
            leftPaddle.tick();
            rightPaddle.tick();
            ball.tick();
        }

        if(data.gameState != GameState.PLAYING){
            if(data.gameState==GameState.LEFT_POINT){
                data.score1++;
            }
            if(data.gameState==GameState.RIGHT_POINT){
                data.score2++;
            }
            createBall();
            data.gameState = GameState.PLAYING;
        }
        repaint();
    }


    private void createLeftPaddle(){
        // create paddles
        KeyPaddleController leftController = new KeyPaddleController(KeyEvent.VK_W, KeyEvent.VK_S);
        canvas.addKeyListener(leftController);
        Paddle leftPaddle = new Paddle(
                Integer.parseInt(properties.getProperty("x1")),
                Integer.parseInt(properties.getProperty("y1")),  Integer.parseInt(properties.getProperty("w1")),
                Integer.parseInt(properties.getProperty("h1")), Integer.parseInt(properties.getProperty("s1")),
                leftController);

        data.leftPaddle = leftPaddle;

        leftPaddle.setData(data);
    }

    private void createRightPaddle(){
        KeyPaddleController rightController = new KeyPaddleController(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        canvas.addKeyListener(rightController);
        Paddle rightPaddle = new Paddle(
                Integer.parseInt(properties.getProperty("x2")),
                Integer.parseInt(properties.getProperty("y2")),  Integer.parseInt(properties.getProperty("w2")),
                Integer.parseInt(properties.getProperty("h2")), Integer.parseInt(properties.getProperty("s2")),
                rightController);

        data.rightPaddle = rightPaddle;
        rightPaddle.setData(data);

    }

    private void createBall(){
        int speed = Integer.parseInt(properties.getProperty("balls"));
        // set dir to a random direction in radians
        double dir = Math.random() * Math.PI * 2;
        int vx = (int) (speed * Math.cos(dir));
        int vy = (int) (speed * Math.sin(dir));
        Ball ball = new Ball(
                Integer.parseInt(properties.getProperty("ballx")),
                Integer.parseInt(properties.getProperty("bally")),
                vx, vy,
                Integer.parseInt(properties.getProperty("ballw")),
                Integer.parseInt(properties.getProperty("ballh")));

        data.ball = ball;
        ball.setData(data);

        data.gameState = GameState.PLAYING;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        data.leftPaddle.draw(graphics);
        data.rightPaddle.draw(graphics);
        data.ball.draw(graphics);
    }
}
