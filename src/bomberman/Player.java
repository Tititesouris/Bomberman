package bomberman;

import bomberman.tiles.Tile;
import org.newdawn.slick.Color;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Player {

    private Tile tile;

    private Color color;

    public Player(Tile tile, Color color) {
        this.tile = tile;
        this.color = color;
    }

}
