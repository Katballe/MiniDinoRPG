package game.dispaly;
import java.awt.image.BufferedImage;

public class Assets {

    private final static int widthPlayer = 4096/10, heightPlayer = 284;
    private final static int widthTiles = 62, heightTiles = 62;

    public static BufferedImage playerIdle1, playerRun1, stoneTile, grassTile, dirtTile;

    public static void init(){
        spriteSheet sheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/idlePlayer.png"));
        spriteSheet tileSheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/master-tileset.png"));

        playerIdle1 = sheet.crop(widthPlayer, 0, widthPlayer, heightPlayer);
        playerRun1 = sheet.crop(0, 0, widthPlayer, heightPlayer);

        stoneTile = tileSheet.crop(0, 0, widthTiles, heightTiles);
        grassTile = tileSheet.crop(0, heightTiles * 2, widthTiles, heightTiles);
        dirtTile = tileSheet.crop(0, heightTiles * 3, widthTiles, heightTiles);


    }
}