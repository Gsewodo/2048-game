package g52949.p2048.controller;

import g52949.p2048.model.Direction;
import g52949.p2048.model.Model;
import g52949.p2048.view.InterfaceView;
import java.util.Objects;

/**
 * Controller is responsible for the dynamics of the game and updating the view
 * as the game progresses.
 *
 * 
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * constructor of Controller
     *
     * @param game
     * @param view
     */
    public Controller(Model game, InterfaceView view) {
        Objects.requireNonNull(game, "game can't be null ");
        Objects.requireNonNull(view, "view can't be null ");
        this.game = game;
        this.view = view;
    }

    /**
     * start the game
     */
    public void startGame() {
        game.getInitialBoard();
        view.displayBoard(game.getBoard());

        while (game.isGameInProgress()) {
            try {
                Direction direction = view.askDirection();

                if (game.move(direction)) {
                    game.generateNewSquare();
                }
                view.displayBoard(game.getBoard());
            } catch (Exception e) {
                view.displayError("invalid entry");
            }
        }
        if (game.isWin()) {
            view.displayWin();

        }
        if (game.isGameOver()) {
            view.displayLose();
        }

    }
}
