package dk.cosby.view;

import dk.cosby.model.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Controller {

    ////////////////////////////////////////// CONTENT FROM VIEW //////////////////////////////////////////

    //GridPane used as board for the game
    @FXML
    GridPane gp_grid;

    //controls from gui, bottom left
    @FXML
    Button btn_next;
    @FXML
    Button btn_play;
    @FXML
    Slider sld_time_speed;

    //controls from gui, bottom right
    @FXML
    ColorPicker cp_alive_color;
    @FXML
    ColorPicker cp_dead_color;
    @FXML
    ColorPicker cp_grid_color;

    Game game = new Game();


    private final int rectSize = 20;


    ///////////////////////////////////////////// METHODS ///////////////////////////////////////////////

    public void updateGrid(ActionEvent actionEvent) {

        game.updateGameGrid();

        for (int i = 0; i < Game.GRID_SIZE_X; i++) {
            for (int j = 0; j < Game.GRID_SIZE_Y; j++) {

                if(game.getGrid()[i][j].isAlive()){
                    gp_grid.add(new Rectangle(rectSize,rectSize, Color.valueOf("RED")),i,j);
                } else {
                    gp_grid.add(new Rectangle(rectSize,rectSize, Color.valueOf("BLACK")),i,j);
                }
            }
        }



    }


    public void nextFrame(ActionEvent actionEvent) {

    }
}
