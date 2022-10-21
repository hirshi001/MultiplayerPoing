package game.startup;

import javax.swing.*;

public class Startup {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameManager();
            }
        });
    }

}
