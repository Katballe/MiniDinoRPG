package game.crafting;

import game.Handler;
import game.inventory.Inventory;

public class Craft extends Inventory {

    

    public Craft(Handler handler) {
        super(handler);
    }

    public void tryCraft() {
        
    }

    public void setComponents(){
        this.craftingComponents = getCraftingComponents();
    }

}