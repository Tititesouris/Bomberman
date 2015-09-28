package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.Board;
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
public abstract class Tile implements GraphicalElement {

    protected Board board;

    protected int x, y;

    protected int explosion;

    private Image sprite;

    public Tile(Board board, int x, int y, Image sprite) {
        this.board = board;
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

    public Tile[] getNeighbors() {
        Tile[] tiles = new Tile[4];
        tiles[0] = board.getTile(x - 1, y);
        tiles[1] = board.getTile(x + 1, y);
        tiles[2] = board.getTile(x, y - 1);
        tiles[3] = board.getTile(x, y + 1);
        return tiles;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        explosion -= delta;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        sprite.draw(xOffset + x * 64, yOffset + y * 64, 64, 64);
    }

    @Override
    public String toString() {
        return "X: " + x + ", Y: " + y;
    }

}
