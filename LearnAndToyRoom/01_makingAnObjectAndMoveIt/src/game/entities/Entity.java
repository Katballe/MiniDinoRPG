package game.entities;

import java.awt.Graphics;

import game.Game;

public abstract class Entity {

    protected Game game;
    protected float x,y;    //float for smooth movement
    protected int width, height;    // of the creature
    
    
    public Entity(Game game, float x, float y, int witdh, int height){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = witdh;
        this.height = height;
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