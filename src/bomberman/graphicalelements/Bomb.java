package bomberman.graphicalelements;

import bomberman.graphicalelements.tiles.Empty;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 28/09/2015.
 */
public class Bomb implements GraphicalElement {

    private Empty tile;

    private int countdown;

    private Image sprite;

    public Bomb(Empty tile) {
        this.tile = tile;
        this.countdown = 3000;
        this.sprite = Tool.getImage("/res/bomb.png");
    }

    public void explode() {
        tile.explode();
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        countdown -= delta;
        if (countdown <= 0) {
            explode();
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        if (countdown <= 1000 && countdown / 50 % 2 == 0) {
            sprite.drawFlash(xOffset, yOffset, 64, 64);
        }
        else {
            sprite.draw(xOffset, yOffset, 64, 64);
        }
        //graphics.drawString("" + countdown / 1000, xOffset + 32, yOffset + 32);
    }

}
