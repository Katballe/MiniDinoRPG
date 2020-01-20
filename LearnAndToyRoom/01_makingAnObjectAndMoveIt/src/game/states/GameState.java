package game.states;

import java.awt.Graphics;

import game.Game;
import game.entities.creatures.Player;
import game.tile.Tile;
import game.world.World;

public class GameState extends State {

    private World world;    // test
    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game, 100, 200);
        world = new World("");
    }

    @Override
    public void update() {
        world.update();
        player.update();
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.playerRun2, 0, 0, null);
        world.render(g);
        player.render(g);
        /*
        Tile.tiles[0].render(g, 100, 200);
        Tile.tiles[1].render(g, 200, 200);
        Tile.tiles[2].render(g, 300, 200);
        */

    }

    
}