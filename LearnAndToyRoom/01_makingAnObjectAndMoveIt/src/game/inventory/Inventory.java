package game.inventory;

import game.Handler;
import game.dispaly.Assets;
import game.dispaly.Text;
import game.items.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {
    
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    
    // for scetch
    private int invX = 64, invY = 48, invWidth = 512, invHeight = 384;
    private int invListCenterX = invX + 171, invListCenterY = invY + invHeight/2 + 5;
    private int invListSpacing = 30, invCountX = 484, invCountY = 172;
    private int selectedItem = 0, craftChoiceOne, craftChoiceTwo, craftCounter;
    //    private boolean selected = false;
    
    private int invImageX = 452, invImageY = 82,
    invImageWidth = 64, invImageHeight = 64;
    
    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
        
        // for test
        //addItem(Item.woodItem.createNew(5)); 
        
    }
    
    public void update(){
        // open/close inventory
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_E)) {
            active = !active;
        }
        if(!active){
            return;
        }
        
        // rotate 
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
            selectedItem--;
        }
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
            selectedItem++;
        }
        
        if (selectedItem < 0 ) {
            selectedItem = inventoryItems.size()-1;
        }else if (selectedItem >= inventoryItems.size()) {
            selectedItem = 0;
        }
        
        
        // ***************  CRAFTING  ***********************************
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)){
            if (craftCounter == 0) {
                craftChoiceOne = selectedItem;
                craftCounter++;
                System.out.println(craftChoiceOne + " CHO - SI " + selectedItem);
            } else if (craftCounter == 1) {
                craftChoiceTwo = selectedItem;
                craftCounter++;
                System.out.println(craftChoiceTwo + " CHO - SI " + selectedItem);
            }
        }
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_Y)) { // craft
            System.out.println("here");
            int id1, id2, count1, count2;
            id1 = inventoryItems.get(craftChoiceOne).getId();
            count1 = inventoryItems.get(craftChoiceOne).getCount();
            System.out.println("here");
            id2 = inventoryItems.get(craftChoiceTwo).getId();
            count2 = inventoryItems.get(craftChoiceTwo).getCount();
            System.out.println("here");
            if ((id1 == 0 || id2 == 0) && (id1 == 1 || id2 == 1)) {
                if (count1 != 0 && count2 != 0) {
                    System.out.println(inventoryItems.get(craftChoiceOne).getCount());
                    System.out.println(inventoryItems.get(craftChoiceTwo).getCount());
                    addItem(Item.rockOnStickItem, 1);
                    addItem(Item.stoneItem, -1);
                    addItem(Item.woodItem, -1);
                    System.out.println(inventoryItems.get(craftChoiceOne).getCount());
                    System.out.println(inventoryItems.get(craftChoiceTwo).getCount());
                    
                    boolean r1 = false, r2 = false;
                    
                    if (inventoryItems.get(craftChoiceOne).getCount() == 0) {
                        r1 = true;
                    }
                    
                    if (inventoryItems.get(craftChoiceTwo).getCount() == 0) {
                        r2 = true;
                    }
                    
                    if(r1 == true && r2 == true) {   
                        inventoryItems.remove(craftChoiceOne);
                        inventoryItems.remove(craftChoiceTwo);
                    } else if (r1 == true){
                        inventoryItems.remove(craftChoiceOne);
                    } else if(r2 == true){
                        inventoryItems.remove(craftChoiceTwo);
                    }
                    
                }
                craftChoiceOne = 0;
                craftChoiceTwo = 0;
                craftCounter = 0;
                selectedItem = 0;
            }
        }
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)){ // counter --
            craftCounter = 0;
            
        }
        
        
        /*
        System.out.println("Inventory is open");
        for (Item i : inventoryItems) {
            System.out.println(i.getName() + " " + i.getCount());
        }*/
    }
    
    
    
    public void render(Graphics g){
        if(!active){
            return;
        }
        
        g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
        // Text.drawString(g, "> Wood <", invListCenterX, invListCenterY, true, Color.WHITE, Assets.font28);
        
        int len = inventoryItems.size();
        if (len == 0) {
            return;            
        }
        
        for(int i = -5; i < 6; i++){
            if (selectedItem + i < 0 || selectedItem + i >= len) {
                continue; // skips item
            }
            
            if (i == 0) {
                Text.drawString(g, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX, invListCenterY + i* invListSpacing, true, Color.YELLOW, Assets.font28);
                //System.out.println(inventoryItems.get(selectedItem).getName());
            } else {                                
                Text.drawString(g, inventoryItems.get(selectedItem + i).getName(), invListCenterX, invListCenterY + i* invListSpacing, true, Color.WHITE, Assets.font28);
            }
            
            
        }
        
        Item item = inventoryItems.get(selectedItem);
        g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
        Text.drawString(g, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
        
    }
    
    // inventory methods
    
    public void addItem(Item item){
        for(Item i : inventoryItems){
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + item.getCount());
                return;
            }
        }
        inventoryItems.add(item);
    }
    
    public void addItem(Item item, int count){
        for(Item i : inventoryItems){
            if (i.getId() == item.getId()) {
                i.setCount(i.getCount() + count);
                return;
            }
        }
        inventoryItems.add(item);
        
        
    }
    
    
    // getters and setters
    
    public Handler gethandler(){
        return handler;
    }
    public void setHandler(Handler handler){
        this.handler = handler;
    }
    public boolean isActive(){
        return active;
    }
    public int getSelectedItem(){
        return selectedItem;
    }
    
}