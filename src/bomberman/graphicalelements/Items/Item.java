package bomberman.graphicalelements.Items;

import bomberman.graphicalelements.GraphicalElement;
import bomberman.graphicalelements.tiles.Empty;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 28/09/2015.
 */
public abstract class Item implements GraphicalElement {

    protected Empty tile;

    protected Image sprite;

    public Item(Empty tile, Image sprite) {
        this.tile = tile;
        this.sprite = sprite;
    }

    public abstract void pickUp();

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        sprite.draw(xOffset, yOffset, 64, 64);
    }

}
