package lesson44.homework;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

//С помощью Stream-ов отфильтруйте список строк, распечатав только те из них, которые являются палиндромами -
// т.е., одинаково выглядят при чтении вперед и назад - например, "алл
public class Homework_Streams {
    public static void main(String[] args) {
//С помощью Stream-ов посчитайте сумму нечетных элементов массива целых - воспользуйтесь IntStream.range(0, ...)
// для генерации последовательности номеров элементов - подумайте, как превратить их в нечетные числа
        int result = IntStream.range(0, 10).filter(value -> value % 2 != 0).sum();
        System.out.println(result); //1 3 5 7 9 = 25


//С помощью Stream-ов отсортируйте список строк, сравнив их по подстрокам со ВТОРОГО символа по последний.
// Т.е., для элемента "Max" подстрока для сравнения должна быть "ax".
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(List.of("Anna", "Max", "Bob")); // ax nna ob

        arrayList.sort(Comparator.comparing(o -> (o.substring(1, o.length()))));
        System.out.println(arrayList);

        //С помощью Stream-ов отфильтруйте список строк, распечатав только те из них, которые являются палиндромами -
        // т.е., одинаково выглядят при чтении вперед и назад - например, "алл

        ArrayList <String> a = new ArrayList(List.of("ABBA", "baba", "odddo", "qwerty"));
        a.stream().
                filter(s -> {return new StringBuilder(s).reverse().toString().equals(s);})
                .forEach(System.out::println);
    }

}
