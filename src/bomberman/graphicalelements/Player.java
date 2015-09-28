package bomberman.graphicalelements;

import bomberman.graphicalelements.tiles.Empty;
import bomberman.graphicalelements.tiles.Tile;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Player implements GraphicalElement {

    private Board board;

    private Empty tile;

    private Color color;

    private Image sprite;

    public Player(Board board, Empty tile, Color color) {
        this.board = board;
        this.tile = tile;
        tile.setPlayer(this);
        this.color = color;
        this.sprite = Tool.getImage("/res/player.png");
    }

    public boolean move(int xDir, int yDir) {
        Tile target = board.getTile(tile.getX() + xDir, tile.getY() + yDir);
        if (target != null && target instanceof Empty && !((Empty) target).hasBomb()) {
            tile.setPlayer(null);
            tile = (Empty) target;
            tile.setPlayer(this);
            return true;
        }
        return false;
    }

    public boolean placeBomb() {
        if (!tile.hasBomb()) {
            tile.setBomb(new Bomb(tile));
            return true;
        }
        return false;
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        sprite.draw(xOffset, yOffset, 64, 64, color);
    }

    @Override
    public String toString() {
        return "Player " + color + " on tile " + tile;
    }

}
