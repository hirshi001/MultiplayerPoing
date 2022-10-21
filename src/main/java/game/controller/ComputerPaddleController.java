package game.controller;

import game.gameelements.Tickable;
import game.items.Paddle;

public class ComputerPaddleController implements PaddleController, Tickable {

    public Paddle paddle;
    boolean up, down;

    public ComputerPaddleController(){

    }

    @Override
    public boolean isUpPressed() {
        return up;
    }

    @Override
    public boolean isDownPressed() {
        return down;
    }

    @Override
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    public void tick() {

    }
}
