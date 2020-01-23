package game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;    //float for smooth movement
    protected int width, height;    // of the creature
    protected Rectangle bounds;
    
    
    public Entity(Handler handler, float x, float y, int witdh, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = witdh;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean checkEntityCollision(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)){
                continue;
            }
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            } 
        }
        return false;
    }

    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setWidth(int witdh){
        this.width = witdh;
    }
    public void setHeight(int height){
        this.height = height;
    }

    public abstract void update();

    public abstract void render(Graphics g);
}