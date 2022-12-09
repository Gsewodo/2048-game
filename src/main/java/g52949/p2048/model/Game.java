package g52949.p2048.model;

import static g52949.p2048.model.GameStatus.*;
import g52949.p2048.view.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * Represents the class of game which acts like an facade to the view.
 */
public class Game implements Model {

    private Board board;
    private List<Observer> observers;
    private GameStatus gameStatus;

    public Game() {
        this.observers = new ArrayList<>();
        this.gameStatus = IN_PROGRESS;
    }

    /**
     * constructor of Game
     *
     * @param board
     */
    public Game(Board board) {
        Objects.requireNonNull(board, "board can't be null ");
        this.board = board;
        this.observers = new ArrayList<>();
        this.gameStatus = IN_PROGRESS;
    }

    /**
     * setter of board
     *
     * @param board the board of game
     */
    public void setBoard(Board board) {
        Objects.requireNonNull(board, "board can't be null ");
        this.board = board;
    }

    /**
     * getter of board
     *
     * @return the board
     */
    @Override
    public Board getBoard() {
        return this.board;
    }

    /**
     * creates a initial Board where a square value is 2 or 4 and the other are
     * empty (the board before start playing)
     *
     */
    @Override
    public Board getInitialBoard() {
        board = new Board();
        this.generateNewSquare();
        board.setSquares(board.getSquares());
        return board;
    }

    /**
     * Generate the number 2 or 4.
     *
     * @return number 2 or 4.
     */
    public int newSquareValue() {
        Random random = new Random();
        int randomValue = random.nextInt(10) > 9 ? 4 : 2;
        return randomValue;
    }

    /**
     * checks if the user has won in other words if the Board has a square which
     * is worth 2048
     *
     * @return true if there is false otherwise
     */
    @Override
    public boolean isWin() {
        boolean isWin = false;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {

                if (board.getSquares()[i][j].is2048()) {
                    return true;
                }
            }
        }

        if (isWin) {
            this.gameStatus = WIN;
            notifyObservers();
        }
        return false;
    }

    /**
     * checks if the user has lose
     *
     * @return true if there is false otherwise
     */
    @Override
    public boolean isGameOver() {
        boolean isGameOver = !board.boardHasEmptySquare() && !board.boardHasEqualsNeighbour();
        if (isGameOver) {
            this.gameStatus = GAME_OVER;
            notifyObservers();
        }
        return isGameOver;
    }

    /**
     * checks if the game is on progress
     *
     * @return true if there is false otherwise
     */
    @Override
    public boolean isGameInProgress() {
        return !this.isWin() && (this.board.boardHasEmptySquare() || this.board.boardHasEqualsNeighbour());
    }

    /**
     * restarts the game
     */
    @Override
    public void retry() {
        this.board = getInitialBoard();
        this.gameStatus = IN_PROGRESS;
        notifyObservers();
    }

    /**
     * moves all squares that are not empty in the direction given if the
     * movement is allowed ( it depends on values of square and next square
     * values.)
     *
     * @param direction .
     * @return true if some squares of the board moved
     */
    @Override
    public boolean move(Direction direction) {
        Objects.requireNonNull(direction, "direction can't be null ");
        boolean moved = false;
        if ("LEFT".equals(direction.toString()) || "UP".equals(direction.toString())) {
            for (int row = 0; row < board.getSize(); row++) {
                for (int column = 0; column < board.getSize(); column++) {

                    if (!board.getSquares()[row][column].isEmpty()) {
                        switch (direction) {

                            case LEFT:
                                moved = board.moveLeft(row, column);
                                break;
                            case UP:
                                moved = board.moveUp(row, column);
                                break;
                            default:
                                break;
                        }

                    }
                }
            }
        } else if ("RIGHT".equals(direction.toString()) || "DOWN".equals(direction.toString())) {

            for (int row = board.getSize() - 1; row >= 0; row--) {
                for (int column = board.getSize() - 1; column >= 0; column--) {

                    if (!board.getSquares()[row][column].isEmpty()) {
                        switch (direction) {
                            case RIGHT:
                                moved = board.moveRight(row, column);
                                break;
                            case DOWN:
                                moved = board.moveDown(row, column);
                                break;

                            default:
                                break;
                        }

                    }
                }
            }

        }
        if (!board.boardHasEqualsNeighbour()) {
            if (this.gameStatus != GAME_OVER) {
                this.gameStatus = IMPOSSIBLE_MOVEMENT;
            }
        } else {
            this.gameStatus = IN_PROGRESS;
        }
        this.generateNewSquare();
        notifyObservers();
        return moved;
    }

    /**
     * generate a new square in the board with a value (2 or 4)
     *
     * @return
     */
    @Override
    public boolean generateNewSquare() {
        if (!(board.boardHasEmptySquare())) {
            return false;
        }

        Random random = new Random();
        while (true) {

            int row = random.nextInt(board.getSize());
            int column = random.nextInt(board.getSize());

            if (board.getSquares()[row][column].isEmpty()) {

                board.getSquares()[row][column].setValue(this.newSquareValue());
                return true;

            }

        }
    }

    /**
     * add a observer to game
     *
     * @param observer
     */
    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     *notify all the observers of game 
     */
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.board);
            observer.updateGameStatus(this.gameStatus);

        }

    }

}
