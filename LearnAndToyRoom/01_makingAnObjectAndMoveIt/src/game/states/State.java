package game.states;

import java.awt.Graphics;

import game.Handler;

public abstract class State {       // read up on abstract classes 
    
    //gamestate manager
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    protected Handler handler;

    public State (Handler handler){
        this.handler = handler;
    }


    // interface(?)
    public abstract void update();

    public abstract void render(Graphics g);
    
}