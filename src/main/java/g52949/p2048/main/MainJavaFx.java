package g52949.p2048.main;

import g52949.p2048.controller.ControllerJavaFx;
import g52949.p2048.model.Game;
import g52949.p2048.model.Model;
import g52949.p2048.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main (javaFX) that runs the game.
 *
 * 
 */
public class MainJavaFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model game = new Game();
        MainView mainView = new MainView(stage);
        ControllerJavaFx controllerFx = new ControllerJavaFx(game, mainView);
        controllerFx.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
