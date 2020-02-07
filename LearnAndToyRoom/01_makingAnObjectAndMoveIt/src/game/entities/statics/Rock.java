package game.entities.statics;

import java.awt.Graphics;
import java.awt.Color;

import game.Handler;
import game.dispaly.Assets;
import game.items.Item;

public class Rock extends StaticEntity {

    private final static int rockWidth = 100, rockHeight = 120;

    public Rock(Handler handler, float x, float y) {
        super(handler, x, y, rockWidth, rockHeight);
        
        
        bounds.x = 0;
        bounds.y = 20;
        bounds.width = rockWidth;
        bounds.height = rockHeight;

        
    }

    public int getRockHeight(){
        return rockHeight;
    }
    public int getRockwidth() {
        return rockWidth;
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().additem(Item.stoneItem.createNew((int) x, (int) y));

    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        
        g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
        
        /*
        g.setColor(Color.RED);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXOffset()), (int) (y + bounds.y - handler.getGameCamera().getYOffset()), 
        bounds.width, bounds.height);
        */
    }

    
}