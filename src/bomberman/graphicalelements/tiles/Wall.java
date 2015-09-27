package bomberman.graphicalelements.tiles;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Wall extends Tile {

    public Wall(int x, int y) {
        super(x, y, Tool.getImage("/res/wall.png"));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

    @Override
    public String toString() {
        return super.toString() + " Wall";
    }

}
