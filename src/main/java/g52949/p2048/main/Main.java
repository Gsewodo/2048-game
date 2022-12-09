package g52949.p2048.main;

import g52949.p2048.controller.Controller;
import g52949.p2048.model.Game;
import g52949.p2048.view.View;

/**
 * Main that runs the game.
 *
 * 
 */
public class Main  {

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(new Game(), view);
        controller.startGame();
    }
    

}
