package bomberman;

import bomberman.graphicalelements.Board;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Game extends BasicGameState {

    private Board board;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        board = new Board(13, 13);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_W)) {
            board.getPlayer().move(0, -1);
        }
        else if (gameContainer.getInput().isKeyDown(Input.KEY_A)) {
            board.getPlayer().move(-1, 0);
        }
        else if (gameContainer.getInput().isKeyDown(Input.KEY_S)) {
            board.getPlayer().move(0, 1);
        }
        else if (gameContainer.getInput().isKeyDown(Input.KEY_D)) {
            board.getPlayer().move(1, 0);
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
            board.getPlayer().placeBomb();
        }
        board.update(gameContainer, stateBasedGame, delta);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        board.render(gameContainer, stateBasedGame, graphics, 10, 10);
    }

    @Override
    public int getID() {
        return 0;
    }

}
