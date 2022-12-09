package g52949.p2048.view;

import g52949.p2048.model.Board;
import javafx.scene.layout.GridPane;

/**
 * displays the board of game
 *
 * 
 */
public class BoardView extends GridPane {

    private Board board;

    /**
     * constructor of BoardView
     *
     * @param board
     */
    public BoardView(Board board) {
        this.createBoard(board);
    }

    /**
     * create a visual board 
     * @param board 
     */
    public void createBoard(Board board) {
        this.board = board;

        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {

                SquareView squareView = new SquareView(column, row, board.getValueAt(row, column));
                this.add(squareView, column, row);
            }

        }

    }

}
