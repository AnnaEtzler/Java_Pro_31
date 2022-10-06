package lesson18;
// функциональные интерфейсы

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson_18 {
    public static void main(String[] args) {
        // Function

        Map<String, Integer> nameMap = new HashMap<>();
        // Integer v = nameMap.computeIfAbsent("John", String::length);
        //  Integer v = nameMap.computeIfAbsent("John", s -> s.length());
        Integer v = nameMap.computeIfAbsent("John", new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });

        System.out.println(nameMap.get("John"));

        // Function

        Function<String, Integer> stringToLength = String::length;
        Function<Double, String> doubleString = d -> "double: " + d;

        System.out.println(doubleString.apply(334.2));


        Stream.of("John", "Max", "Alexander", "Vasilisa")
                .map(String::length)
                .forEach(System.out::println);
        // compose
        //
        // compose
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Double, String> doubleQuote = quote.compose(doubleString);
        System.out.println(doubleQuote.apply(33.4));


        // BiFunction
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 15_000);
        salaries.put("Masha", 25_000);
        salaries.put("Alex", 17_000);
        salaries.put("Samuel", 33_000);

        salaries.replaceAll(
                (name, salary) -> name.equals("Samuel") ? salary : salary + 2000
        );

        System.out.println(salaries);

        // Supplier
        // функция которая не принимает параметров но что-то возвращает
        //https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html

        Supplier<Double> lazyValue = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Math.random() * 100;
        };

        double r = lazyValue.get();
        System.out.println(r);


        // Consumer
        // Consumer
        //        // https://docs.oracle.com/javase/8/docs/api/java/util/function/LongConsumer.html
        //        // получает аргумент какого-типа и ничего не возвращает
        //        // используется для сайд-эффектов
        //        // andThen
        //        List<String> names = Arrays.asList("John", "Max", "Alexander", "Vasilisa");
        //        names.forEach(System.out::println);
        //
        //        // BiConsumer
        //        salaries.forEach(
        //                (name, salary) -> System.out.println("name: " + name+ ", salary: " + salary)
        //        );"

        List<String> names = Arrays.asList("John", "Max", "Alexander", "Vasilisa");
        names.forEach(System.out::println);

        // BiConsumer

        salaries.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("name: " + s + " salary: " + integer);
            }
        });

        // Predicate
        // тест на соответствие элемента какому либо условию
        // возвращает boolean
        // and() or() negate()
        // Predicate.not(...)
        // BiPredicate

        List<String> namesLong5 = names.stream().filter(s -> s.length() >= 5).collect(Collectors.toList());
        System.out.println(namesLong5);

        // Operator


        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        int sum = values.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }


}
