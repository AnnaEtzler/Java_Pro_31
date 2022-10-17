package Lesson16;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

// ** Написать метод, принимающий на вход список слов и возвращающий TreeMap
// с ключами в виде первой буквы и отсортированного по возрастанию
// TreeSet со словами в которых эта буква первая.
//
//
//Пример: ["Hello", "Hell", "World"] -> {"H": ["Hell", "Hello"],  "W":["World"]}
public class Homework {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hell");
        list.add("World");
        TreeMap result = tree(list);
        System.out.println(result);
    }

    private static TreeMap tree(List<String> l) {
        l.sort(String::compareTo);

        TreeMap<String, TreeSet<String>> result = new TreeMap<>();

        l.stream().forEach(s -> {
            TreeSet<String> treeSet;
            String s1 = String.valueOf(s.charAt(0));
            if(result.containsKey(s1))
            {
                treeSet = result.get(s1);
                treeSet.add(s);
            } else {
                treeSet = new TreeSet<>();
                treeSet.add(s);
            }
            result.put(s1, treeSet);
        }
        );
        return result;
    }
}
