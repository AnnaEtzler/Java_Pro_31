package Lesson28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Number> integers = new ArrayList<>(List.of(1,2,3,4,5));
        addNumbers(integers);

    }

    // Producer
    // только добавляет элементы в список
    // public static void addNumbers(List<Integer> integerList)
    public static void addNumbers(List<? super Integer> integerList)
    {
        integerList.add(new Random().nextInt());
    }

    public static void printListOfNubers(List<? extends Number> numberList){

        numberList.forEach(
                n -> System.out.println("number " + n )
        );
    }


}
