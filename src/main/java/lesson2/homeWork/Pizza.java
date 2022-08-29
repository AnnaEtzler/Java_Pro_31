package lesson2.homeWork;
//Создайте класc Pizza, поля size типа String (с возможными значениями "small", "medium", "large"), cheese:int,
// pepperoni:int,ham:int=0.
// Добавьте конструктор вида Pizza(String size, int cheese, int pepperoni, int ham),
// геттеры,сеттеры и toString. Добавьте метод calcPrice(): int - маленькая 10, средняя 12, большая 14 и каждый топпинг по 2.


import java.util.Locale;

public class Pizza {
    private String size;
    private int cheese, peperoni, ham;

    public Pizza(String size, int cheese, int peperoni, int ham) {
        this.size = size.toLowerCase();
        this.cheese = cheese;
        this.peperoni = peperoni;
        this.ham = ham;
    }
    public int calcPrice(){
        int pizzaPrice = (this.cheese+this.peperoni+this.ham)*2;
        switch (this.size) {
            case "small" -> pizzaPrice += 10;
            case "medium" -> pizzaPrice += 12;
            case "large" -> pizzaPrice += 14;
        }
        return pizzaPrice;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", cheese=" + cheese +
                ", peperoni=" + peperoni +
                ", ham=" + ham +
                '}';
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getPeperoni() {
        return peperoni;
    }

    public void setPeperoni(int peperoni) {
        this.peperoni = peperoni;
    }

    public int getHam() {
        return ham;
    }

    public void setHam(int ham) {
        this.ham = ham;
    }


}




