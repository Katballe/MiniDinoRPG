package game.dispaly;

import game.Handler;
import game.entities.Entity;
import game.tile.Tile;

public class GameCamera {

    private Handler handler;
    private float xOffset, yOffset;

    public GameCamera (Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlankSpace(){
        if (xOffset < 0){
            xOffset = 0;
        }else if(xOffset > handler.getWorld().getWidth() * Tile.tileWidth-handler.getWidth()){
            xOffset = handler.getWorld().getWidth() * Tile.tileWidth-handler.getWidth();
        }
        if (yOffset < 0){
            yOffset = 0;
        } else if(yOffset > handler.getWorld().getHeight() * Tile.tileHeight-handler.getHeight()){
            yOffset = handler.getWorld().getHeight() * Tile.tileHeight-handler.getHeight();
        }
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight()/2;
        checkBlankSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset +=xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getXOffset(){
        return xOffset;
    }
    public float getYOffset(){
        return yOffset;
    }
    public void setXOffset(float xOffset){
        this.xOffset = xOffset;
    }
    public void setYOffset(float yOffset){
        this.yOffset = yOffset;
    }
}