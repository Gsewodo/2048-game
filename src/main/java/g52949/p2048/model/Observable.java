package g52949.p2048.model;

import g52949.p2048.view.Observer;


/**
 *
 * 
 */
public interface Observable {

    void notifyObservers();

    void register(Observer obs);
}
