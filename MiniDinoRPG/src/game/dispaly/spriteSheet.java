package game.dispaly;
import java.awt.image.BufferedImage;

public class spriteSheet {

    private BufferedImage sheet;

    public spriteSheet(BufferedImage sheet){
        this.sheet=sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }
}