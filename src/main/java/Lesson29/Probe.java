package Lesson29;

import lesson24.Car;

public class Probe {

    public static Object getCar()
    {
        return new Car("Peugeot", "407", 20_000);
    }

    public static String getMessage(int i){
        return i > 5 ? "Hello" : "World";
    }
}
