package g52949.p2048.view;

import g52949.p2048.controller.ControllerJavaFx;
import g52949.p2048.model.Board;
import g52949.p2048.model.GameStatus;
import static g52949.p2048.model.GameStatus.*;
import g52949.p2048.model.Model;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * displays all elements of the game
 *
 * 
 */
public class MainView implements Observer {

    private Stage stage;
    private BoardView boardView;
    private VBox root;
    private HBox hbox;
    private ControllerJavaFx controllerJavaFx;
    private ListViews listViews;
    private Button buttonRetry;

    /**
     * constuctor of MainView
     *
     * @param stage
     */
    public MainView(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("heb-esi-2048");
    }

    /**
     * displays all element of game
     *
     * @param game
     */
    public void start(Model game) {
        game.getInitialBoard();
        listViews = new ListViews();
        boardView = new BoardView(game.getBoard());
        root = new VBox();

        buttonRetry = new Button("retry");
        buttonRetry.setFont(Font.font(STYLESHEET_CASPIAN, 18));
        buttonRetry.setMaxWidth(100);
        buttonRetry.setOnAction(event -> {
            controllerJavaFx.retry();
            listViews.getItems().clear();
            listViews.getItems().add("Bienvenue-2048");
        });
        hbox = new HBox();
        root.setSpacing(20);
        hbox.setSpacing(15);
        hbox.setPadding(new Insets(7, 7, 7, 7));
        hbox.getChildren().addAll(this.boardView, this.listViews);

        root.getChildren().add(this.hbox);
        root.getChildren().add(buttonRetry);
        root.setOnKeyPressed(event -> controllerJavaFx.keyBoardDirection(event));
        root.requestFocus();
        Scene scene = new Scene(root, 860, 700);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * setter of controllerJavaFx
     *
     * @param controllerJavaFx
     */
    public void setController(ControllerJavaFx controllerJavaFx) {
        this.controllerJavaFx = controllerJavaFx;

    }

    /**
     * allows all component to request focus
     */
    public void requestFocus() {
        root.requestFocus();
    }

    /**
     * update the view of the game
     *
     * @param board the board of the game
     */
    @Override
    public void update(Board board) {
        boardView.createBoard(board);
    }

    /**
     * add a messsage to the listViews according to the status
     *
     * @param gameStatus the status of the game
     */
    @Override
    public void updateGameStatus(GameStatus gameStatus) {
        switch (gameStatus) {
            case WIN:
                this.listViews.getItems().add("YOU WIN");
                break;
            case GAME_OVER:
                this.listViews.getItems().add("GAME OVER");
                break;
            case IMPOSSIBLE_MOVEMENT:
                this.listViews.getItems().add("IMPOSSIBLE MOVEMENT");
                break;

        }
    }
}
