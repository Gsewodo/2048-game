package g52949.p2048.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * tests of Square
 *
 *
 */
public class SquareTest {

    public SquareTest() {
    }

    /**
     * Test of setValue method, of class Square.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int value = 5;
        Square instance = new Square();
        instance.setValue(value);
        int result = instance.getValue();
        assertEquals(value, result);

    }

    /**
     * Test of getValue method, of class Square.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Square instance = new Square(4);
        int expResult = 4;
        int result = instance.getValue();
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Square.when it's true
     */
    @Test
    public void testEqualsTrue() {
        System.out.println("equals when two square are equals");
        Square square = new Square(8);
        Square instance = new Square(8);
        boolean expResult = true;
        boolean result = instance.equals(square);
        assertEquals(expResult, result);

    }

    /**
     * Test of equals method, of class Square.when it's false
     */
    @Test
    public void testEqualsFalse() {
        System.out.println("equals when two square aren't equals");
        Square square = new Square(4);
        Square instance = new Square(8);
        boolean expResult = false;
        boolean result = instance.equals(square);
        assertEquals(expResult, result);

    }


    /**
     * Test of is2048 method, of class Square.
     */
    @Test
    public void testIsWinTrue() {
        System.out.println("is2048 True");
        Square instance = new Square(2048);
        instance.is2048();
        boolean expResult = true;
        assertEquals(expResult, instance.is2048());
    }

    /**
     * Test of is2048 method, of class Square.
     */
    @Test
    public void testIsWinFalse() {
        System.out.println("is2048 False");
        Square instance = new Square(128);
        instance.is2048();
        boolean expResult = false;
        assertEquals(expResult, instance.is2048());
    }

    /**
     * Test of is2048 method, of class Square.
     */
    @Test
    public void testIsWinFalse0() {
        System.out.println("is2048 when false and 0");
        Square instance = new Square();
        instance.is2048();
        boolean expResult = false;
        assertEquals(expResult, instance.is2048());
    }

    /**
     * Test of merge method, of class Square.
     */
    @Test
    public void testMerge() {
        System.out.println("merge");
        Square square = new Square(2);
        Square instance = new Square(2);
        int expResult = 4;
        instance.merge(square);
        assertEquals(expResult, instance.getValue());

    }


    /**
     * Test of clear method, of class Square.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Square instance = new Square(64);
        instance.clear();
        int expResult = 0;
        assertEquals(expResult, instance.getValue());
    }

    /**
     * Test of isEmpty method, of class Square.when it's true
     */
    @Test
    public void testIsEmptyTrue() {
        System.out.println("isEmpty when it is");
        Square instance = new Square(0);
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEmpty method, of class Square.when it's false
     */
    @Test
    public void testIsEmptyFalse() {
        System.out.println("isEmpty when it's not");
        Square instance = new Square(4);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);

    }

}
