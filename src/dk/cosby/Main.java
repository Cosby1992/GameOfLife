package dk.cosby;

import dk.cosby.view.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/gameOfLifeGui.fxml"));
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

        Controller controller = new Controller();

        controller.initialize();


    }

    public static void main(String[] args) {
        launch(args);
    }

}


