package game.entities.creatures;

import game.entities.Entity;
import game.tile.Tile;
import game.Handler;

public abstract class Creature extends Entity {

    public static final int defaultHealth = 10;
    public static final float defaultSpeed = 2.3f;
    public static final int defaultCreatureWidth  = 80, 
                            defaultCreatureHeight = 80;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = defaultHealth;
        speed = defaultSpeed;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        moveX();
        moveY();
        
    }

    public void moveX(){
        if (xMove > 0){//moving right
            int tempX = (int) (x + xMove + bounds.x + bounds.width)/ Tile.tileWidth;

            if (!collisionWithTile(tempX, (int) (y + bounds.y) / Tile.tileHeight) // upper right
             && !collisionWithTile(tempX, (int) (y+bounds.y+bounds.height)/Tile.tileHeight)){ // lower right
                x += xMove;
            } else{
                x = tempX * Tile.tileWidth - bounds.x - bounds.width - 1;
            }

        } else if (xMove < 0){//moving left
            int tempX = (int) (x+ xMove + bounds.x)/ Tile.tileWidth;
            
            if (!collisionWithTile(tempX, (int) (y+bounds.y) / Tile.tileHeight) && // upper right
              !collisionWithTile(tempX, (int) (y+bounds.y+bounds.height)/Tile.tileHeight)){ // lower right
                x += xMove;
             }else {
                 x = tempX * Tile.tileWidth + Tile.tileWidth - bounds.x;
             }
        }
    }

    public void moveY(){
        if (yMove < 0) {// up
            int tempY = (int) (y + yMove + bounds.y) / Tile.tileHeight;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.tileWidth, tempY) && // upper left
            !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.tileWidth, tempY)){ // upper right
                y += yMove;
            }else{
                y = tempY * Tile.tileHeight + Tile.tileHeight - bounds.y;
            }


        } else if (yMove > 0) {//down
            int tempY = (int) (y + yMove + bounds.y + bounds.height) / Tile.tileHeight;

            if(!collisionWithTile((int) (x + bounds.x) / Tile.tileWidth, tempY) && // upper left
            !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.tileWidth, tempY)){ // upper right
                y+=yMove;
            }else{
                y = tempY * Tile.tileHeight - bounds.y - bounds.height - 1;
            }
        }


        //y += yMove;
    }


    protected boolean collisionWithTile(int x, int y){
        return handler.getWorld().getTile(x, y).isSolid();
    }

    // getters and setters
    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setHealth(int health){
        this.health = health;
    }
    public void setSpeed(float speed){
        this.speed = speed;
    }

    public float getXMove(){
        return xMove;
    }
    public float getYMove(){
        return yMove;
    }
    public void setXMove(float xMove){
        this.xMove = xMove;
    }
    public void setYMove(float yMove){
        this.yMove = yMove;
    }
    
}