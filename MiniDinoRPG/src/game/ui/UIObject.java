package game.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;


public abstract class UIObject {

    protected float x,y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering = false;

    public UIObject(float x, float y, int width, int height){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;

        bounds = new Rectangle((int) x, (int) y, width, height);

    }

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract void onClick();

    public void onMouseMove(MouseEvent e){
        if(bounds.contains(e.getX(), e.getY())){
            hovering = true;
        } else {
            hovering = false;
        }
    }

    public void onMouseRelease(MouseEvent e){
        if(hovering){
            onClick();
        }
    }

    //setters and getters

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.x = y;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }

    
}