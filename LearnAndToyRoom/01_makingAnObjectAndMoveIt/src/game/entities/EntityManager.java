package game.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.Graphics;
import game.Handler;
import game.entities.creatures.Player;

public class EntityManager {
    
    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
                return -1;
            } else {
                return 1;
            }
            
        }
    };
    
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }
    
    public void update(){
        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){            // this way entities will never be skipped. If several entities are removed at the same update, some might be skipped if previous version 
                                        // op remove loop is used 
            Entity e = it.next();
            e.update();
            if(!e.active){
                it.remove();
            }

        }
        /*          this might skip entities
        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);
            e.update();
            if(!e.getActive()){
                entities.remove(e);
            }
        */
        entities.sort(renderSorter);
    }
    
    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        player.postRender(g);
    }
    
    public void addEntity(Entity e){
        entities.add(e);
    }
    
    
    //getters and setters
    public Handler getHandler() {
        return handler;
    }
    
    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public ArrayList<Entity> getEntities() {
        return entities;
    }
    
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}