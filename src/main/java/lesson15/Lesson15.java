package lesson15;

import java.util.*;

public class Lesson15 {
    public static void main(String[] args) {
        String string = "performs the given action for each entry in this map until " +
                "all entries have been processed or the action throws an exception";
        printWordFrequency(string);


}
    public static void printWordFrequency(String s){
        // разбить строку на массив строк
        // s.split(" ");
        // пробежаться по массиву и заполнить Map
        // распечатать Map
        Map<String, Integer> words = new HashMap<>();
        String [] w = s.split(" ");
        for(String word: w)
        {
            Integer number = words.get(word);
            if(number != null)
            {
                words.put(word, ++number);
            }
            else {
                words.put(word, 1);
            }
        }
        Set<String> keys = words.keySet();
        for(String word: keys)
        {
            System.out.println(word + ":" + words.get(word));
        }
    }}
