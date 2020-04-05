package game.tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Tile {

    // static stuff

    public static Tile[] tiles = new Tile[256];
    //public static Tile grass = new GrassTile(0);
    public static Tile wildGrass = new WildGrass(0);
    public static Tile dirt = new DirtTile(1);
    public static Tile rock = new RockTile(2);
    public static Tile wildGrass2 = new WildGrassTwo(3);

    //class
    public static final int tileWidth = 64, tileHeight = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void update(){

    }

    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, tileWidth, tileHeight, null);
    }

    public boolean isSolid(){
        return false;
    }

    public int getID(){
        return id;
    }
}