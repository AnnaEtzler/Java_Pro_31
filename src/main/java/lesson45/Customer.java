package lesson45;

public class Customer {
    private int id;
    private String city;
    private String name;
    private int rating;
    private int snum;

    public Customer(){}

    public Customer(int id, String name, String city, int rating, int snum) {
        this.id = id;
        this.city = city;
        this.name = name;
        this.rating = rating;
        this.snum = snum;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getSnum() {
        return snum;
    }
}
