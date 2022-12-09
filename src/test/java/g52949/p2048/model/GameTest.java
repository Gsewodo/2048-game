package g52949.p2048.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * test of Game
 *
 * 
 */
public class GameTest {

    private Board board = new Board();

    private Game game = new Game(board);

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        game.getBoard().setSquares((new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        }));
        System.out.println("getBoard");
        Board instance = game.getBoard();
        Board expResult = game.getBoard();
        Board result = game.getBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of newSquareValue method, of class Game.
     */
    @Test
    public void testNewSquareValue() {
        System.out.println("newSquareValue");
        int instance = game.newSquareValue();
        assertTrue(instance == 2 || instance == 4);

    }

    /**
     * Test of is win method (when true), of class Game.
     */
    @Test
    public void testIsWinFalse() {

        game.getBoard().setSquares((new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        }));
        System.out.println("isWin when it's false");
        Board instance = game.getBoard();
        boolean expResult = false;
        boolean result = game.isWin();
        assertEquals(expResult, result);

    }

    /**
     * Test of is win method (when true), of class Game.
     */
    @Test
    public void testIsWinTrue() {

        game.getBoard().setSquares((new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(2048), new Square(4), new Square(8)}
        }));
        System.out.println("isWin when it's true");
        Board instance = game.getBoard();
        boolean expResult = true;
        boolean result = game.isWin();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameOver method (when true), of class Game.
     */
    @Test
    public void testisGameOverTrue() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        });
        System.out.println("isGameOver when it's true");
        Board instance = game.getBoard();
        boolean expResult = true;
        boolean result = game.isGameOver();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameOver method (when false), of class Game.
     */
    @Test
    public void testisGameOverFalse22() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(2), new Square(4), new Square(8)}
        });
        System.out.println("isGameOver when it's false");
        Board instance = game.getBoard();
        boolean expResult = false;
        boolean result = game.isGameOver();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameOver method (when false because a 0), of class Game.
     */
    @Test
    public void testisGameOverFalseHasA0() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(0), new Square(4), new Square(8)}
        });
        System.out.println("isGameOver when it's false because a 0");
        Board instance = game.getBoard();
        boolean expResult = false;
        boolean result = game.isGameOver();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameProgress method (when false), of class Game.
     */
    @Test
    public void testIsGameInProgressFalseWin() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(2048), new Square(4), new Square(8)}
        });
        System.out.println("IsGameInProgress when false because we win");
        Board instance = game.getBoard();
        boolean expResult = false;
        boolean result = game.isGameInProgress();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameProgress method (when false), of class Game.
     */
    @Test
    public void testIsGameInProgressFalseLose() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        });
        System.out.println("IsGameInProgress when false because we Lose");
        Board instance = game.getBoard();
        boolean expResult = false;
        boolean result = game.isGameInProgress();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameProgress method (when true), of class Game.
     */
    @Test
    public void testIsGameInProgressTrue44() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(4), new Square(4), new Square(8)}
        });
        System.out.println("IsGameInProgress when true");
        Board instance = game.getBoard();
        boolean expResult = true;
        boolean result = game.isGameInProgress();
        assertEquals(expResult, result);

    }

    /**
     * Test of isGameProgress method (when true), of class Game.
     */
    @Test
    public void testIsGameInProgressTrue0() {

        game.getBoard().setSquares(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(8), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(), new Square(4), new Square(8)}
        });
        System.out.println("IsGameInProgress when true because square value 0");
        Board instance = game.getBoard();
        boolean expResult = true;
        boolean result = game.isGameInProgress();
        assertEquals(expResult, result);

    }

    /**
     * Test of move method ( direction DOWN), of class Game.
     */
    @Test
    public void testMoveDirectionDown() {
        game.getBoard().setSquares(new Square[][]{
            {new Square(128), new Square(4), new Square(0), new Square(8)},
            {new Square(0), new Square(0), new Square(0), new Square(0)},
            {new Square(128), new Square(8), new Square(1024), new Square(8)},
            {new Square(0), new Square(0), new Square(1024), new Square(8)}
        });

        System.out.println("moveDirectionDown");
        Direction direction = Direction.DOWN;
        Board instance = game.getBoard();
        game.move(direction);

        int exeptResult30 = 256;
        int Result30 = instance.getSquares()[3][0].getValue();
        assertEquals(exeptResult30, Result30);

        int exeptResult31 = 8;
        int Result31 = instance.getSquares()[3][1].getValue();
        assertEquals(exeptResult31, Result31);

        int exeptResult21 = 4;
        int Result21 = instance.getSquares()[2][1].getValue();
        assertEquals(exeptResult21, Result21);

        int exeptResult32 = 2048;
        int Result32 = instance.getSquares()[3][2].getValue();
        assertEquals(exeptResult32, Result32);

        int exeptResult33 = 16;
        int Result33 = instance.getSquares()[3][3].getValue();
        assertEquals(exeptResult33, Result33);

        int exeptResult23 = 8;
        int Result23 = instance.getSquares()[2][3].getValue();
        assertEquals(exeptResult23, Result23);
    }

    /**
     * Test of move method ( direction UP), of class Game.
     */
    @Test
    public void testMoveDirectionUP() {
        game.getBoard().setSquares(new Square[][]{
            {new Square(8), new Square(4), new Square(0), new Square(8)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(8), new Square(8), new Square(2), new Square(8)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDirectionUp");
        Direction direction = Direction.UP;
        Board instance = game.getBoard();
        game.move(direction);

        int exeptResult00 = 16;
        int Result00 = instance.getSquares()[0][0].getValue();
        assertEquals(exeptResult00, Result00);

        int exeptResult01 = 4;
        int Result01 = instance.getSquares()[0][1].getValue();
        assertEquals(exeptResult01, Result01);

        int exeptResult11 = 8;
        int Result11 = instance.getSquares()[1][1].getValue();
        assertEquals(exeptResult11, Result11);

        int exeptResult02 = 4;
        int Result02 = instance.getSquares()[0][2].getValue();
        assertEquals(exeptResult02, Result02);

        int exeptResult03 = 16;
        int Result03 = instance.getSquares()[0][3].getValue();
        assertEquals(exeptResult03, Result03);

        int exeptResult13 = 8;
        int Result13 = instance.getSquares()[1][3].getValue();
        assertEquals(exeptResult13, Result13);
    }

    /**
     * Test of move method (to the direction right), of class Game.
     */
    @Test
    public void testMoveDirectionRight() {
        game.getBoard().setSquares(new Square[][]{
            {new Square(8), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(4), new Square(4), new Square(0)},
            {new Square(8), new Square(8), new Square(2), new Square(2)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDirectionRight");
        Direction direction = Direction.RIGHT;
        Board instance = game.getBoard();
        game.move(direction);

        int exeptResult03 = 16;
        int Result03 = instance.getSquares()[0][3].getValue();
        assertEquals(exeptResult03, Result03);

        int exeptResult13 = 8;
        int Result13 = instance.getSquares()[1][3].getValue();
        assertEquals(exeptResult13, Result13);

        int exeptResult23 = 4;
        int Result23 = instance.getSquares()[2][3].getValue();
        assertEquals(exeptResult23, Result23);

        int exeptResult22 = 16;
        int Result22 = instance.getSquares()[2][2].getValue();
        assertEquals(exeptResult22, Result22);

        int exeptResult33 = 8;
        int Result33 = instance.getSquares()[3][3].getValue();
        assertEquals(exeptResult33, Result33);
    }

    /**
     * Test of move method (to the direction left), of class Game.
     */
    @Test
    public void testMoveDirectionLeft() {
        game.getBoard().setSquares(new Square[][]{
            {new Square(8), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(4), new Square(4), new Square(0)},
            {new Square(8), new Square(8), new Square(2), new Square(2)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDirectionLeft");
        Direction direction = Direction.LEFT;
        Board instance = game.getBoard();
        game.move(direction);

        int exeptResult00 = 16;
        int Result00 = instance.getSquares()[0][0].getValue();
        assertEquals(exeptResult00, Result00);

        int exeptResult10 = 8;
        int Result10 = instance.getSquares()[1][0].getValue();
        assertEquals(exeptResult10, Result10);

        int exeptResult20 = 16;
        int Result20 = instance.getSquares()[2][0].getValue();
        assertEquals(exeptResult20, Result20);

        int exeptResult21 = 4;
        int Result21 = instance.getSquares()[2][1].getValue();
        assertEquals(exeptResult21, Result21);

        int exeptResult30 = 8;
        int Result30 = instance.getSquares()[3][0].getValue();
        assertEquals(exeptResult30, Result30);
    }

}
