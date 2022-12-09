package g52949.p2048.model;

/**
 * Represents a interface of Model that implements the class of game.
 *
 *
 */
public interface Model extends Observable{

    public Board getBoard();

    public boolean generateNewSquare();

    public Board getInitialBoard();

    public boolean isWin();

    public boolean isGameOver();

    public boolean isGameInProgress();

    public boolean move(Direction direction);
    public void retry();
}
