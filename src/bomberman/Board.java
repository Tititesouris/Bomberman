package bomberman;

import bomberman.tiles.Empty;
import bomberman.tiles.Obstacle;
import bomberman.tiles.Tile;
import bomberman.tiles.Wall;
import org.newdawn.slick.Color;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Board {

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

}
