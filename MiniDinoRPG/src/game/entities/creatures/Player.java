package game.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

import game.Handler;
import game.dispaly.Animation;
import game.dispaly.Assets;
import game.entities.Entity;
import game.inventory.Inventory;

public class Player extends Creature {
    
    //animation
    private Animation animWalk, animWalkLeft, animIdle, animIdleLeft, animPlayerAttack;
    // attack timer
    private long lastAttack, attackCooldown = 400, attackTimer = attackCooldown;
    private boolean attackRight = false;

    // inventory
    private Inventory inventory;
    
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.defaultCreatureWidth, Creature.defaultCreatureHeight);
        
        bounds.x = 15;
        bounds.y = 30;
        bounds.width = 25; //25
        bounds.height = 40; //40
        
        inventory = new Inventory(handler);

        //animation setup
        animWalk = new Animation(125, Assets.playerWalk);
        animIdle = new Animation(125, Assets.playerIdle);
        animWalkLeft = new Animation(125, Assets.playerWalkLeft);
        animIdleLeft = new Animation(125, Assets.playerIdleLeft);
        animPlayerAttack = new Animation(40, Assets.playerBasicAttack);
    }
    
    @Override
    public void update() {
        animWalk.update();
        animIdle.update();
        animWalkLeft.update();
        animIdleLeft.update();
        animPlayerAttack.update();
        
        //movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        
        //attack
        checkAttacks();

        //  inventory
        inventory.update();
        
    }
    
    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttack;
        lastAttack = System.currentTimeMillis();
        if (attackTimer < attackCooldown) {
            return;
        }

        if(inventory.isActive()){
            return;
        }
        
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 30;
        ar.width = arSize;
        ar.height = arSize;
        
        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        } else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        } else if(handler.getKeyManager().aLeft){
            ar.x = cb.x  - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().aRight){
            ar.x = cb.x  + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            animPlayerAttack.resetIndex();
            attackRight = true;
        } else {
            attackRight = false;
            
            return;
        }
        
        attackTimer = 0;
        
        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)) {
                continue;
            }
            if(e.getCollisionBounds(0, 0).intersects(ar)){
                e.hurt(1);
                return;
            }
        }
    }

    
    @Override
    public void die(){
        System.out.println("YOU LOOSE!");
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(inventory.isActive()){
            return;
        }
        
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

        g.drawImage(getCurrentAnimationFrame(), (int) (x-handler.getGameCamera().getXOffset()), (int) (y-handler.getGameCamera().getYOffset()), width, height, null);
        
        g.drawImage(playAttackAnim(), (int) (x-handler.getGameCamera().getXOffset() + Creature.defaultCreatureWidth / 1.7), (int) (y-handler.getGameCamera().getYOffset() + 20), 22, 30, null);
        
        
        // show collosion box
        /*
        g.setColor(Color.RED);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getXOffset()), (int) (y + bounds.y - handler.getGameCamera().getYOffset()), 
        bounds.width, bounds.height);
        */

        
    }

    
    public void postRender(Graphics g){
        inventory.render(g);
    }
    
    private BufferedImage playAttackAnim(){
        if (attackRight && animPlayerAttack.getTimesRun() == 0){
            return animPlayerAttack.getCurrentFrame();
        }
        
        return null;
    }

    int prevDir;
    
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove > 0){
            prevDir = 1;
            return animWalk.getCurrentFrame();
        } else if (xMove < 0) {
            prevDir = 2;
            return animWalkLeft.getCurrentFrame();
        } else if (yMove != 0 ){
            prevDir = 1;
            return animWalk.getCurrentFrame();
        } else {
            
            // return Assets.ModelOne; // temp with new model
            

            if (prevDir == 1){
                return animIdle.getCurrentFrame();
            } else if (prevDir == 2){
                return animIdleLeft.getCurrentFrame();
            } else {
                return animIdle.getCurrentFrame();
            }

            
        }
        // return animWalk.getCurrentFrame();
        
    }

    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }
    
}