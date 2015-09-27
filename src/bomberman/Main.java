package bomberman;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by Tititesouris on 27/09/2015.
 */
public class Main extends StateBasedGame {

    public Main() {
        super("Bomberman!");
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new Main());
            app.setDisplayMode(1000, 1000, false);
            app.setAlwaysRender(true);
            app.setTargetFrameRate(60);
            app.setMinimumLogicUpdateInterval(10);
            app.start();
        }
        catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Game());
    }

}
