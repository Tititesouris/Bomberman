package bomberman.graphicalelements.Items;

import bomberman.graphicalelements.tiles.Empty;
import tools.Tool;

/**
 * Created by Tititesouris on 28/09/2015.
 */
public class Bomb extends Item {

    public Bomb(Empty tile) {
        super(tile, Tool.getImage("/res/bomb.png"));
    }

    @Override
    public void pickUp() {

    }

}
