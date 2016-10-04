/* File: NineBoxGrid.java
 * Author: Anthony Pipkin
 * Date: 2016-10-03
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 4  - GUIs and event handlers
 * Purpose: Give an example of a program that creates a GUI with at least one button and several textfields. Some of the textfields should be for input and others for output.  
 */


/**
 * A simple math game of nine box. Takes in 9 numbers arranged in a 3x3 grid 
 * and calculates each row and column. If each row and column add up to 15 
 * separately and the whole grid adds up to 45, the grid is correctly filled
 * out.
 * 
 *      |     | 
 *   a  |  b  |  c
 * _____|_____|_____
 *      |     | 
 *   d  |  e  |  f
 * _____|_____|_____
 *      |     |
 *   g  |  h  |  i
 *      |     |
 * 
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class NineBoxGrid {

    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    /**
     * Checks to see if grid is filled out correctly
     * @return boolean
     */
    public boolean isCorrect() {
        return calcRow1() == 15 && 
               calcRow2() == 15 &&
               calcRow3() == 15 &&
               calcCol1() == 15 &&
               calcCol2() == 15 &&
               calcCol3() == 15 &&
               calcTotal() == 45;
    }

    /**
     * Sugar for setting the grid from mutiple calls
     */
    public void setAll(int a, int b, int c, int d, int e, int f, int g, int h, int i) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
        this.setD(d);
        this.setE(e);
        this.setF(f);
        this.setG(g);
        this.setH(h);
        this.setI(i);
    }

    /**
     * Sets row 1, col 1
     */
    public void setA(int num) {
        this.a = num;
    }

    /**
     * Sets row 1, col 2
     */
    public void setB(int num) {
        this.b = num;
    }

    /**
     * Sets row 1, col 3
     */
    public void setC(int num) {
        this.c = num;
    }

    /**
     * Sets row 2, col 1
     */
    public void setD(int num) {
        this.d = num;
    }

    /**
     * Sets row 2, col 2
     */
    public void setE(int num) {
        this.e = num;
    }

    /**
     * Sets row 2, col 3
     */
    public void setF(int num) {
        this.f = num;
    }

    /**
     * Sets row 3, col 1
     */
    public void setG(int num) {
        this.g = num;
    }

    /**
     * Sets row 3, col 2
     */
    public void setH(int num) {
        this.h = num;
    }

    /**
     * Sets row 3, col 3
     */
    public void setI(int num) {
        this.i = num;
    }

    /**
     * Adds the value of row 1
     * @return int
     */
    public int calcRow1() {
        return a + b + c;
    }

    /**
     * Adds the value of row 2
     * @return int
     */
    public int calcRow2() {
        return d + e + f;
    }

    /**
     * Adds the value of row 3
     * @return int
     */
    public int calcRow3() {
        return g + h + i;
    }

    /**
     * Adds the value of col 1
     * @return int
     */
    public int calcCol1() {
        return a + d + g;
    }

    /**
     * Adds the value of col 1
     * @return int
     */
    public int calcCol2() {
        return b + e + h;
    }

    /**
     * Adds the value of col 1
     * @return int
     */
    public int calcCol3() {
        return c + f + i;
    }

    /**
     * Adds the total of all grids
     * @return int
     */
    public int calcTotal() {
        return a + b + c + d + e + f + g + h + i;
    }
}