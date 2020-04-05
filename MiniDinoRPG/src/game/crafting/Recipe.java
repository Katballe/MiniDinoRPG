package game.crafting;

import game.items.Item;

public class Recipe {
    /*
    public static Recipe[] recipes = new Recipe[256];
    
    public static Recipe rockOnStick = new Recipe("RockOnStick", 0, 1, 1, 1);
    
    public Recipe(String name, int itemIdOne, int itemCountOne, int itemIdTwo, int itemCountTwo){
        
    }
    */
    
    
    
    
    // variables
    private Item item;
    private int componentOneId, componentOneCount, componentTwoCount, componentTwoId, recipeId;

    private static Recipe[] recipeList = new Recipe[256];
    public static Recipe rockOnStoneRecipe = new Recipe(Item.rockOnStickItem, 1, 1, 0, 1, 0);
    public static Recipe pureGold = new Recipe(Item.pureGold, 2, 1, 2, 1, 1);

    public Recipe(Item item, int componentOneId, int componentOneCount, int componentTwoId, 
            int componentTwoCount, int recipeId) {
        this.componentOneId = componentOneId;
        this.componentTwoId = componentTwoId;
        this.componentOneCount = componentOneCount;
        this.componentTwoCount = componentTwoCount;
        this.item = item;
        this.recipeId = recipeId;

        recipeList[recipeId] = this;

    }

    public int getComponentOneId() {
        return componentOneId;
    }

    public int getComponentTwoId() {
        return componentTwoId;
    }

    public int getComponentOneCount() {
        return componentOneCount;
    }

    public int getComponentTwoCount() {
        return componentTwoCount;
    }

    public Item getItem() {
        return item;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public static Recipe[] getRecipeList() {
        return recipeList;
    }
    
}