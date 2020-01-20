package game.tile;

import game.dispaly.Assets;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stoneTile, id);
        
    }

    @Override
    public boolean isSolid() {
        return true;
    }
    
    
}