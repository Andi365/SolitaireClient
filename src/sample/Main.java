package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent> {
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        button = new Button();
        button.setText("bund");
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();


    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(actionEvent.getSource() == button) {
            System.out.println("dab");
        }

    }

    //hello

}
