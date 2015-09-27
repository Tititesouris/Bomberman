package bomberman;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Game extends BasicGameState {

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("Hello World!", 100, 100);
        try {
            Image image = Tool.getImage("/res/bomb.png");
            graphics.drawImage(image, 200, 200);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getID() {
        return 0;
    }

}
