package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.GraphicalElement;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public abstract class Tile implements GraphicalElement {

    protected int x, y;

    private Image sprite;

    public Tile(int x, int y, Image sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public abstract void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException;

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        sprite.draw(xOffset + x * 64, yOffset + y * 64, 64, 64);
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

}
