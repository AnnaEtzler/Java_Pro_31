package lesson5.homework;

public class Fact {
    private  String type;
    private int amount;

    private String text;


    public Fact(String type, int amount, String text) {
        this.type = type;
        this.amount = amount;
        this.text = text;
    }

    public String getAnimal_type() {
        return type;
    }

    public void setAnimal_type(String animal_type) {
        this.type = animal_type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
