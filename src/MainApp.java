import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class MainApp extends Application {

    private String move;
    private Stage primaryStage, stage1;
    private AnchorPane rootLayout;
    private TextField typeInput, valueInput, typeInputChanged, valueInputChanged;
    private TableView table;

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Card> table;

        //Type Column
        TableColumn<Card, String> nameColumn = new TableColumn<>("Kulør");
        nameColumn.setMinWidth(115);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Card, String>("type"));

        //Value Column
        TableColumn<Card, Integer> valueColumn = new TableColumn<>("Værdi");
        valueColumn.setMinWidth(120);
        valueColumn.setCellValueFactory(new PropertyValueFactory<Card, Integer>("value"));

        //Scenes for editing
        ComboBox oldType = new ComboBox();
        oldType.getItems().addAll("Klør", "Spar", "Ruder", "Hjerter");
        oldType.setPromptText("G. Kulør");

        ComboBox oldValue = new ComboBox();
        oldValue.getItems().addAll("1","2","3","4");
        oldValue.setPromptText("G. Værdi");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(oldType, oldValue);

        ComboBox newType = new ComboBox();
        newType.getItems().addAll("Klør", "Spar", "Ruder", "Hjerter");
        newType.setPromptText("N. Kulør");

        ComboBox newValue = new ComboBox();
        newValue.getItems().addAll("1","2","3","4");
        newValue.setPromptText("N. værdi");

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(newType, newValue);

        //Change Button
        Button editButton = new Button("Ændr");

        //TODO Make it reset the button prompts
        editButton.setOnAction(e -> {
            Alert.display("Er du sikker?", "Klør", "1", "Hjerter", "1");
        });

        HBox hBox3 = new HBox();
        hBox3.getChildren().add(editButton);
        hBox3.setPadding(new Insets(10,10,10,10));
        hBox3.setSpacing(10);
        hBox3.setAlignment(Pos.CENTER);

        //Init the table and define parameters
        table = new TableView<>();
        table.setEditable(true);
        table.setPrefSize(250, 300);
        table.setItems(getCards());
        table.getColumns().addAll(nameColumn, valueColumn);

        //Create text output for moves
        TextArea moveText = new TextArea();
        moveText.setPrefSize(250,250);
        moveText.setEditable(false);
        moveText.setText("Næste Træk:");

        HBox hBox4 = new HBox();
        hBox4.getChildren().add(moveText);
        hBox4.setPadding(new Insets(10,10,10,10));

        //Stage for the table of cards, aswell as corresponding buttons
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox, hBox2, hBox3, hBox4);
        vBox.setMaxSize(250,700);

        //Load the image
        Image image = new Image("Solitaire_recognition.PNG");
        ImageView img = new ImageView();
        img.setImage(image);

        VBox vBox2 = new VBox();
        vBox2.getChildren().add(img);
        vBox2.setAlignment(Pos.CENTER);

        HBox multiBox = new HBox();
        multiBox.getChildren().addAll(vBox, vBox2);

        //Initialize the stage
        Scene scene = new Scene(multiBox);
        primaryStage.setScene(scene);
        primaryStage.show();

        //initRootLayout();

        //showPersonOverview();
    }

    public ObservableList<Card> getCards() {
        ObservableList<Card> cards = FXCollections.observableArrayList();
        cards.add(new Card("Klør", 1));
        cards.add(new Card("Klør", 2));
        cards.add(new Card("Klør", 3));
        cards.add(new Card("Klør", 4));

        cards.add(new Card("Spar", 1));
        cards.add(new Card("Spar", 2));
        cards.add(new Card("Spar", 3));
        cards.add(new Card("Spar", 4));

        cards.add(new Card("Hjerter", 1));
        cards.add(new Card("Hjerter", 2));
        cards.add(new Card("Hjerter", 3));
        cards.add(new Card("Hjerter", 4));

        cards.add(new Card("Ruder", 1));
        cards.add(new Card("Ruder", 2));
        cards.add(new Card("Ruder", 3));
        cards.add(new Card("Ruder", 4));

        return cards;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    //Test
}