package game.inventory;

import game.Handler;
import game.crafting.Recipe;
import game.dispaly.Assets;
import game.dispaly.Text;
import game.items.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Inventory {
    
    protected int[] craftingComponents = new int[4];
    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;
    
    // for scetch
    private int invX = 64, invY = 48, invWidth = 512, invHeight = 384;
    private int invListCenterX = invX + 171, invListCenterY = invY + invHeight / 2 + 5;
    private int invListSpacing = 30, invCountX = 484, invCountY = 172;
    private int selectedItem = 0, craftCounter;

    private int invImageX = 452, invImageY = 82, invImageWidth = 64, invImageHeight = 64;
    
    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();
        
        // for test
        addItem(Item.woodItem.createNew(5)); 
        addItem(Item.stoneItem.createNew(5));
        addItem(Item.goldItem.createNew(5));
        
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

        
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)){
            if (craftCounter == 0) {
                craftingComponents[0] = selectedItem;
                craftCounter++;
                System.out.println(craftingComponents[0] + " CHO - SI " + selectedItem);
                
                
            } else if (craftCounter == 1) {
                craftingComponents[2] = selectedItem;
                craftCounter++;
                System.out.println(craftingComponents[2] + " CHO - SI " + selectedItem);
            }
            
        }
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_Y)) { // craft
            
            System.out.println("here");            
            
            try{
                int id1, id2, count1, count2;
                id1 = inventoryItems.get(craftingComponents[0]).getId();
                count1 = inventoryItems.get(craftingComponents[0]).getCount();
                System.out.println("here");
                id2 = inventoryItems.get(craftingComponents[2]).getId();
                count2 = inventoryItems.get(craftingComponents[2]).getCount();
                
                if(!tryCraft(id1, count1, id2, count2)){
                    return;
                }
                System.out.println("Post tryCraft");
                craftingComponents[0] = 0;
                craftingComponents[2] = 0;
                craftCounter = 0;
                selectedItem = 0;
                
                System.out.println("Succes");
            } catch (Exception e){
                System.out.println("failed");
                e.printStackTrace();
                
            }
            
        }
        
        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)){ // counter --
            craftCounter = 0;
            
        }
        
        
        Collections.sort(inventoryItems, Comparator.comparingInt(Item::getId)); // sorting inventory items by ID
        
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
    

    public boolean tryCraft(int idOne, int countOne, int idTwo, int countTwo) {
        for(Recipe r : Recipe.getRecipeList()){
            if ((idOne == r.getComponentOneId() && idTwo == r.getComponentTwoId()) 
            || idTwo == r.getComponentOneId() && idOne == r.getComponentTwoId()){
                idOne = r.getComponentOneId(); idTwo = r.getComponentTwoId();
                addItem(r.getItem(), 1);
                // remove item costs
                addItem(Item.items[idOne], -r.getComponentOneCount());
                addItem(Item.items[idTwo], -r.getComponentTwoCount());
                return true;
            } 
        }
        return false;
    }

    
    // getters and setters
    
    public int getIndexOf(Item item){
        return inventoryItems.indexOf(item);
    }
    
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
    
    public int[] getCraftingComponents() {
        return craftingComponents;
    }
}