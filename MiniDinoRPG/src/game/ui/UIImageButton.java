package game.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage image;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage image, ClickListener clicker) {//buffered image array for hovering effect 
        super(x, y, width, height);
        this.image = image;
        this.clicker = clicker;
    }


    @Override
    public void render(Graphics g) {
        /*
        if (hovering) {
            g.drawImage(iamge[i], (int) x, (int) y, height, width);
        } else {
            g.drawImage(image[i], (int) x, (int) y, height, width);
        }*/ 
        g.drawImage(image, (int) x, (int) y, height, width, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

    
    @Override
    public void update() {

    }

 
    
}