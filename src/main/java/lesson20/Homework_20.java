package lesson20;

import java.util.*;

public class Homework_20 {
    // Напишите функцию которая принимает на вход список строк
    // - например, строчки из книги. Функция должна подсчитать количество уникальных слов в списке.
    //Считаем, что слова отделяются друг от друга пробелами.
    public static void main(String[] args) {
        String s = "Я к вам пишу — чего же боле?\n" +
                "Что я могу еще сказать?\n" +
                "Теперь, я знаю, в вашей воле\n" +
                "Меня презреньем наказать.\n" +
                "Но вы, к моей несчастной доле\n" +
                "Хоть каплю жалости храня,\n" +
                "Вы не оставите меня.\n" +
                "Сначала я молчать хотела;\n" +
                "Поверьте: моего стыда\n" +
                "Вы не узнали б никогда,\n" +
                "Когда б надежду я имела\n" +
                "Хоть редко, хоть в неделю раз\n" +
                "В деревне нашей видеть вас,\n" +
                "Чтоб только слышать ваши речи,\n" +
                "Вам слово молвить, и потом\n" +
                "Все думать, думать об одном\n" +
                "И день и ночь до новой встречи.\n" +
                "Но, говорят, вы нелюдим;\n" +
                "В глуши, в деревне всё вам скучно,\n" +
                "А мы… ничем мы не блестим,\n" +
                "Хоть вам и рады простодушно.";



        System.out.println("количество уникальных слов в списке " + uniqueWord(s));

    }

    private static int uniqueWord(String s) {
        String res = s.replaceAll("\n", " ").replaceAll("\\p{Punct}", "").replaceAll("—", "");
        String[] array = res.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(x -> {
                    if (map.containsKey(x)) {
                        map.replace(x, map.get(x) + 1);
                    } else {
                        map.put(x, 1);
                    }
                });
        System.out.println(map.size() + " size map"  );
        List result = new ArrayList<String>();
        map.entrySet().stream().filter(x -> x.getValue() == 1).forEach(x -> result.add(
                x.getKey()
        ));

        System.out.println("Uniqe words: ");
        System.out.println(result);


        return result.size();
    }
}
