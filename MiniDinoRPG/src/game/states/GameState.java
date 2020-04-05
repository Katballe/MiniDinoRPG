package game.states;

import java.awt.Graphics;

import game.Handler;
import game.world.World;

public class GameState extends State {

    private World world;    

    public GameState(Handler handler){
        super(handler);
        world = new World(handler, "src\\game\\rcs\\worlds\\world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }

    
}