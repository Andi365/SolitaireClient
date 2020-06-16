package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Card;

public class CardsOverviewController {
    @FXML
    private TableView<Card> cardTableView;
    @FXML
    private TableColumn<Card, Card.Suit> colorColumn;
    @FXML
    private TableColumn<Card, Integer> numberColumn;
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
        colorColumn.setCellValueFactory(cellData -> cellData.getValue().getSuit());
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().getCardValue().asObject());

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        cardTableView.setItems(mainApp.getCards());
    }

    @FXML
    private void editButton() {
        Card specificCard = cardTableView.getSelectionModel().getSelectedItem();
        mainApp.dialogBoxForEdit(specificCard);
    }
}
