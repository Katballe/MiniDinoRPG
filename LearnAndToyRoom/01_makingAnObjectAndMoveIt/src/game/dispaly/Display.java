package game.dispaly;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;

        createDisplay(); 
    }

    private void createDisplay(){               // init frame and canvas
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // optional 
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);      // pup up in center
        frame.setVisible(true);                 // default is false
    
        Canvas canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();   // just to be sure everything is within the frame.
    }

    public Canvas getCanvas(){
        return canvas;
    }
}