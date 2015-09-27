package bomberman.graphicalelements;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public interface GraphicalElement {

    void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

    void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException;

}
