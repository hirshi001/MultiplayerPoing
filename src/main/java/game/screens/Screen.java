package game.screens;

import game.GameCanvas;

import javax.swing.*;
import java.awt.*;

public abstract class Screen extends JPanel {

    public GameCanvas canvas;

    public Screen(GameCanvas canvas){
        this.canvas = canvas;
    }

    public abstract void create();
    public abstract void destroy();
    public abstract void tick();
    public abstract void draw(Graphics2D graphics);



}
