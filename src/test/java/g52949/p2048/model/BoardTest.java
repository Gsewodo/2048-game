package g52949.p2048.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * test of Board
 *
 * 
 */
public class BoardTest {

    //a nxn empty board 
    private Board board = new Board();

    /**
     * Test of GetSize method, of class Board.
     */
    @Test
    public void testGetSize() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });
        System.out.println("getSize");
        Board instance = this.board;
        int expResult = 4;
        int result = instance.getSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of BoardHasEmptySquare method(when its true), of class Board.
     */
    @Test
    public void testBoardHasEmptySquareTrue() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });
        System.out.println("BoardHasEmptySquareTrue");
        Board instance = this.board;
        boolean expResult = true;
        boolean result = instance.boardHasEmptySquare();
        assertEquals(expResult, result);

    }

    /**
     * Test of BoardHasEmptySquare method(when its false), of class Board.
     */
    @Test
    public void testBoardHasEmptySquareFalse() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(8)},
            {new Square(4), new Square(2), new Square(2), new Square(4)},
            {new Square(64), new Square(128), new Square(2), new Square(8)},
            {new Square(2), new Square(2048), new Square(4), new Square(8)}
        });
        System.out.println("BoardHasEmptySquare when it's False");
        Board instance = this.board;
        boolean expResult = false;
        boolean result = instance.boardHasEmptySquare();
        assertEquals(expResult, result);

    }

    /**
     * Test of boardHasEqualsNeighbour method (when False), of class Board.
     */
    @Test
    public void testBoardHasEqualsNeighbourFalse() {

        board = new Board(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(128), new Square(2), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        });
        System.out.println("BoardHasEqualsNeighbour when it's false");
        Board instance = this.board;
        boolean expResult = false;
        boolean result = instance.boardHasEqualsNeighbour();
        assertEquals(expResult, result);

    }

    /**
     * Test of boardHasEqualsNeighbour method (when true), of class Board.
     */
    @Test
    public void testBoardHasEqualsNeighbourTrue() {

        board = new Board(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(64), new Square(2), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        });
        System.out.println("BoardHasEqualsNeighbour when it's true");
        Board instance = this.board;
        boolean expResult = true;
        boolean result = instance.boardHasEqualsNeighbour();
        assertEquals(expResult, result);

    }

    /**
     * Test of boardHasEqualsNeighbour method (when true), of class Board.
     */
    @Test
    public void testBoardHasEqualsNeighbourTrueRow() {

        board = new Board(new Square[][]{
            {new Square(2), new Square(64), new Square(8), new Square(2)},
            {new Square(4), new Square(2), new Square(16), new Square(4)},
            {new Square(64), new Square(2), new Square(8), new Square(16)},
            {new Square(2), new Square(8), new Square(4), new Square(8)}
        });
        System.out.println("BoardHasEqualsNeighbour when it's true");
        Board instance = this.board;
        boolean expResult = true;
        boolean result = instance.boardHasEqualsNeighbour();
        assertEquals(expResult, result);

    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUp0004() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(4)},
            {new Square(0), new Square(8), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(2), new Square(8), new Square(0), new Square(0)}
        });

        System.out.println("moveUp 0|0|0|4");
        int row = 0;
        int column = 3;
        Board instance = board;
        instance.moveUp(row, column);
        int exeptResult03 = 4;

        int Result03 = instance.getSquares()[row][column].getValue();

        assertEquals(exeptResult03, Result03);

    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUp0220() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(4)},
            {new Square(0), new Square(8), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(2), new Square(8), new Square(0), new Square(0)}
        });

        System.out.println("moveUp 0|2|2|0");
        int row = 2;
        int column = 2;
        Board instance = board;
        instance.moveUp(row, column);
        int exeptResult22 = 0;
        int exeptResult12 = 4;
        int Result22 = instance.getSquares()[row][column].getValue();
        int Result12 = instance.getSquares()[1][2].getValue();

        assertEquals(exeptResult22, Result22);
        assertEquals(exeptResult12, Result12);

    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUp8080() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(4)},
            {new Square(0), new Square(8), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(2), new Square(8), new Square(0), new Square(0)}
        });

        System.out.println("moveUp 8|0|8|0");
        int row = 3;
        int column = 1;
        Board instance = board;
        instance.moveUp(row, column);
        int exeptResult31 = 0;
        int exeptResult11 = 16;
        int Result31 = instance.getSquares()[row][column].getValue();
        int Result11 = instance.getSquares()[1][1].getValue();

        assertEquals(exeptResult31, Result31);
        assertEquals(exeptResult11, Result11);

    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUp2002() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(4)},
            {new Square(0), new Square(8), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(2), new Square(8), new Square(0), new Square(0)}
        });

        System.out.println("moveUp 2|0|0|2");
        int row = 3;
        int column = 0;
        Board instance = board;
        instance.moveUp(row, column);
        int exeptResult30 = 0;
        int exeptResult00 = 4;
        int Result30 = instance.getSquares()[row][column].getValue();
        int Result00 = instance.getSquares()[0][0].getValue();

        assertEquals(exeptResult30, Result30);
        assertEquals(exeptResult00, Result00);

    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown8000() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(0)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveDown 8|0|0|0");
        int row = 0;
        int column = 3;
        Board instance = board;
        instance.moveDown(row, column);
        int exeptResult03 = 0;
        int exeptResult33 = 8;
        int Result03 = instance.getSquares()[row][column].getValue();
        int Result33 = instance.getSquares()[3][3].getValue();

        assertEquals(exeptResult03, Result03);
        assertEquals(exeptResult33, Result33);

    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown0220() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDown 0|2|2|0");
        int row = 1;
        int column = 2;
        Board instance = board;
        instance.moveDown(row, column);
        int exeptResult12 = 0;
        int exeptResult22 = 4;
        int Result12 = instance.getSquares()[row][column].getValue();
        int Result22 = instance.getSquares()[2][2].getValue();

        assertEquals(exeptResult12, Result12);
        assertEquals(exeptResult22, Result22);

    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown0200() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDown 0|2|0|0");
        int row = 1;
        int column = 1;
        Board instance = board;
        instance.moveDown(row, column);
        int exeptResult11 = 0;
        int exeptResult31 = 2;
        int Result11 = instance.getSquares()[row][column].getValue();
        int Result31 = instance.getSquares()[3][1].getValue();

        assertEquals(exeptResult11, Result11);
        assertEquals(exeptResult31, Result31);

    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown2002() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveDown 2|0|0|2");
        int row = 0;
        int column = 0;
        Board instance = board;
        instance.moveDown(row, column);
        int exeptResult00 = 0;
        int exeptResult30 = 4;
        int Result00 = instance.getSquares()[row][column].getValue();
        int Result30 = instance.getSquares()[3][0].getValue();

        assertEquals(exeptResult00, Result00);
        assertEquals(exeptResult30, Result30);

    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft8008() {
        board = new Board(new Square[][]{
            {new Square(8), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveLeft 8|0|0|8");
        int row = 0;
        int column = 3;
        Board instance = board;
        instance.moveLeft(row, column);
        int exeptResult03 = 0;
        int exeptResult00 = 16;
        int Result03 = instance.getSquares()[row][column].getValue();
        int Result00 = instance.getSquares()[0][0].getValue();

        assertEquals(exeptResult03, Result03);
        assertEquals(exeptResult00, Result00);

    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft0008() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveLeft 0|0|0|8");
        int row = 3;
        int column = 3;
        Board instance = board;
        instance.moveLeft(row, column);
        int exeptResult33 = 0;
        int exeptResult30 = 8;
        int Result22 = instance.getSquares()[row][column].getValue();
        int Result30 = instance.getSquares()[3][0].getValue();

        assertEquals(exeptResult33, Result22);
        assertEquals(exeptResult30, Result30);

    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft0028() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(0), new Square(0), new Square(0), new Square(8)}
        });

        System.out.println("moveLeft 0|0|2|8");
        int row = 2;
        int column = 2;
        Board instance = board;
        instance.moveLeft(row, column);
        int exeptResult22 = 0;
        int exeptResult20 = 2;
        int Result22 = instance.getSquares()[row][column].getValue();
        int Result20 = instance.getSquares()[2][0].getValue();

        assertEquals(exeptResult22, Result22);
        assertEquals(exeptResult20, Result20);

    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft0220() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveLeft 0|2|2|0");
        int row = 1;
        int column = 2;
        Board instance = board;
        instance.moveLeft(row, column);
        int exeptResult12 = 0;
        int exeptResult11 = 4;
        int Result12 = instance.getSquares()[row][column].getValue();
        int Result11 = instance.getSquares()[1][1].getValue();

        assertEquals(exeptResult12, Result12);
        assertEquals(exeptResult11, Result11);

    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft2008() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveLeft 2|0|0|8");
        int row = 0;
        int column = 3;
        Board instance = board;
        instance.moveLeft(row, column);
        int exeptResult03 = 0;
        int exeptResult01 = 8;
        int Result03 = instance.getSquares()[row][column].getValue();
        int Result01 = instance.getSquares()[0][1].getValue();

        assertEquals(exeptResult03, Result03);
        assertEquals(exeptResult01, Result01);

    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight0028() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveRight 0|2|2|0");
        int row = 2;
        int column = 3;
        Board instance = board;
        instance.moveRight(row, column);
        int Result23 = instance.getSquares()[row][column].getValue();
        int Result22 = instance.getSquares()[2][2].getValue();
        int exeptResult23 = 8;
        int exeptResult22 = 2;
        assertEquals(exeptResult23, Result23);
        assertEquals(exeptResult22, Result22);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight0220() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveRight 0|2|2|0");
        int row = 1;
        int column = 1;
        Board instance = board;
        instance.moveRight(row, column);
        int Result11 = instance.getSquares()[row][column].getValue();
        int Result12 = instance.getSquares()[1][2].getValue();
        int exeptResult11 = 0;
        int exeptResult12 = 4;
        assertEquals(exeptResult11, Result11);
        assertEquals(exeptResult12, Result12);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight2000() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveRight 2|0|0|0");
        int row = 3;
        int column = 0;
        Board instance = board;
        instance.moveRight(row, column);
        int Result30 = instance.getSquares()[row][column].getValue();
        int Result33 = instance.getSquares()[3][3].getValue();
        int exeptResult30 = 0;
        int exeptResult33 = 2;
        assertEquals(exeptResult30, Result30);
        assertEquals(exeptResult33, Result33);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight2008() {
        board = new Board(new Square[][]{
            {new Square(2), new Square(0), new Square(0), new Square(8)},
            {new Square(0), new Square(2), new Square(2), new Square(0)},
            {new Square(0), new Square(0), new Square(2), new Square(8)},
            {new Square(2), new Square(0), new Square(0), new Square(0)}
        });

        System.out.println("moveRight 2|0|0|8");
        int row = 0;
        int column = 0;
        Board instance = board;
        instance.moveRight(row, column);
        int Result00 = instance.getSquares()[row][column].getValue();
        int Result02 = instance.getSquares()[0][2].getValue();
        int exeptResult00 = 0;
        int exeptResult02 = 2;
        assertEquals(exeptResult00, Result00);
        assertEquals(exeptResult02, Result02);
    }
}
