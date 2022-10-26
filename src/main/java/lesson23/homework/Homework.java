package lesson23.homework;

import java.io.File;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

//* Напишите коллектор который из потока целых вычисляет Double среднее значение
//Напишите функцию, которая принимает на вход путь к директории и строку фрагмент названия
// и распечатывает только файлы в имени которых есть этот фрагмент
//** Напишите функцию которая принимает на вход путь    к директории и распечатывает файлы и директории рекурсивно.
public class Homework {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5};
        Double d = avaregeDouble(ints);
        System.out.println(d);


        String path = "C:\\Users\\Anna Z\\.android";
        String name = "key";
        task2(path, name);

        String p = "D:\\TelRan\\Linux";
        task3(p);
    }

    private static void task3(String p) {

        String separator = System.getProperty("file.separator");
        File folder = new File(p);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            File newFile = new File(p + separator + file.getName());
            if (newFile.isDirectory()) {
                task3(String.valueOf(newFile));
            } else {
                System.out.println(file);
            }

        }

    }

    private static void task2(String path, String name) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.getName().contains(name)) {
                System.out.println(file.getName());
            }
        }
    }


    // T - тип того что коллектор обрабатывает, например, Student
    // A - тип аккумулятора - коллекция куда студенты записываются либо для возвращения либо для
    // дальнейшей обработки
    // R - тип возвращаемого значения - например, коллекция List<Student> либо какая-то статистика -
    private static Double avaregeDouble(int[] ints) {
        double average =
                Arrays.stream(ints)
                        .parallel()
                        .boxed()
                        .collect(new Collector<Integer, List<Integer>, Double>() {
                            // создает коллекцию для аккумулятора
                            @Override
                            public Supplier<List<Integer>> supplier() {
                                return ArrayList::new;
                            }

                            // обрабатывает входящий элемент и добавляет его в коллекцию
                            @Override
                            public BiConsumer<List<Integer>, Integer> accumulator() {
                                return List::add;
                            }

                            // сливает коллекции, возможно, созданные в нескольких потоках
                            @Override
                            public BinaryOperator<List<Integer>> combiner() {
                                return (f, s) -> {
                                    f.addAll(s);
                                    return f;
                                };
                            }

                            // производит действие над финальной коллекцией после комбайнера
                            @Override
                            public Function<List<Integer>, Double> finisher() {
                                return list -> list.stream().reduce(0, Integer::sum).doubleValue() / list.size();
                            }

                            @Override
                            public Set<Characteristics> characteristics() {
                                return Set.of(Characteristics.UNORDERED, Characteristics.CONCURRENT);
                            }
                        });

        return average;


    }

}
