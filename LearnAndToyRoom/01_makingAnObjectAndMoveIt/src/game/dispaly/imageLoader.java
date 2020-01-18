package game.dispaly;

import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;

public class imageLoader {
    
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(imageLoader.class.getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}