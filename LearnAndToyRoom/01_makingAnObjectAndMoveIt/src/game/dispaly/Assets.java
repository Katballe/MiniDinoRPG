package game.dispaly;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
import javax.imageio.ImageIO;

public class Assets {

    private final static int widthPlayer = 4096 / 10, heightPlayer = 284;
    private final static int widthPlayerWalk = 6800 / 10, heightPlayerWalk = 472;
    private final static int widthPlayerIdle = 4096 / 10, heightPlayerIdle = 284;
    private final static int widthTiles = 62, heightTiles = 62;

    public static Font font28, font48;

    public static BufferedImage stoneTile, grassTile, dirtTile, treeOne, startButton, log, rock;
    public static BufferedImage[] playerWalk, playerIdle, playerWalkLeft, playerIdleLeft, playerBasicAttack;
    public static BufferedImage inventoryScreen, stone, wildGrass, wildGrass2, ModelOne;

    public static void init() throws IOException {
        // font
        font28 = FontLoader.loadFond("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\fonts\\slkscr.ttf", 28);
        font48 = FontLoader.loadFond("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\fonts\\slkscr.ttf", 48);
        // spriteSheet sheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/idlePlayer.png"));
        
        // texture
        spriteSheet tileSheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/master-tileset.png"));
        spriteSheet treeSheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/Tree_SpriteSheet_Outlined.png"));
        
        // palyer
        spriteSheet walkSprite = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/spritesheetWalk.png"));
        spriteSheet walkSpriteLeft = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/spritesheetWalkLeft.png"));
        spriteSheet idleSprite = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/idlePlayer.png"));
        spriteSheet idleSpriteLeft = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/idlePlayerLeft.png"));


        // attack 
        spriteSheet playerBasicAttackSheet = new spriteSheet(imageLoader.loadImage("/game/rcs/attack/attackAnimatinSprite.png"));
        //spriteSheet playerBasicAttackSheet = new spriteSheet(imageLoader.loadImage("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\attack\\attackAnimatinSprite.png"));

        
        startButton = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\menu\\startButton.png"));             // start button
        log = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\log.png"));                         // log
        rock = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\rock.png"));                       // rock
        inventoryScreen = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\menu\\inventoryScreen.png"));     // inventory screen
        stone = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\stone.png"));                     // stone
        wildGrass = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\wildGrassTile.png"));         // wild grass
        wildGrass2 = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\wildGrassTile2.png"));       // wild grass w. flowers
        ModelOne = ImageIO.read(new File("LearnAndToyRoom\\01_makingAnObjectAndMoveIt\\src\\game\\rcs\\textures\\ModelOne.png"));       // player model one 

        playerBasicAttack = new BufferedImage[7];
        playerBasicAttack[0] = playerBasicAttackSheet.crop(8, 8, 19, 18);
        playerBasicAttack[1] = playerBasicAttackSheet.crop(48, 8, 19, 18);
        playerBasicAttack[2] = playerBasicAttackSheet.crop(88, 8, 19, 18);
        playerBasicAttack[3] = playerBasicAttackSheet.crop(128, 8, 19, 18);
        playerBasicAttack[4] = playerBasicAttackSheet.crop(168, 8, 19, 18);
        playerBasicAttack[5] = playerBasicAttackSheet.crop(208, 8, 19, 18);
        playerBasicAttack[6] = playerBasicAttackSheet.crop(248, 8, 19, 18);

        playerWalk = new BufferedImage[10];
        playerWalk[0] = walkSprite.crop(0, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[1] = walkSprite.crop(widthPlayerWalk, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[2] = walkSprite.crop(widthPlayerWalk*2, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[3] = walkSprite.crop(widthPlayerWalk*3, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[4] = walkSprite.crop(widthPlayerWalk*4, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[5] = walkSprite.crop(widthPlayerWalk*5, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[6] = walkSprite.crop(widthPlayerWalk*6, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[7] = walkSprite.crop(widthPlayerWalk*7, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[8] = walkSprite.crop(widthPlayerWalk*8, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalk[9] = walkSprite.crop(widthPlayerWalk*9, 0, widthPlayerWalk, heightPlayerWalk);

        playerWalkLeft = new BufferedImage[10];
        playerWalkLeft[0] = walkSpriteLeft.crop(0, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[1] = walkSpriteLeft.crop(widthPlayerWalk, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[2] = walkSpriteLeft.crop(widthPlayerWalk*2, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[3] = walkSpriteLeft.crop(widthPlayerWalk*3, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[4] = walkSpriteLeft.crop(widthPlayerWalk*4, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[5] = walkSpriteLeft.crop(widthPlayerWalk*5, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[6] = walkSpriteLeft.crop(widthPlayerWalk*6, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[7] = walkSpriteLeft.crop(widthPlayerWalk*7, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[8] = walkSpriteLeft.crop(widthPlayerWalk*8, 0, widthPlayerWalk, heightPlayerWalk);
        playerWalkLeft[9] = walkSpriteLeft.crop(widthPlayerWalk*9, 0, widthPlayerWalk, heightPlayerWalk);

        playerIdle = new BufferedImage[10];
        playerIdle[0] = idleSprite.crop(0, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[1] = idleSprite.crop(widthPlayerIdle, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[2] = idleSprite.crop(widthPlayerIdle*2, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[3] = idleSprite.crop(widthPlayerIdle*3, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[4] = idleSprite.crop(widthPlayerIdle*4, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[5] = idleSprite.crop(widthPlayerIdle*5, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[6] = idleSprite.crop(widthPlayerIdle*6, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[7] = idleSprite.crop(widthPlayerIdle*7, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[8] = idleSprite.crop(widthPlayerIdle*8, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdle[9] = idleSprite.crop(widthPlayerIdle*9, 0, widthPlayerIdle, heightPlayerIdle);

        playerIdleLeft = new BufferedImage[10];
        playerIdleLeft[0] = idleSpriteLeft.crop(0, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[1] = idleSpriteLeft.crop(widthPlayerIdle, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[2] = idleSpriteLeft.crop(widthPlayerIdle*2, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[3] = idleSpriteLeft.crop(widthPlayerIdle*3, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[4] = idleSpriteLeft.crop(widthPlayerIdle*4, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[5] = idleSpriteLeft.crop(widthPlayerIdle*5, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[6] = idleSpriteLeft.crop(widthPlayerIdle*6, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[7] = idleSpriteLeft.crop(widthPlayerIdle*7, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[8] = idleSpriteLeft.crop(widthPlayerIdle*8, 0, widthPlayerIdle, heightPlayerIdle);
        playerIdleLeft[9] = idleSpriteLeft.crop(widthPlayerIdle*9, 0, widthPlayerIdle, heightPlayerIdle);

        
        // texture 
        stoneTile = tileSheet.crop(0, 0, widthTiles, heightTiles);
        grassTile = tileSheet.crop(0, heightTiles * 2, widthTiles, heightTiles);
        dirtTile = tileSheet.crop(0, heightTiles * 3, widthTiles, heightTiles);
        treeOne = treeSheet.crop((448/5), 132, (448/5), 92);


        

    }
}