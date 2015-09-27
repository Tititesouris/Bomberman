package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.GraphicalElement;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Tile implements GraphicalElement {

    private int x, y;

    private Image sprite;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = Tool.getImage("/res/bomb.png");
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        sprite.draw(xOffset + x * 64, yOffset + y * 64, 64, 64);
    }

}
