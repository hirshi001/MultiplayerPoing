package game.controller;

import game.items.Paddle;

public interface PaddleController {
    
    boolean isUpPressed();
    boolean isDownPressed();

    void setPaddle(Paddle paddle);
    
}
