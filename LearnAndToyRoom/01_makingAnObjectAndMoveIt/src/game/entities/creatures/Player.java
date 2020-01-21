package game.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import game.Handler;
import game.dispaly.Assets;

public class Player extends Creature {

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.defaultCreatureWidth, Creature.defaultCreatureHeight);

        bounds.x = 15;
        bounds.y = 30;

        bounds.width = 25; //25
        bounds.height = 40; //40


    }

    @Override
    public void update() {
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        // temp
        /*
        if (game.getKeyManager().up){
            y -= 3;
        }
        if (game.getKeyManager().down){
            y += 3;
        }
        if (game.getKeyManager().left){
            x -= 3;
        }
        if (game.getKeyManager().right){
            x += 3;
        } 
        */
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up){
            yMove = -speed;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
        }
        if (handler.getKeyManager().right){
            xMove = speed;
        } 

    }

    @Override
    public void render(Graphics g) {
        /*if (xMove == 0 && yMove == 0){
            g.drawImage(Assets.playerIdle1, (int) (x-game.getGameCamera().getXOffset()), (int) (y-game.getGameCamera().getYOffset()), width, height, null);
        } else {
            g.drawImage(Assets.playerRun1, (int) (x-game.getGameCamera().getXOffset()), (int) (y-game.getGameCamera().getYOffset()), width, height, null);
        }*/
        g.drawImage(Assets.playerRun1, (int) (x-handler.getGameCamera().getXOffset()), (int) (y-handler.getGameCamera().getYOffset()), width, height, null);


        // show collosion box
        /*
        g.setColor(Color.RED);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXOffset()), (int) (y + bounds.y - handler.getGameCamera().getYOffset()), 
        bounds.width, bounds.height);
        */
    }

    
}