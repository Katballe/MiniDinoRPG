package game.world;

import java.awt.Graphics;

import game.Handler;
import game.tile.Tile;
import game.utils.Utils;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int [][] tiles;

    public World(Handler handler, String path){
        this.handler = handler;
        loadWorld(path);
    }

    public void update(){

    }

    public void render(Graphics g){
        int xStart= (int) Math.max(0, handler.getGameCamera().getXOffset() / Tile.tileWidth), 
            xEnd =  (int) Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth())/ Tile.tileWidth + 1), 
            yStart= (int) Math.max(0, handler.getGameCamera().getYOffset() / Tile.tileHeight), 
            yEnd =  (int) Math.min(height, (handler.getGameCamera().getYOffset() + handler.getWidth())/ Tile.tileHeight + 1);

        for (int y = yStart; y < yEnd; y++){
            for (int x = xStart; x < xEnd; x++){
                getTile(x, y).render(g, (int) (x * Tile.tileWidth - handler.getGameCamera().getXOffset()), (int ) (y * Tile.tileHeight - handler.getGameCamera().getYOffset()));
            }
        }
    }

    public Tile getTile(int x, int y){
        if(x < 0 ||y < 0 ||x >= width ||y>= height){
            return Tile.grass;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null){
            return Tile.dirt;
        }
        return t;
    }


    private void loadWorld(String path){
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);    // tile type
            }
        }

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