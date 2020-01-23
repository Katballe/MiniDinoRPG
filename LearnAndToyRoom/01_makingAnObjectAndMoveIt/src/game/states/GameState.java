package game.states;

import java.awt.Graphics;

import game.Handler;
import game.entities.creatures.Player;
import game.entities.statics.Tree;
import game.world.World;

public class GameState extends State {

    private World world;    
    //private Player player;
    //private Tree tree;

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\worlds\\world1.txt");
        handler.setWorld(world);
        //player = new Player(handler, 100, 100);
        //tree = new Tree(handler, 800, 800);
        

    //    game.getGameCamera().move(0, 0);
    }

    @Override
    public void update() {
        world.update();
        //player.update();
        //tree.update();

     //   game.getGameCamera().move(1, 1);
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.playerRun2, 0, 0, null);
        world.render(g);
        //player.render(g);
        //tree.render(g);
        /*
        Tile.tiles[0].render(g, 100, 200);
        Tile.tiles[1].render(g, 200, 200);
        Tile.tiles[2].render(g, 300, 200);
        */

    }

    
}