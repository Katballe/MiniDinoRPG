package game;

import game.dispaly.Assets;
import game.dispaly.Display;
import game.dispaly.GameCamera;
import game.input.KeyManager;
import game.input.MouseManager;
import game.states.GameState;
import game.states.MainMenuState;
import game.states.State;

import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.awt.Graphics;

public class Game implements Runnable {     // MAIN CLASS OF THE GAME
                                            //  implements Runnable is for threads
    private Display display;
    private int width, height;
    public String title;

    private boolean running = false;
    private Thread thread; // threds, learn about it! kinda a miniprogram. kører seperat fra "hoved kode"

    private BufferStrategy bs; // read about it
    private Graphics g;

    // states
    public State gameState;
    public State menuState;

    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // camera
    private GameCamera gameCamera;

    // handler
    private Handler handler;


    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }

    private void init() {       // init, duh 
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        try {
            Assets.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        
        //testImage = imageLoader.loadImage("/game/rcs/textures/spritesheet.png");
        //sheet = new spriteSheet(testImage);

        gameState = new GameState(handler);
        menuState = new MainMenuState(handler);
        //  State.setState(gameState);
        State.setState(menuState);  //TEMP
    }


    private void update(){  // update variables
        keyManager.update();

        if (State.getState() != null){
            State.getState().update();
        }

    }
    
    private void render(){  // render images
        
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null){
            display.getCanvas().createBufferStrategy(3);    // MAX 3!
            return;
        }
        
        g = bs.getDrawGraphics();   // creates "the paint brush" for graphics 
            // it is the graphics object that does ALL rendering
            
        // clean the screen
        g.clearRect(0, 0, width, height);
        
        // draw here
        
        if (State.getState() != null){
            State.getState().render(g);
        }

        // end drawing
        
        // show
        bs.show();      // shows it 
        g.dispose();    // gets done 
        
    }
    
    
    public void run(){  // must have in "implements Runnable". this is a thread which always loops
        
        init();
        
        // setup
        int fps = 60;   // Update and frame rate 
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
                // the game
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
        
        stop(); // calls the sync method stop
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    
    //   læs op på synchronized -   sync syncroniserer stop og start når vi skal gå fra den ene til den anden så der ikke kommer problemet
    public synchronized void start(){   // Thread start 
        if (running)    // a safty
            return;
        running = true;
        thread = new Thread(this);
        thread.start(); // kalder run metoden
    }
    
    public synchronized void stop(){    //  thread stop
        if (!running)   // a safty
            return;
        running = false;
        try {
            thread.join();      // proper way to close a thread 
        } catch (Exception e) {
            
        }
        
    }
    
    
}