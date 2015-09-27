package bomberman;

import bomberman.graphicalelements.Board;
import org.newdawn.slick.*;
import org.newdawn.slick.KeyListener;
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

        gameContainer.getInput().addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(int i, char c) {
                switch (c) {
                    case 'w':
                        board.getPlayer().move(0, -1);
                        break;
                    case 'a':
                        board.getPlayer().move(-1, 0);
                        break;
                    case 's':
                        board.getPlayer().move(0, 1);
                        break;
                    case 'd':
                        board.getPlayer().move(1, 0);
                        break;
                }
            }

            @Override
            public void keyReleased(int i, char c) {

            }

            @Override
            public void setInput(Input input) {

            }

            @Override
            public boolean isAcceptingInput() {
                return true;
            }

            @Override
            public void inputEnded() {

            }

            @Override
            public void inputStarted() {

            }
        });
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
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
