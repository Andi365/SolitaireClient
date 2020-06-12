package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Card;

public class CardEditController {
    @FXML
    private TextField cardValue;
    @FXML
    private TextField suit;
    @FXML
    private TextField color;

    private Stage editStage;
    private Card card;

    @FXML
    private void initialize() {

    }

    public void setStage(Stage editStage) {
        this.editStage = editStage;
    }

    @FXML
    private void handleOK() {
        card.setSuit(Card.Suit.valueOf(suit.getText()));
        card.setCardValue(Integer.parseInt(cardValue.getText()));
        card.setColor(Card.Color.valueOf(color.getText()));

        editStage.close();
    }


    public void setCard(Card card) {
        this.card = card;

        suit.setText(card.getSuit().getValue().toString());
        color.setText(card.getColor().toString());
        cardValue.setText(card.getCardValue().getValue().toString());
    }

    @FXML
    private void cancel() {
        editStage.close();
    }
}
