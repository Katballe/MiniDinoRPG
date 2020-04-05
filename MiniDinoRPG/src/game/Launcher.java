package game;


public class Launcher {
    public static void main(String[] args) throws Exception {
        
        Game game = new Game("GAME", 900, 900);
        game.start();   // calls sync start method
    }
}