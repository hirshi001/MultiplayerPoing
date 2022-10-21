package game.items;

import game.controller.PaddleController;
import game.gameelements.GameElement;

import java.awt.*;

public class Paddle extends GameElement {


    public float x, y, width, height, speed;

    private PaddleController controller;

    public Paddle(float x, float y, float width, float height, float speed, PaddleController controller) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.controller = controller;
        controller.setPaddle(this);
    }



    public PaddleController getController() {
        return controller;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int)x, (int)y, (int)width, (int)height);
    }


    public void tick() {
        move();
    }

    public void move() {
        if (controller.isUpPressed()) {
            y -= speed;
        }
        if (controller.isDownPressed()) {
            y += speed;
        }
    }


}
