package lesson21;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Напишите функцию которая получает на вход список строк и возвращает Map ключ которой это слово,
// а значение это список номеров строк, в которых это слово встречалось (concordance)
public class Homework_20 {

    public static void main(String[] args) {
        List<String> list = List.of("Ночь, улица, фонарь, аптека",
                "Бессмысленный и тусклый свет.",
                "Живи ещё хоть четверть века —",
                "Всё будет так. Исхода нет.",

                "Умрёшь — начнёшь опять сначала",
                "И повторится всё, как встарь:",
                "Ночь, ледяная рябь канала,",
                "Аптека, улица, фонарь.");
        list = list.stream().map(x -> x.replaceAll("[—.,:-]", "")).collect(Collectors.toList());
        System.out.println(list);
        // interface Collector<T, A, R>
        // T - тип того что коллектор обрабатывает, например, Student
        // A - тип аккумулятора - коллекция куда студенты записываются либо для возвращения либо для
        // дальнейшей обработки
        // R - тип возвращаемого значения - например, коллекция List<Student> либо какая-то статистика -
        // Double если нужно посчитать средний возраст
        Map<String, List<Integer>> result = list.stream()
                .collect(new Collector<String, Map<String, List<Integer>>, Map<String, List<Integer>>>() {
                    @Override
                    public Supplier<Map<String, List<Integer>>> supplier() {
                        return HashMap::new;
                    }
                    static int num = 1;
                    @Override
                    public BiConsumer<Map<String, List<Integer>>, String> accumulator() {
                        return (map, str) -> {
                            String[] array = str.split(" ");
                            for (int i = 0; i < array.length; i++) {
                                List<Integer> li = map.containsKey(array[i]) ? map.get(array[i]) : new ArrayList<>();
                                li.add(num);
                                map.put(array[i], li);
                            }
                            num++;
                        };
                    }

                    @Override
                    public BinaryOperator<Map<String, List<Integer>>> combiner() {
                        return null;
                    }

                    @Override
                    public Function<Map<String, List<Integer>>, Map<String, List<Integer>>> finisher() {
                        return map -> map;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED, Characteristics.IDENTITY_FINISH);
                    }
                });
        System.out.println(result);

    }
}


