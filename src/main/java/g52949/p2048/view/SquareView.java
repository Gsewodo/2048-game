package g52949.p2048.view;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * displays all squares elements of the game
 *
 *
 */
public class SquareView extends StackPane {

    private int row;
    private int column;
    private int value;

    /**
     * constructor of Square view
     *
     * @param row
     * @param column
     * @param value
     */
    public SquareView(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;

        this.setBorder(new Border(new BorderStroke(Color.BURLYWOOD,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.EMPTY)));
        this.setBackground(new Background(new BackgroundFill(squareColory(), CornerRadii.EMPTY, Insets.EMPTY)));
        Text valueText = new Text("" + this.value);
        this.getChildren().add(valueText);
        setMinSize(150, 150);

    }

    /**
     * gives a color to all values
     *
     * @return a color
     */
    private Color squareColory() {
        switch (this.value) {
            case 2:
                return Color.rgb(238, 228, 218); //2
            case 4:
                return Color.rgb(237, 224, 200);
            case 8:
                return Color.rgb(242, 177, 121);
            case 16:
                return Color.rgb(245, 149, 99);
            case 32:
                return Color.rgb(246, 124, 95);
            case 64:
                return Color.rgb(246, 94, 59);
            case 128:
                return Color.rgb(237, 207, 114);
            case 256:
                return Color.rgb(237, 204, 97);
            case 512:
                return  Color.rgb(237, 200, 80);
            case 1024:
                return  Color.rgb(237, 197, 63);
            case 2048:
                return  Color.rgb(237, 194, 46);
        }
        return Color.rgb(205, 193, 180, 1.0);
    }
}
