package game;

import game.dispaly.Display;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

public class Game implements Runnable {
    
    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;      // threds, learn about it! kinda a miniprogram. kører seperat fra "hoved kode"
    
    private BufferStrategy bs;      // read about it
    private Graphics g;
    
    public Game(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
    }
    
    private void init(){
        display = new Display(title, width, height);
    }
    
    private void update(){
        
    }
    
    private void render(){

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);    // MAX 3!
         //   bs = display.getCanvas().getBufferStrategy();
            return;
        }
        
        g = bs.getDrawGraphics();   // creates "the paint brush" for graphics 
        
        // clean the screen
        g.clearRect(0, 0, width, height);

        // draw here
        
        
        
        // end drawing
        
        // show
        bs.show();      // shows it 
        g.dispose();    // gets done 

    }
    

    public void run(){
        
        init();
        
        //game loop
        while(running){
            update();
            render();
        }
        
        stop();
    }
    
    
    
    //   læs op på synchronized
    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start(); // kalder run metoden
    }
    
    public synchronized void stop(){
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            
        }
        
    }
    
    
}