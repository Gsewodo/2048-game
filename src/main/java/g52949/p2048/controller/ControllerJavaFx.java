package g52949.p2048.controller;

import g52949.p2048.model.Direction;
import g52949.p2048.model.Model;
import g52949.p2048.view.MainView;
import java.util.Objects;
import javafx.scene.input.KeyEvent;

/**
 * ControllerJavaFx is responsible for the dynamics of the game and javaFx view
 *
 * 
 */
public class ControllerJavaFx {

    private Model game;
    private MainView view;

    /**
     * constructor of ControllerJavaFx
     *
     * @param game
     * @param view
     */
    public ControllerJavaFx(Model game, MainView view) {
        Objects.requireNonNull(game, "game can't be null ");
        Objects.requireNonNull(view, "view can't be null ");
        this.game = game;
        this.view = view;

    }

    /**
     * moves the value of the board according to the keyboard direction.
     *
     * @param keyEvent a event
     */
    public void keyBoardDirection(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case RIGHT:
                game.move(Direction.RIGHT);
                break;
            case LEFT:
                game.move(Direction.LEFT);
                break;
            case UP:
                game.move(Direction.UP);
                break;
            case DOWN:
                game.move(Direction.DOWN);
                break;
        }

    }

    /**
     * starts the game
     */
    public void startGame() {
        game.register(view);
        view.setController(this);
        view.start(game);
        this.view.requestFocus();

    }

    /**
     * restarts the game
     */
    public void retry() {
        this.game.retry();
        this.view.requestFocus();
    }
}
