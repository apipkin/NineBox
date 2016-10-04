/* File: NineBox.java
 * Author: Anthony Pipkin
 * Date: 2016-10-03
 * Instructor: Stephen Grady
 * Class: CMIS 242
 * Project: Week 4  - GUIs and event handlers
 * Purpose: Give an example of a program that creates a GUI with at least one button and several textfields. Some of the textfields should be for input and others for output.  
 */

/**
 * Creates the NineBox game and displays it
 * @author Anthony Pipkin
 * @version 0.1.0
 */
public class NineBox {
    static public void main (String[] args) {
        NineBoxBoard game = new NineBoxBoard();
        game.display();
    }
}