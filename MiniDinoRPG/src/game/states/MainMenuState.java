package game.states;

import java.awt.Graphics;

import game.Handler;
import game.dispaly.Assets;
import game.ui.ClickListener;
import game.ui.UIImageButton;
import game.ui.UIManager;
import java.awt.event.KeyEvent;

public class MainMenuState extends State {

    private UIManager uiManager;

    public MainMenuState(Handler handler){
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIImageButton(50, 50, 300, 500, Assets.startButton, new ClickListener(){
        
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(handler.getGame().gameState);
            }
        }));
    }

	@Override
    public void update() {
        uiManager.update();

        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)){
            State.setState(handler.getGame().gameState);
        }

        // test and debug 
        /*System.out.print(handler.getMouseManager().getMouseX() + " ");
        System.out.println(handler.getMouseManager().getMouseY());
        if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed()){
             State.setState(handler.getGame().gameState);
        }*/
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
        // test and debug
        /*g.setColor(Color.red);
        g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 5, 5);*/

    }

    
}