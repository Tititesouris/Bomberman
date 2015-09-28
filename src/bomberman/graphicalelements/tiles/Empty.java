package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.Board;
import bomberman.graphicalelements.Bomb;
import bomberman.graphicalelements.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Empty extends Tile {

    private Player player;

    private Bomb bomb;

    protected int explosion;

    private Image explosionSprite;

    public Empty(Board board, int x, int y) {
        super(board, x, y, Tool.getImage("/res/empty.png"));
        this.explosionSprite = Tool.getImage("/res/explosion.png");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean hasPlayer() {
        return player != null;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void setBomb(Bomb bomb) {
        this.bomb = bomb;
    }

    public boolean hasBomb() {
        return bomb != null;
    }

    public boolean isExploding() {
        return explosion > 0;
    }

    public void explode(int range, int xDir, int yDir) {
        bomb = null;
        explosion = 2000;
        if (range > 0) {
            Tile tile = board.getTile(x + xDir, y + yDir);
            if (tile != null && tile instanceof Empty) {
                ((Empty) tile).explode(range - 1, xDir, yDir);
            }
        }
    }

    public void explode() {
        bomb = null;
        explosion = 2000;
        for (Tile tile : getNeighbors()) {
            if (tile != null) {
                if (tile instanceof Empty) {
                    if (((Empty) tile).hasBomb()) {
                        ((Empty) tile).explode();
                    }
                    else {
                        ((Empty) tile).explode(0, tile.x - x, tile.y - y);
                    }
                }
                else if (tile instanceof Obstacle) {
                    board.explode(tile.x, tile.y);
                }
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (explosion > 0) {
            explosion -= delta;
        }
        if (hasBomb()) {
            bomb.update(gameContainer, stateBasedGame, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics, xOffset, yOffset);
        if (hasBomb()) {
            bomb.render(gameContainer, stateBasedGame, graphics, xOffset + x * 64, yOffset + y * 64);
        }
        if (explosion > 0) {
            explosionSprite.draw(xOffset + x * 64, yOffset + y * 64, 64, 64);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Empty";
    }

}
