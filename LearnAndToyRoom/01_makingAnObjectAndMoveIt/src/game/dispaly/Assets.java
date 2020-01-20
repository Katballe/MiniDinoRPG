package game.dispaly;
import java.awt.image.BufferedImage;

public class Assets {

    private final static int width = 166, height = 160;

    public static BufferedImage playerRun1, playerRun2, playerRun3, playerRun4, playerRun5, playerRun6, playerRun7, playerRun8;

    public static void init(){
        spriteSheet sheet = new spriteSheet(imageLoader.loadImage("/game/rcs/textures/spritesheet.png"));
        // 166x160

        playerRun1 = sheet.crop(0, 0, width, height);
        playerRun2 = sheet.crop(width, 0, width, height);
        playerRun3 = sheet.crop(2*width, 0, width, height);
        playerRun4 = sheet.crop(3*width, 0, width, height);
        playerRun5 = sheet.crop(0, height, width, height);
        playerRun6 = sheet.crop(width, height, width, height);
        playerRun7 = sheet.crop(2*width, height, width, height);
        playerRun8 = sheet.crop(3*width, height, width, height);
    }
}