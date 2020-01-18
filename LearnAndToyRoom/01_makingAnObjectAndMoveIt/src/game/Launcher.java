package game;

import game.dispaly.Display;

public class Launcher {
    public static void main(String[] args) throws Exception {
        
        // Display display = new Display("GAME", 500, 400); 
        Game game = new Game("GAME", 1000, 400);
        game.start();
    }
}