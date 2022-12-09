package g52949.p2048.model;

import java.util.Objects;

/**
 * Square on the board. A square has a value(number). value of zero implies an
 * empty tile. A square doesn’t know where it is on the board.
 *
 *
 *
 */
public class Square {

    private int value;

    /**
     * constructor of Square. initialize square with a value of 0 (empty)
     */
    public Square() {
        this.value = 0;
    }

    /**
     * constructor of Square. Instantiate square with a specific value.
     *
     * @param value a given number
     */
    public Square(int value) {
        this.value = value;
    }

    /**
     * set the value of value
     *
     * @param value a new specific value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * getter of value
     *
     * @return the value of value
     */
    public int getValue() {
        return value;
    }

    /**
     * Two squares have the same value.
     *
     * @param square
     * @return true if two squares are equal, false otherwise
     */
    public boolean equals(Square square) {
        Objects.requireNonNull(square, "square can't be null ");
        return square.getValue() == this.getValue();
    }

    /**
     * checks if the value of the square is 2048
     *
     * @return true if it is , false otherwise
     */
    public boolean is2048() {
        return this.value == 2048;
    }

    /**
     * Add the value of this square by the value of the square in the parameter.
     *
     * @param square
     */
    public void merge(Square square) {
        Objects.requireNonNull(square, "square can't be null ");
        this.setValue(this.value + square.getValue());

    }

    /**
     * Set the value to zero. In other words empty the square.
     *
     */
    public void clear() {
        this.setValue(0);
    }

    /**
     * checks if the square is empty.
     *
     * @return
     */
    public boolean isEmpty() {
        return this.value == 0;
    }
}
