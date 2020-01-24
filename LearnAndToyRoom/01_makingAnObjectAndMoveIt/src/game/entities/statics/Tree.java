package game.entities.statics;

import java.awt.Graphics;
import game.Handler;
import game.dispaly.Assets;

public class Tree extends StaticEntity {

    private final static int treeWidth = 120, treeHeight = 170;
    public Tree (Handler handler, float x, float y){
        super(handler, x, y, treeWidth, treeHeight);

        bounds.x = 40;
        bounds.y = (int) (treeHeight/1.5f);
        bounds.width = 40;
        bounds.height = (int) (height - treeHeight/1.5f);
    }

    public int getTreeWidth(){
        return treeWidth;
    }
    public int getTreeHeight(){
        return treeHeight;
    }

	@Override
	public void update() {
		
		
    }
    
    @Override
    public void die() {
        
        
    }

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.treeOne, (int) (x - handler.getGameCamera().getXOffset()), (int) (y - handler.getGameCamera().getYOffset()), width, height, null);
		
	}
}