package dk.cosby.view;

import dk.cosby.UpdateGridRunnable;
import dk.cosby.model.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Controller {

    public static int RECT_SIZE = 10;


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

    @FXML
    ChoiceBox cb_startingGrid;
    @FXML
    Button btn_reset;
    @FXML
    Label lb_generation_number;

    //controls from gui, bottom right
    @FXML
    ColorPicker cp_alive_color;
    @FXML
    ColorPicker cp_dead_color;
    @FXML
    ColorPicker cp_grid_color;


    public static Game game;

    private boolean switchBool = false;

    private Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> {
                update();
            })
    );

    ObservableList<String> cb_options =
            FXCollections.observableArrayList(
                    "Clear",
                    "10 in a row",
                    "10x10 square"
            );



    ///////////////////////////////////////////// METHODS ///////////////////////////////////////////////


    public void initialize(){

        game = new Game();

    }

    private void update(){

        game.updateGameGrid();
        drawGameGridOnGridPane(game);
        lb_generation_number.setText(String.valueOf(game.getGeneration()));
    }

    private void drawGameGridOnGridPane(Game game){

        for (int i = 0; i < Game.GRID_SIZE_X; i++) {
            for (int j = 0; j < Game.GRID_SIZE_Y; j++) {

                if(game.getGrid()[i][j].isAlive()){
                    gp_grid.add(new Rectangle(RECT_SIZE, RECT_SIZE, Color.valueOf("BLUE")),i,j);
                } else {
                    gp_grid.add(new Rectangle(RECT_SIZE, RECT_SIZE, Color.valueOf("WHITE")),i,j);
                }
            }
        }
    }





    public void nextFrame(ActionEvent actionEvent) {
        timeline.stop();
        switchBool = false;
        btn_play.setText("Play");
        update();
    }



    public void playPause(ActionEvent actionEvent) {
        timeline.setCycleCount(1000);

        if(switchBool){
            switchBool = false;
            btn_play.setText("Play");
            timeline.stop();
        } else {
            switchBool = true;
            btn_play.setText("Pause");
            timeline.play();
        }
    }

    public void drawOnGrid(MouseEvent mouseEvent) {

        boolean withinGrid = gp_grid.contains(new Point2D(mouseEvent.getX(), mouseEvent.getY()));

        double gp_gridWidth = gp_grid.getWidth();
        double gp_gridHeight = gp_grid.getHeight();

        double cellWidthX = gp_gridWidth/Game.GRID_SIZE_X;
        double cellWidthY = gp_gridHeight/Game.GRID_SIZE_Y;

        int rowIndex = (int) (mouseEvent.getX()/cellWidthX);
        int colIndex = (int) (mouseEvent.getY()/cellWidthY);

        if(withinGrid) {
            game.changeStateOfCellByPosition(rowIndex, colIndex);
            drawGameGridOnGridPane(game);
        }
    }


    public void resetGrid(ActionEvent actionEvent) {

        game = new Game();
        lb_generation_number.setText("0");
        drawGameGridOnGridPane(game);

    }


}
