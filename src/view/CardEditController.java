package view;

import dto.Card;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        editStage.close();
    }


    public void setCard(Card card) {
        this.card = card;

        suit.setText(card.getSuit().toString());
        color.setText(card.getColor().toString());
        cardValue.setText(""+card.getCardValue());
    }

    public boolean validinput() {
        String message = null;

        try{
            Card.Suit.valueOf(suit.getText());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            message = "Choose a valid Suit";
        }

        if(message == null) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(editStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(message);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void cancel() {
        editStage.close();
    }
}
