package game.gameelements;

import game.GameData;

import java.awt.*;

public abstract  class GameElement implements Tickable, Drawable {

    public GameData data;

    public GameElement() {
    }

    @Override
    public abstract void tick();

    @Override
    public abstract void draw(Graphics2D graphics);

    public void setData(GameData data) {
        this.data = data;
    }

}
