package lesson4;

public class Dog extends Animals{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Gafff");
    }

    public void greets(Dog dog){
        System.out.println("Gaf Gaf");
    }
}
