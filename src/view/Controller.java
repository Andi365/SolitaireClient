package view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    private AnchorPane ap1;

    @FXML
    private ImageView imageView;

    public void initialize(URL location, ResourceBundle resources) {
        File file = new File("res/images/Solitaire_recognition.PNG");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    @FXML
    private void displayImage(ActionEvent event) {
        ap1.getChildren().clear();
        Image img = new Image("res/images/Solitaire_recognition.PNG");
    }
}
