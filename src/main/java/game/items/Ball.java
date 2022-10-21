package game.items;

import game.Utility;
import game.gameelements.GameElement;
import game.states.GameState;

import java.awt.*;

public class Ball extends GameElement {

    // x, y is center of ball, ball is a rectangle
    public float x, y, vx, vy, width, height;

    public Ball(float x, float y, float vx, float vy, float width, float height) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.width = width;
        this.height = height;

    }

    @Override
    public void tick() {
        x += vx;
        y += vy;


        // check ball wall collisions
        // top of screen
        if(y-height/2 <= 0){
            y = height/2;
            vy=-vy;
        }

        // bottom of screen
        if(y+height/2 >= data.height){
            y = data.height-height/2;
            vy=-vy;
        }

        // left wall
        if(x-width/2 <= 0){
            vx = 0; vy = 0;
            data.gameState = GameState.LEFT_WIN;
            return;
        }

        if(x+width/2 >= data.width){
            vx = 0; vy = 0;
            data.gameState = GameState.RIGHT_WIN;
            return;
        }




        // check collision with paddles
        Paddle paddle = data.leftPaddle;
        if(Utility.rectRectCollision(x-width/2, y-height/2, width, height, paddle.x,
                paddle.y, paddle.width, paddle.height)){
            x = paddle.x + paddle.width + width/2;
            vx = Math.abs(vx);
        }

        paddle = data.rightPaddle;
        if(Utility.rectRectCollision(x-width/2, y-height/2, width, height, paddle.x,
                paddle.y, paddle.width, paddle.height)){
            x = paddle.x - width/2;
            vx = -Math.abs(vx);
        }



    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect((int)(x-width/2), (int)(y-height/2), (int)width, (int)height);
    }
}
