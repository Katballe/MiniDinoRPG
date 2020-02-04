package game.input;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyManager implements KeyListener {
    
    private boolean[] keys, justPressed, cantPress;
    public boolean up, down, left, right;
    public boolean aUp, aDown, aLeft, aRight;
    
    public KeyManager(){
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }
    
    public void update(){
        for (int i = 0; i < keys.length;i++){
            if(cantPress[i] && !keys[i]){
                cantPress[i] = false;
            }else if(justPressed[i]){
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }

        aUp = keys[KeyEvent.VK_UP];
        aDown = keys[KeyEvent.VK_DOWN];
        aRight = keys[KeyEvent.VK_RIGHT];
        aLeft = keys[KeyEvent.VK_LEFT];
        
        
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
        return false;
        return justPressed[keyCode];
        }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
            return;
        }
        keys[e.getKeyCode()] = true;
        //System.out.println("Pressed: " + e.getKeyCode());
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
            return;
        }
        keys[e.getKeyCode()] = false;
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
}