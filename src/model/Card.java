package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Card {
    private static final String[] numberNames = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    public enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }

    public enum Color {
        BLACK, RED
    }

    private Color color;
    private final ObjectProperty<Suit> suit;
    private final IntegerProperty cardValue;
    private boolean hidden = true;

    public Card(Suit suit, int cardValue) {
        this.suit = new SimpleObjectProperty<>(suit);
        this.cardValue = new SimpleIntegerProperty(cardValue);
        if(suit == Suit.SPADES || suit == Suit.CLUBS){
            this.color = Color.BLACK;
        }else this.color = Color.RED;
    }

    public ObjectProperty<Suit> getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit.setValue(suit);
        if(suit == Suit.SPADES || suit == Suit.CLUBS){
            this.color = Color.BLACK;
        }else this.color = Color.RED;
    }

    public IntegerProperty getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue.set(cardValue);
    }

    @Override
    public String toString() {
        if (hidden)
            return "Hidden";
        return numberNames[cardValue.getValue()-1] + " of " + suit.toString();
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isRed() {
        if (hidden) return false;
        return suit.getValue() == Suit.DIAMONDS || suit.getValue() == Suit.HEARTS;

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public boolean isBlack() {
        if (hidden) return false;
        return suit.getValue() == Suit.CLUBS || suit.getValue() == Suit.SPADES;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
