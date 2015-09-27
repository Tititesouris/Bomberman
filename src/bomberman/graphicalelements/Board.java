package bomberman.graphicalelements;

import bomberman.graphicalelements.tiles.Empty;
import bomberman.graphicalelements.tiles.Obstacle;
import bomberman.graphicalelements.tiles.Tile;
import bomberman.graphicalelements.tiles.Wall;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Board implements GraphicalElement {

    private Tile[][] tiles;

    private Player[] players;

    public Board(int width, int height) {
        tiles = new Tile[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x % 2 == 1 && y % 2 == 1) {
                    tiles[y][x] = new Wall(x, y);
                }
                else if (x <= 1 && y <= 1 || width - 2 <= x && height - 2 <= y) {
                    tiles[y][x] = new Empty(x, y);
                }
                else {
                    tiles[y][x] = new Obstacle(x, y);
                }
            }
        }

        players = new Player[2];
        players[0] = new Player(tiles[0][0], new Color(255, 0, 0));
        players[1] = new Player(tiles[width - 1][height - 1], new Color(0, 0, 255));
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                tiles[y][x].render(gameContainer, stateBasedGame, graphics, xOffset, yOffset);
            }
        }
    }

}
