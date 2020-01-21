package game.entities.creatures;

import java.awt.Graphics;

import game.Game;
import game.dispaly.Assets;

public class Player extends Creature {

    public Player(Game game, float x, float y) {
        super(game, x, y, Creature.defaultCreatureWidth, Creature.defaultCreatureHeight);
    }

    @Override
    public void update() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);

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
        /*if (xMove == 0 && yMove == 0){
            g.drawImage(Assets.playerIdle1, (int) (x-game.getGameCamera().getXOffset()), (int) (y-game.getGameCamera().getYOffset()), width, height, null);
        } else {
            g.drawImage(Assets.playerRun1, (int) (x-game.getGameCamera().getXOffset()), (int) (y-game.getGameCamera().getYOffset()), width, height, null);
        }*/
        g.drawImage(Assets.playerRun1, (int) (x-game.getGameCamera().getXOffset()), (int) (y-game.getGameCamera().getYOffset()), width, height, null);
    }

    
}