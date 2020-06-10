import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import model.Card;

public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Card> cards = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        cards.add(new Card("Hans", 1));
        cards.add(new Card("Phillip", 1));
        cards.add(new Card("Dab", 1));
        cards.add(new Card("skyd", 1));
        cards.add(new Card("mig", 1));
        cards.add(new Card("lige", 1));
        cards.add(new Card("nu", 1));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Card> getCards() {
        return cards;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ListOfCards.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}