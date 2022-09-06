package lesson10.homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Homework10 {
    public static void main(String[] args) {
        String [] country = new String[]{"Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"};
        String [] word = new String[]{"Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba"};
        Set<String> setWord = new HashSet<String>(List.of(word));
        Set<String> setCountry = new HashSet<String>(List.of(country));
        setWord.retainAll(setCountry);

        for (String s : word){
            if(!s.startsWith("A")){
                setWord.remove(s);
            }

        }
        System.out.println(setWord);

    }
}
