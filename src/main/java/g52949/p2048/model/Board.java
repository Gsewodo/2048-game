package g52949.p2048.model;

import java.util.Objects;

/**
 * Board is constituted by squares (null if there are not). The Board contains n
 * x n square. squares with a value of zero implies an empty square.
 *
 * 
 */
public class Board {

    private static final int SIZE = 4;

    private Square[][] squares = new Square[SIZE][SIZE];

    /**
     * Instantiate n x n Board with empty squares (all zero values).
     */
    public Board() {
        for (int i = 0; i < this.squares[0].length; i++) {
            for (int j = 0; j < this.squares.length; j++) {
                squares[i][j] = new Square();
            }

        }
    }

    /**
     * constructor of Board
     *
     * @param square
     */
    Board(Square[][] square) {
        Objects.requireNonNull(square, "square can't be null ");
        this.squares = square;
    }

    /**
     * getter of SIZE
     *
     * @return SIZE the size of the board
     */
    public int getSize() {
        return SIZE;
    }

    /**
     * send an error message if the value are not between number1 and number1
     *
     * @param value
     * @param min
     * @param max
     */
    public static void betweenMinAndMax(int value, int min, int max) {
        if (value < min && value > max) {
            throw new IllegalArgumentException("value must be between min and max " + min + " et " + max);
        }

    }

    /**
     * gives the value at position row column
     *
     * @param row
     * @param column
     * @return the value at position row column
     */
    public int getValueAt(int row, int column) {
        betweenMinAndMax(row, 0, 3);
        betweenMinAndMax(column, 0, 3);
        return this.squares[row][column].getValue();
    }

    /**
     * getter of Squares
     *
     * @return squares
     */
    public Square[][] getSquares() {
        return this.squares;
    }

    /**
     * setter of squares
     *
     * @param squares
     */
    public void setSquares(Square[][] squares) {
        Objects.requireNonNull(squares, "squares can't be null ");
        this.squares = squares;
    }

    /**
     * checks if the Board has an empty square (value of 0)
     *
     * @return true if there is false otherwise
     */
    public boolean boardHasEmptySquare() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (this.squares[i][j].isEmpty()) {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * checks if the Board has a square that has an equal square as a neighbour
     *
     * @return true if a square of the Board has an equals neighbour
     * square,false otherwise
     */
    public boolean boardHasEqualsNeighbour() {

        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (row < SIZE - 1) {

                    if (squares[row][column].equals(squares[row + 1][column])) {
                        return true;
                    }

                }
                if (column < SIZE - 1) {

                    if (squares[row][column].equals(squares[row][column + 1])) {
                        return true;
                    }

                }

            }
        }

        return false;
    }

    /**
     * moves up all squares that are not empty if the movement is allowed ( it
     * depends on values of square and next square values.)
     *
     * @param row
     * @param column
     * @return true if the square in [row][column] position on board moved
     */
    public boolean moveUp(int row, int column) {
        betweenMinAndMax(row, 0, 3);
        betweenMinAndMax(column, 0, 3);
        boolean moved = false;
        boolean insideBoard = row - 1 >= 0;
        while (insideBoard && this.squares[row - 1][column].isEmpty()) {
            this.squares[row - 1][column].merge(this.squares[row][column]);
            this.squares[row][column].clear();
            row--;
            insideBoard = row - 1 >= 0;
            moved = true;
        }

        if (insideBoard && this.squares[row - 1][column].equals(this.squares[row][column])) {
            this.squares[row - 1][column].merge(this.squares[row][column]);
            this.squares[row][column].clear();
            moved = true;
        }
        return moved;
    }

    /**
     * moves down all squares that are not empty if the movement is allowed ( it
     * depends on values of square and next square values.)
     *
     * @param row
     * @param column
     * @return true if the square in [row][column] position on board moved
     */
    public boolean moveDown(int row, int column) {
        betweenMinAndMax(row, 0, 3);
        betweenMinAndMax(column, 0, 3);
        boolean moved = false;
        boolean insideBoard = row + 1 < SIZE;

        while (insideBoard && squares[row + 1][column].isEmpty()) {
            squares[row + 1][column].merge(squares[row][column]);
            squares[row][column].clear();
            row++;
            insideBoard = row + 1 < SIZE;
            moved = true;
        }

        if (insideBoard && squares[row + 1][column].equals(squares[row][column])) {
            squares[row + 1][column].merge(squares[row][column]);
            squares[row][column].clear();
            moved = true;
        }
        return moved;
    }

    /**
     * moves all squares that are not empty to the left if the movement is
     * allowed ( it depends on values of square and next square values.)
     *
     * @param row
     * @param column
     * @return true if the square in [row][column] position on board moved
     */
    public boolean moveLeft(int row, int column) {
        betweenMinAndMax(row, 0, 3);
        betweenMinAndMax(column, 0, 3);
        boolean moved = false;
        boolean insideBoard = column - 1 >= 0;
        while (insideBoard && (this.squares[row][column - 1].isEmpty())) {
            this.squares[row][column - 1].merge(this.squares[row][column]);
            this.squares[row][column].clear();
            column--;
            insideBoard = column - 1 >= 0;
            moved = true;
        }

        if (insideBoard && this.squares[row][column - 1].equals(this.squares[row][column])) {
            this.squares[row][column - 1].merge(this.squares[row][column]);
            this.squares[row][column].clear();
            moved = true;
        }
        return moved;
    }

    /**
     * moves all squares that are not empty to the right if the movement is
     * allowed ( it depends on values of square and next square values.)
     *
     * @param row
     * @param column
     * @return true if the square in [row][column] position on board moved
     */
    public boolean moveRight(int row, int column) {
        betweenMinAndMax(row, 0, 3);
        betweenMinAndMax(column, 0, 3);
        boolean moved = false;
        boolean insideBoard = column + 1 < SIZE;

        while (insideBoard && (squares[row][column + 1].isEmpty())) {
            squares[row][column + 1].merge(squares[row][column]);
            squares[row][column].clear();
            column++;
            insideBoard = column + 1 < SIZE;
            moved = true;
        }
        if (insideBoard && this.squares[row][column + 1].equals(this.squares[row][column])) {
            this.squares[row][column + 1].merge(this.squares[row][column]);
            this.squares[row][column].clear();
            moved = true;
        }
        return moved;
    }

}
