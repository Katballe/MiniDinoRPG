package game.dispaly;

import java.awt.image.BufferedImage;


public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    private int timesRun = 0;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update(){
        timer += System.currentTimeMillis()-lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer=0;
            if(index >= frames.length){
                timesRun++;
                index = 0;
            }
        }
    }

    public int getTimesRun(){
        return timesRun;
    }

    public void resetIndex(){
        this.timesRun = 0;
        this.index = 0;
    }
    public int getFrameLegth(){
        return frames.length;
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }


}