package game;

import game.dispaly.Assets;
import game.dispaly.Display;
import game.dispaly.imageLoader;
import game.dispaly.spriteSheet;
import game.input.KeyManager;
import game.states.GameState;
import game.states.MainMenuState;
import game.states.State;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;



public class Game implements Runnable {
    
    private Display display;
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;      // threds, learn about it! kinda a miniprogram. kører seperat fra "hoved kode"
    
    private BufferStrategy bs;      // read about it
    private Graphics g;
    

    //states 
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    //temp code
    //private int counter;
    //private BufferedImage testImage;
    //private spriteSheet sheet;

    //temp code end 
    



    public Game(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;
        keyManager = new KeyManager();
    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        //testImage = imageLoader.loadImage("/game/rcs/textures/spritesheet.png");
        //sheet = new spriteSheet(testImage);

        gameState = new GameState(this);
        menuState = new MainMenuState(this);
        State.setState(gameState);
    }

    /*
    int x = 0;
    int y = 0;
    int xSpeed = 1;
    int ySpeed = 1;
    */
    private void update(){
        keyManager.update();

        if (State.getState() != null){
            State.getState().update();
        }
        /*
        if (x+166 == width){
            xSpeed = -1;
        } else if (xSpeed == -1 && x==0){
            xSpeed = 1;
        }
        if (y+160 == height){
            ySpeed = -1;
        } else if (ySpeed == -1 && y==0){
            ySpeed = 1;
        }
        x+=xSpeed;
        y+=ySpeed;
        */
    }
    
    private void render(){
        
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);    // MAX 3!
            return;
        }
        
        g = bs.getDrawGraphics();   // creates "the paint brush" for graphics 
        
        // clean the screen
        g.clearRect(0, 0, width, height);
        
        // draw here
        /*
        if (counter == 1) {
            g.drawImage(Assets.playerRun1, x, 10, null);
        } else if (counter ==2) {
            g.drawImage(Assets.playerRun2, x, 10, null);
        } else if (counter ==3) {
            g.drawImage(Assets.playerRun3, x, 10, null);
        } else if (counter ==4) {
            g.drawImage(Assets.playerRun4, x, 10, null);
        } else {
            counter = 0;
        }
        counter ++;
        */
        //g.drawImage(Assets.playerRun1, x, y, null); // image observer - temp
        
        if (State.getState() != null){
            State.getState().render(g);
        }

        // end drawing
        
        // show
        bs.show();      // shows it 
        g.dispose();    // gets done 
        
    }
    
    
    public void run(){
        
        init();
        
        // setup
        int fps = 60;   // den ønskede fps. 
        double timePerUpdate = 1000000000 / fps; // nanosek per sek. Maximum amount of times we are allowed to run the loop
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int updates = 0;

        //game loop
        while(running){
            now = System.nanoTime();
            delta += (now-lastTime)/timePerUpdate; // time untill we should call update & render
            timer += now-lastTime;
            lastTime = now;


            if (delta >= 1){
                update();
                render();
                updates++;
                delta --;
            }
        if (timer >= 1000000000){
            System.out.println("Updates and frames: " + updates);
            updates = 0;
            timer = 0;
        }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
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