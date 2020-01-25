package game.dispaly;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    //the size of the window 
    public Display(String title, int width, int height){
        this.title=title;
        this.width=width;
        this.height=height;

        createDisplay(); 
    }

    // creates the window 
    private void createDisplay(){               // init frame and canvas
        frame = new JFrame(title);              // init frame for canvas
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // proper close on the X
        // optional 
        frame.setResizable(false);              // self explanatory
        frame.setLocationRelativeTo(null);      // pup up in center
        frame.setVisible(true);                 // default is false
    
        canvas = new Canvas();                  // init canvas in frame
        canvas.setPreferredSize(new Dimension(width, height));  // canvas takes Dimensions as inputs, not just width and height.
                                                                // canvas.setMinimumSize(width, height) wouldn't work
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        //need this for other computers (?)
        canvas.setFocusable(false); //  read up on this

        frame.add(canvas);
        frame.pack();   // resizes the window a little so the full canvas is dispalyed
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}