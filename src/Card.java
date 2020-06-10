public class Card {

    String type;
    int value;

    public Card(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public Card(int value, String type){
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
