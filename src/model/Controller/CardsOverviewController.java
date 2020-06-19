package model.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.dto.Card;
import model.dto.GameState;
import view.MainApp;

public class CardsOverviewController {
    @FXML
    private TableView<Card> finishStack4;
    @FXML
    private TableView<Card> finishStack3;
    @FXML
    private TableView<Card> finishStack2;
    @FXML
    private TableView<Card> finishStack1;
    @FXML
    private TableView<Card> turnedStock;
    @FXML
    private TableView<Card> gameStack1;
    @FXML
    private TableView<Card> gameStack2;
    @FXML
    private TableView<Card> gameStack3;
    @FXML
    private TableView<Card> gameStack4;
    @FXML
    private TableView<Card> gameStack5;
    @FXML
    private TableView<Card> gameStack6;
    @FXML
    private TableView<Card> gameStack7;
    @FXML
    private TableColumn<Card, Card.Suit> turnedStockSuit;
    @FXML
    private TableColumn<Card, Integer> turnedStockNumber;
    @FXML
    private TableColumn<Card, Card.Suit> finishStack4Suit;
    @FXML
    private TableColumn<Card, Integer> finishStack4Number;
    @FXML
    private TableColumn<Card, Card.Suit> finishStack3Suit;
    @FXML
    private TableColumn<Card, Integer> finishStack3Number;
    @FXML
    private TableColumn<Card, Card.Suit> finishStack2Suit;
    @FXML
    private TableColumn<Card, Integer> finishStack2Number;
    @FXML
    private TableColumn<Card, Card.Suit> finishStack1Suit;
    @FXML
    private TableColumn<Card, Integer> finishStack1Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack1Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack1Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack2Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack2Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack3Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack3Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack4Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack4Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack5Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack5Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack6Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack6Number;
    @FXML
    private TableColumn<Card, Card.Suit> gameStack7Suit;
    @FXML
    private TableColumn<Card, Integer> gameStack7Number;
    @FXML
    private Button button;
    @FXML
    private Label suit;
    @FXML
    private Label color;
    @FXML
    private Label cardValue;

    private MainApp mainApp;

    @FXML
    private void initialize() {
        finishStack4Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        finishStack4Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        finishStack3Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        finishStack3Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        finishStack2Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        finishStack2Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        finishStack1Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        finishStack1Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack1Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack1Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack2Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack2Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack3Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack3Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack4Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack4Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack5Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack5Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack6Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack6Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        gameStack7Suit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        gameStack7Number.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

        turnedStockSuit.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        turnedStockNumber.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

    }

    @FXML
    private void editButton() {
        Card specificCard = finishStack4.getSelectionModel().getSelectedItem();
        mainApp.dialogBoxForEdit(specificCard);
    }

    @FXML
    private void nextMoveButton() {

    }

    public void updateView(GameState gameState) {
        ObservableList<Card> cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getTurnedStock().stack);
        turnedStock.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[0].stack);
        gameStack1.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[1].stack);
        gameStack2.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[2].stack);
        gameStack3.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[3].stack);
        gameStack4.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[4].stack);
        gameStack5.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[5].stack);
        gameStack6.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getGameStacks()[6].stack);
        gameStack7.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getFinishStacks()[0].stack);
        finishStack1.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getFinishStacks()[1].stack);
        finishStack2.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getFinishStacks()[2].stack);
        finishStack3.setItems(cards);

        cards = FXCollections.observableArrayList();
        cards.addAll(gameState.getFinishStacks()[3].stack);
        finishStack4.setItems(cards);
    }
}
