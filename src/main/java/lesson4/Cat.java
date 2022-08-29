package lesson4;

public class Cat extends Animals{

    public Cat(String name) {
        super(name);
    }

    @Override
    public void greets() {
        System.out.println("Miau");
    }
}
