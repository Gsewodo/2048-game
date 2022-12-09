package g52949.p2048.view;

import javafx.scene.control.ListView;

/**
 * displays all status of game 
 *
 * 
 */
public class ListViews extends ListView<Object>{

    /**
     * add the message bienvenue-2048
     */
    public ListViews() {
        this.getItems().add("Bienvenue-2048");
    }
   
}
