package lesson19;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTester {
    public static void main(String[] args) {
        // Stream API: Stream, primitive streams. Intermediate and Terminal operations.
        List<Integer> years = List.of(2000, 2022, 2021, 2027);
        Stream<Integer> yearsStream = years.stream();
        yearsStream
                .filter(y -> y % 2 == 0)
                .filter(y -> y > 2010)
                .forEach(System.out::println);

        List<String> list = List.of("Alexander", "MAx", "Xenia", "Maria");

        list.stream()
                .filter(x -> x.contains("n"))
                .forEach(x1 -> System.out.println(x1));


        // Создание потока
        // Collection.<T>stream() мз коллекции
        // Arrays.stream(new INteger[]{1,2,3})
        // Stream.of()



        /////////////////////////////

        list.stream()
                .map((Function<String, Integer>) String::length)
                .forEach(x -> System.out.print(" "+ x));
        System.out.println();

        list.stream()
                .map(s -> s + ":" + s.length())
                .sorted()
                .forEach(System.out::println);



        int sum = Arrays.stream(new Integer[] {2,6,3,5})
                .reduce(1, (perv, curr) -> perv * curr);
        System.out.println(sum);


    }

}
