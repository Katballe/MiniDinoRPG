package game.entities.statics;

import java.awt.Graphics;

import game.Handler;
import game.dispaly.Assets;
import game.items.Item;

public class GoldRock extends StaticEntity {

    // Size of the FULL picture cropped in assets
    private final static int rockWidth = 100, rockHeight = 120;

    public GoldRock(Handler handler, float x, float y) {
        super(handler, x, y, rockWidth, rockHeight);
        
        // Hitbox
        bounds.x = 0;
        bounds.y = 20;
        bounds.width = rockWidth;
        bounds.height = rockHeight;        
    }

    @Override
    public void die() {
        handler.getWorld().getItemManager().additem(Item.goldItem.createNew((int) x, (int) y));
    }

    @Override
    public void update() {        
    }

    @Override
    public void render(Graphics g) {   
        g.drawImage(Assets.goldRock, (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }


    // getters and setters 

    public int getRockHeight(){
        return rockHeight;
    }
    public int getRockwidth() {
        return rockWidth;
    }
}