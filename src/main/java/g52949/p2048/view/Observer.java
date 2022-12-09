package g52949.p2048.view;

import g52949.p2048.model.Board;
import g52949.p2048.model.GameStatus;

/**
 *
 * 
 */
public interface Observer {

    void update(Board board);

    void updateGameStatus(GameStatus gameStatus);

}
