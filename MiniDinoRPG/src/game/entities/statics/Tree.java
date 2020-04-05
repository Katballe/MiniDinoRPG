package game.entities.statics;

import java.awt.Graphics;
import game.Handler;
import game.dispaly.Assets;
import game.items.Item;

public class Tree extends StaticEntity {

    // size of the FULL picture cropped from assets
    private final static int treeWidth = 120, treeHeight = 170;


    public Tree (Handler handler, float x, float y){
        super(handler, x, y, treeWidth, treeHeight);

        // hitbox 
        bounds.x = 40;
        bounds.y = (int) (treeHeight/1.5f);
        bounds.width = 40;
        bounds.height = (int) (height - treeHeight/1.5f);
    }

	@Override
	public void update() {
    }
    
    @Override
    public void die() {
        handler.getWorld().getItemManager().additem(Item.woodItem.createNew((int) x, (int) y));
    }

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeOne, (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
    }
    
    
    // getters and setters 

    public int getTreeWidth(){
        return treeWidth;
    }
    public int getTreeHeight(){
        return treeHeight;
    }
}