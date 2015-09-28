package bomberman.graphicalelements;

import bomberman.graphicalelements.tiles.Empty;
import bomberman.graphicalelements.tiles.Tile;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import tools.Tool;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Player implements GraphicalElement {

    private Board board;

    private Empty tile;

    private Empty target;

    private double x, y;

    private double speed;

    private Color color;

    private Image sprite;

    private int lives;

    private int invincibility;

    public Player(Board board, Empty tile, Color color) {
        this.board = board;
        this.tile = tile;
        this.target = tile;
        this.x = tile.getX();
        this.y = tile.getY();
        this.speed = 0.005;
        tile.setPlayer(this);
        this.color = color;
        this.sprite = Tool.getImage("/res/player.png");
        this.lives = 3;
        this.invincibility = 1000;
    }

    public boolean move(int xDir, int yDir) {
        Tile target = board.getTile(tile.getX() + xDir, tile.getY() + yDir);
        if (target != null && target instanceof Empty && !((Empty) target).hasBomb()) {
            this.target = (Empty)target;
            return true;
        }
        return false;
    }

    public void land() {
        tile.setPlayer(null);
        tile = target;
        tile.setPlayer(this);
        x = tile.getX();
        y = tile.getY();
        if (tile.isExploding() && invincibility <= 0) {
            explode();
        }
    }

    public boolean placeBomb() {
        if (!tile.hasBomb()) {
            tile.setBomb(new Bomb(tile));
            return true;
        }
        return false;
    }

    public void explode() {
        lives--;
        invincibility = 3000;
        if (lives <= 0) {
            System.exit(0);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (invincibility > 0) {
            invincibility -= delta;
        }
        x += (target.getX() - tile.getX()) * speed * delta;
        y += (target.getY() - tile.getY()) * speed * delta;
        if (Math.abs(target.getX() - x) < speed && Math.abs(target.getY() - y) < speed) {
            land();
        }
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics, int xOffset, int yOffset) throws SlickException {
        if (invincibility > 0) {
            sprite.draw((float) (xOffset + x * 64), (float)(yOffset + y * 64), 64, 64, color.multiply(new Color(1, 1, 1, 0.5f)));
        }
        else {
            sprite.draw((float) (xOffset + x * 64), (float)(yOffset + y * 64), 64, 64, color);
        }
    }

    @Override
    public String toString() {
        return "Player " + color + " on tile " + tile;
    }

}
