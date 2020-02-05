package game.inventory;

import game.Handler;
import game.dispaly.Assets;
import game.dispaly.Text;
import game.items.Item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Inventory {

    private Handler handler;
    private boolean active = false;
    private ArrayList<Item> inventoryItems;

    // for scetch
    private int invX = 64, invY = 48, invWidth = 512, invHeight = 384;
    private int invListCenterX = invX + 171, invListCenterY = invY + invHeight/2 + 5;
    private int invListSpacing = 30, invCountX = 484, invCountY = 172;
    private int selectedItem = 0;

    private int invImageX = 452, invImageY = 82,
			invImageWidth = 64, invImageHeight = 64;

    public Inventory(Handler handler) {
        this.handler = handler;
        inventoryItems = new ArrayList<Item>();

        // for test
        //addItem(Item.woodItem.createNew(5)); 
    }

    public void update(){
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
}