/* File: NineBoxBoard.java
 * Author: Anthony Pipkin
 * Date: 2016-10-03
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 4  - GUIs and event handlers
 * Purpose: Give an example of a program that creates a GUI with at least one button and several textfields. Some of the textfields should be for input and others for output.  
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.NumberFormatException;

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
 *   [ Did I win? ]
 * 
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class NineBoxBoard extends JFrame {
    static final int WIDTH = 400, HEIGHT = 400;
    private NineBoxGrid grid = new NineBoxGrid();

    private JPanel gridPanel = new JPanel();

    private JTextField gridA = new JTextField("0", 2);
    private JTextField gridB = new JTextField("0", 2);
    private JTextField gridC = new JTextField("0", 2);
    private JTextField gridD = new JTextField("0", 2);
    private JTextField gridE = new JTextField("0", 2);
    private JTextField gridF = new JTextField("0", 2);
    private JTextField gridG = new JTextField("0", 2);
    private JTextField gridH = new JTextField("0", 2);
    private JTextField gridI = new JTextField("0", 2);

    private JButton btn = new JButton();

    private JTextArea msg = new JTextArea("Fill in boxes with the numbers 1-9.");

    /**
     * Sets up elements and creates the board
     */
    public NineBoxBoard() {
        super("Nine Box");
        setFrame(WIDTH, HEIGHT);
        setupPanel(); 
        setupButton();
        setupLabel();
        createBoard();
    }

    /**
     * Show the game board
     */
    public void display() {
        setVisible(true);
    }

    /**
     * Estabilishes the frame with a width, height, and closable
     * @param width
     * @param height
     */
    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Sets default configurations of the panel
     */
    private void setupPanel() {
        gridPanel.setLayout(null);
        add(gridPanel);
    }

    /**
     * Sets up default configurations of the submit button
     */
    private void setupButton() {
        btn.setText("Did I win?");

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                calculate();
            }
        });
    }

    /**
     * Sets up the default setttings for the JTextField
     */
    private void setupLabel() {
        msg.setLineWrap(true);
        msg.setWrapStyleWord(true);
        msg.setOpaque(false);
        msg.setEditable(false);
    }

    /**
     * Creates the board by placing the elements on the board precicely where they need to go
     */
    private void createBoard() {
        addGridCell(gridA, 1, 1);
        addGridCell(gridB, 2, 1);
        addGridCell(gridC, 3, 1);
        addGridCell(gridD, 1, 2);
        addGridCell(gridE, 2, 2);
        addGridCell(gridF, 3, 2);
        addGridCell(gridG, 1, 3);
        addGridCell(gridH, 2, 3);
        addGridCell(gridI, 3, 3);

        addButton(btn, 270);

        addLabel(msg, 320);
    }

    /**
     * Adds a given cell to a specific row and column on the panel. Row and column are done using absolute position
     * @param cell JTextField to position
     * @param row Integer identifying the row
     * @param col Integer identifying the column
     */
    private void addGridCell(JTextField cell, int row, int col) {
        Dimension size = cell.getPreferredSize();
        cell.setBounds(row * 90, col * 70 - 20, size.width, size.height);
        gridPanel.add(cell);
    }

    /**
     * Adds a button at a given Y, centered to the frame
     * @param btn
     * @param y
     */
    private void addButton(JButton btn, int y) {
        Dimension size = btn.getPreferredSize();

        btn.setBounds(WIDTH / 2 - size.width / 2, y, size.width, size.height);
        gridPanel.add(btn);
    }

    /**
     * Adds a label to the panel.
     * @param lbl
     * @param y
     */
    private void addLabel(JTextArea lbl, int y) {
        Dimension size = lbl.getPreferredSize();
        lbl.setBounds(WIDTH / 2 - 350 / 2, y, 350, size.height);

        gridPanel.add(lbl);
    }

    /**
     * Gatheres the values and passes them into the game grid. Based on whether the grid is filled out correctly,
     * either calls winner() or tryAgain()
     */
    private void calculate() {
        int a = 0, b = 0, c = 0, 
            d = 0, e = 0, f = 0, 
            g = 0, h = 0, i = 0;
        
        try {
            a = Integer.parseInt(gridA.getText());
            b = Integer.parseInt(gridB.getText());
            c = Integer.parseInt(gridC.getText());
            d = Integer.parseInt(gridD.getText());
            e = Integer.parseInt(gridE.getText());
            f = Integer.parseInt(gridF.getText());
            g = Integer.parseInt(gridG.getText());
            h = Integer.parseInt(gridH.getText());
            i = Integer.parseInt(gridI.getText());
        }
        catch (NumberFormatException ex) {
            System.out.println("Cannot process text." + ex.getMessage());
        }
        finally {
            grid.setAll(a, b, c, d, e, f, g, h, i);
            if (grid.isCorrect()) {
                winner();
            } else {
                tryAgain();
            }
        }
    }

    /**
     * Displays a message that the user won.
     */
    private void winner(){ 
        msg.setText("You win!!");
    }

    /**
     * Displays a message that the user should play again.
     */
    private void tryAgain() {
        msg.setText("Try again. :(");
    }
}
