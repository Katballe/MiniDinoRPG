package game.states;

import java.awt.Graphics;

import game.Game;
import game.entities.creatures.Player;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 100);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.playerRun2, 0, 0, null);
        player.render(g);
    }

    
}