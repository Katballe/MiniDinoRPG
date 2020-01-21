package game.dispaly;

import game.Game;
import game.entities.Entity;

public class GameCamera {

    private Game game;
    private float xOffset, yOffset;

    public GameCamera (Game game, float xOffset, float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnEntity(Entity e){
        xOffset = e.getX() - game.getWidth() / 2 + e.getWidth()/2;
        yOffset = e.getY() - game.getHeight() / 2 + e.getHeight()/2;
    }

    public void move(float xAmt, float yAmt){
        xOffset +=xAmt;
        yOffset += yAmt;
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