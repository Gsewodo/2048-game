package g52949.p2048.view;

import g52949.p2048.model.Board;
import g52949.p2048.model.Direction;
import java.util.Scanner;

/**
 * The view displays all elements of the game
 *
 * 
 */
public class View implements InterfaceView {

    /**
     * displays the Board given in parameter
     *
     * @param board the board
     */
    @Override
    public void displayBoard(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("There is no board");
        }
        System.out.println("-----" + "-----" + "-----" + "-----" + "-----");
        for (int row = 0; row < 4; row++) {
            System.out.print("|");
            for (int col = 0; col < 4; col++) {
                if (board.getSquares()[row][col].getValue() > 999) {
                    System.out.print(board.getSquares()[row][col].getValue() + " |");
                } else if (board.getSquares()[row][col].getValue() > 99) {
                    System.out.print(" " + board.getSquares()[row][col].getValue() + " " + "|");
                } else if (board.getSquares()[row][col].getValue() > 9) {
                    System.out.print("  " + board.getSquares()[row][col].getValue() + " " + "|");
                } else if (board.getSquares()[row][col].getValue() > 0) {
                    System.out.print("   " + board.getSquares()[row][col].getValue() + " " + "|");
                }
                if (board.getSquares()[row][col].isEmpty()) {
                    System.out.print("     " + "|");
                }
            }
            System.out.println();
            if (row < 3) {
                System.out.println("-----" + "-----" + "-----" + "-----" + "-----");
            }
        }
        System.out.println("-----" + "-----" + "-----" + "-----" + "-----");
    }

    /**
     * Ask the user to encode a Direction
     *
     * @return direction the Direction encoded
     */
    @Override
    public Direction askDirection() {
        Scanner kbd = new Scanner(System.in);
        System.out.println("enter a Direction : LEFT-RIGHT-UP-DOWN");
        String directionName = kbd.nextLine();
        directionName.toUpperCase();
        while (!Direction.UP.toString().equals(directionName.toUpperCase())
                && !Direction.DOWN.toString().equals(directionName.toUpperCase())
                && !Direction.LEFT.toString().equals(directionName.toUpperCase())
                && !Direction.RIGHT.toString().equals(directionName.toUpperCase())) {
            System.out.println("the direction given is not a direction ! try again");
            System.out.println("enter a Direction : LEFT-RIGHT-UP-DOWN");
            directionName = kbd.nextLine();
            directionName.toUpperCase();
        }
        Direction direction = Direction.valueOf(directionName.toUpperCase());

        return direction;
    }

    /**
     * displays game over when we lose
     */
    @Override
    public void displayLose() {
        System.out.println("GAME OVER");
    }

    /**
     * diplays you win when we win
     */
    @Override
    public void displayWin() {
        System.out.println("YOU WIN");
    }

    /**
     * diplays a error message
     *
     * @param message a message to display
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

}
