package bomberman.graphicalelements;

import bomberman.graphicalelements.tiles.Empty;
import bomberman.graphicalelements.tiles.Obstacle;
import bomberman.graphicalelements.tiles.Tile;
import bomberman.graphicalelements.tiles.Wall;
import org.newdawn.slick.*;
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
                    tiles[y][x] = new Wall(this, x, y);
                }
                else if (x <= 1 && y <= 1 || width - 2 <= x && height - 2 <= y) {
                    tiles[y][x] = new Empty(this, x, y);
                }
                else {
                    tiles[y][x] = new Obstacle(this, x, y);
                }
            }
        }

        players = new Player[2];
        players[0] = new Player(this, (Empty)tiles[0][0], new Color(255, 0, 0));
        players[1] = new Player(this, (Empty)tiles[height - 1][width - 1], new Color(0, 0, 255));
    }

    public Tile getTile(int x, int y) {
        try {
            return tiles[y][x];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public Player getPlayer() {
        return players[0];
    }

    public void explode(int x, int y) {
        tiles[y][x] = new Empty(this, x, y);
        ((Empty) tiles[y][x]).explode(0, 0, 0);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                tiles[y][x].update(gameContainer, stateBasedGame, delta);
            }
        }

        for (Player player : players) {
            player.update(gameContainer, stateBasedGame, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[y].length; x++) {
                tiles[y][x].render(gameContainer, stateBasedGame, graphics, xOffset, yOffset);
            }
        }

        for (Player player : players) {
            player.render(gameContainer, stateBasedGame, graphics, xOffset, yOffset);
        }
    }

}
