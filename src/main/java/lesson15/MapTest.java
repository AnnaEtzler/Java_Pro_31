package lesson15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // LinkedHashMap на основе хэш таблицы + элементы возвращаются при обходе в порядке вставки
        // TreeMap элементы отсортированы по компаратору
    /*
        class Entry {
            K key;
            V value;
            Entry next;
        }
     */

    // хэш - отображение объекта в какое-то целое число
    // хэш-функция int hashCode()
    // ключ -> целое
    // vasya -> 123       123 % source.length = 123 % 9 = 6
    // masha -> 468       486 % 9  = 0
    // konstantin -> 123
    // эквивалентность ключей означает равенство хэшкодов
    // если хэш коды одинаковы, то это не значит что ключи эквивалентны
    // vasya.hashCode() == konstantin.hashCode != vasya.eqals(konstantin)=true
    // vasya.eqals(konstantin)==true -> vasya.hashCode() == konstantin.hashCode()

        Map<String, String> capitals = new HashMap<>();
        capitals.put("Germany", "Berlin");
        System.out.println(capitals.get("Germany"));
        System.out.println(capitals.get("Belgium"));
        capitals.put("Germany", "Frankfurt");
        System.out.println(capitals.get("Germany"));
        capitals.remove("Germany");
        System.out.println(capitals.get("Germany"));
        System.out.println(capitals.size());
        capitals.put("GB", "London");

        Iterator<Map.Entry<String, String>> it = capitals.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> e = it.next();
            System.out.println(e.getKey() );
        }

        String string = "performs the given action for each entry in this map until " +
                "all entries have been processed or the action throws an exception";

        Map<String, Integer> map = foo(string);
        System.out.println(map);


    }

    private static Map foo(String string) {
        Map<String, Integer> map = new HashMap<>();
        String [] array = string.split(" ");
        for (String s: array){
            if(map.containsKey(s)){
                Integer i = map.get(s);
                i += 1;
                map.replace(s, i);
            } else {
                map.put(s, 1);
            }
        }
        return map;

    }


}
