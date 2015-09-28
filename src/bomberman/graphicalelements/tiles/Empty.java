package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.Items.Bomb;
import bomberman.graphicalelements.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Empty extends Tile {

    private Player player;

    private Bomb bomb;

    public Empty(int x, int y) {
        super(x, y, Tool.getImage("/res/empty.png"));
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

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (hasPlayer()) {
            player.update(gameContainer, stateBasedGame, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        super.render(gameContainer, stateBasedGame, graphics, xOffset, yOffset);
        if (hasBomb()) {
            bomb.render(gameContainer, stateBasedGame, graphics, xOffset + x * 64, yOffset + y * 64);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Empty";
    }

}
