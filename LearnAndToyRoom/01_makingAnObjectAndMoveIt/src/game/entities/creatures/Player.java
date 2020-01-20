package game.entities.creatures;

import java.awt.Graphics;

import game.Game;
import game.dispaly.Assets;

public class Player extends Creature {
    private Game game;

    public Player(Game game, float x, float y) {
        super(x, y, Creature.defaultCreatureWidth, Creature.defaultCreatureHeight);
        this.game = game;
    }

    @Override
    public void update() {
        getInput();
        move();

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

        if (game.getKeyManager().up){
            yMove = -speed;
        }
        if (game.getKeyManager().down){
            yMove = speed;
        }
        if (game.getKeyManager().left){
            xMove = -speed;
        }
        if (game.getKeyManager().right){
            xMove = speed;
        } 

    }

    @Override
    public void render(Graphics g) {
        if (xMove == 0 && yMove == 0){
            g.drawImage(Assets.playerIdle1, (int) x, (int) y, width, height, null);
        } else {
            g.drawImage(Assets.playerRun1, (int) x, (int) y, width, height, null);
        }
        
    }

    
}