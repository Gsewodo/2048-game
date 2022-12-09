/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g52949.p2048.view;

import g52949.p2048.model.Board;
import g52949.p2048.model.Direction;

/**
 *
 * @author 
 */
public interface InterfaceView {

    public void displayBoard(Board board);

    public Direction askDirection();

    public void displayLose();

    public void displayWin();

    public void displayError(String message);

}
