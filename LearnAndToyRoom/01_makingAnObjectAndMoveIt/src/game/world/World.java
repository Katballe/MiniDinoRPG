package game.world;

import java.awt.Graphics;

import game.tile.Tile;

public class World {

    private int width, height;
    private int [][] tiles;

    public World(String path){
        loadWorld(path);
    }

    public void update(){

    }

    public void render(Graphics g){
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                getTile(x, y).render(g, x * Tile.tileWidth, y * Tile.tileHeight);
            }
        }
    }

    public Tile getTile(int x, int y){
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null){
            return Tile.dirt;
        }
        return t;
    }


    private void loadWorld(String path){
        /*
        //temp
        width = 5;
        height = 5;
        tiles = new int[width][height];

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                tiles[x][y] = 2;    // tile type
            }
        }
        */
    }
    

}