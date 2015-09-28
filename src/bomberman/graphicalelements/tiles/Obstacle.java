package bomberman.graphicalelements.tiles;

import bomberman.graphicalelements.Board;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Obstacle extends Tile {

    public Obstacle(Board board, int x, int y) {
        super(board, x, y, Tool.getImage("/res/obstacle.png"));
    }

    @Override
    public String toString() {
        return super.toString() + " Obstacle";
    }

}
