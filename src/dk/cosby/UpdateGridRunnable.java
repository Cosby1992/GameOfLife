package dk.cosby;

import dk.cosby.model.Game;
import javafx.application.Platform;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static dk.cosby.view.Controller.RECT_SIZE;

public class UpdateGridRunnable implements Runnable {

    private Game game;
    private GridPane gridPane;
    private Color aliveColor;
    private Color deadColor;


    public UpdateGridRunnable(GridPane gridPane, Game game, Color aliveColor, Color deadColor) {
        this.game = game;
        this.gridPane = gridPane;
        this.deadColor = deadColor;
        this.aliveColor = aliveColor;



    }

    @Override
    public void run() {

        game.updateGameGrid();

        for (int i = 0; i < Game.GRID_SIZE_X; i++) {
            for (int j = 0; j < Game.GRID_SIZE_Y; j++) {

                if(game.getGrid()[i][j].isAlive()){
                    gridPane.add(new Rectangle(RECT_SIZE, RECT_SIZE, aliveColor),i,j);
                } else {
                    gridPane.add(new Rectangle(RECT_SIZE, RECT_SIZE, deadColor),i,j);
                }
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public Color getAliveColor() {
        return aliveColor;
    }

    public void setAliveColor(Color aliveColor) {
        this.aliveColor = aliveColor;
    }

    public Color getDeadColor() {
        return deadColor;
    }

    public void setDeadColor(Color deadColor) {
        this.deadColor = deadColor;
    }
}
