package game.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.Handler;

public abstract class Entity {

    protected int health;
    public static final int defaultHealth = 3;  // BASE HEALTH

    protected boolean active = true;

    protected Handler handler;
    protected float x,y;            // float for smooth movement
    protected int width, height;    // size of the creature
    protected Rectangle bounds;
    
    
    public Entity(Handler handler, float x, float y, int witdh, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = witdh;
        this.height = height;
        health = defaultHealth;

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

    public void hurt(int damageTaken){
        health -= damageTaken;
        if(health <= 0){
            active = false;
            die();
        }
    }

    // Abstract classes

    public abstract void update();

    public abstract void render(Graphics g);

    public abstract void die();
    
    
    // Getters and setters 

    public int getHealth(){
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public boolean getActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
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


}