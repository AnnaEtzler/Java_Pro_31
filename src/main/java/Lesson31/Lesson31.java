package Lesson31;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Lesson31 {
    public static void main(String[] args) {
        Map<String, Integer> salary = new HashMap<>();
        salary.put("Alex", 23_000);
        salary.put("Masha", 25_000);
        salary.put("Dima", 32_000);
        // распечатайте имя человека кто получает минимальную зарплату
        Optional<Map.Entry<String, Integer>> i = salary.entrySet().stream().max(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        System.out.println(i.get().getKey());



        salary.entrySet().stream() // Stream< Entry<String, Integer> >
                .min(Comparator.comparing( entry -> entry.getValue()))
                .ifPresent(
                        entry -> System.out.println(entry.getKey())
                );
    }




}
