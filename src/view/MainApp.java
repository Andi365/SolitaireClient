package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import model.Controller.CardEditController;
import model.Controller.CardsOverviewController;
import model.Controller.Controller;
import model.Controller.TestController;
import model.dto.Card;

public class MainApp extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    private TestController controller;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SolitaireClient");

        initRootLayout();
    }

    public ObservableList<Card> getCards() {
        ObservableList<Card> cards = FXCollections.observableArrayList();
        cards.add(new Card(Card.Suit.SPADES,1));
        cards.add(new Card(Card.Suit.SPADES,2));
        cards.add(new Card(Card.Suit.SPADES,3));
        cards.add(new Card(Card.Suit.SPADES,4));

        cards.add(new Card(Card.Suit.HEARTS,1));
        cards.add(new Card(Card.Suit.HEARTS,2));
        cards.add(new Card(Card.Suit.HEARTS,3));
        cards.add(new Card(Card.Suit.HEARTS,4));

        return cards;
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("ListOfCards.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            CardsOverviewController cardsOverviewController = loader.getController();

            controller = new TestController();
            controller.setupGame();
            cardsOverviewController.updateView(controller.getLogicController().getGameState());
            controller.runGame();
            //Controller controller = new Controller();

            cardsOverviewController.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dialogBoxForEdit(Card card) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("CardEditDialog.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Card");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            CardEditController controller = loader.getController();
            controller.setStage(dialogStage);
            controller.setCard(card);


            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runGame(){
        boolean running = true;
        boolean moveSinceLastStockTurn = true;
        while(running){
            if(controller.getLogicController().gameWon()){
                System.out.println("YOU WON!");
                break;
            }else {
                String moveString = controller.getLogicController().makeMoveTest();

                if (moveString == null) {
                    running = false;
                    System.out.println("GAME OVER!");
                } else {
                    if (moveString.equals("Turn the stock over, then turn new card from the stock") && !moveSinceLastStockTurn) {
                        System.out.println("GAME OVER!");
                        break;
                    } else if (!moveString.equals("Turn the stock over, then turn new card from the stock") && !moveString.equals("Turn new card from the stock")) {
                        moveSinceLastStockTurn = true;
                    } else if (moveString.equals("Turn the stock over, then turn new card from the stock")) {
                        moveSinceLastStockTurn = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}