package lesson9.Set;

import java.util.*;


public class Sets {

    public static void main(String[] args) {
        String [] words = new String[] {"One", "Two", "Three", "Four", "One", "Five", "Three"};
        // найдите дубликаты
        Set set = new HashSet(List.of(words));
        Set result = new HashSet();

        for(String s: words) {
            if (set.contains(s)) {
                set.remove(s);
            } else {
                result.add(s);
            }
        }
        System.out.println(result);

// У нас есть список стран countries = ["Andorra", "Belize", "Cayman", "France", "Argentina", "Cuba", "Sweden"]
// и есть список слов words = ["Andorra", "Canada", "First", "candy", "Argentina", "wood", "parrot", "cat", "Alan", "Cuba", "Finland", "Axelrod" , "Avangard", "Cuba"]
// нужно получить список всех стран из списка слов, начинающихся на "A" - т.е., ["Argentina", "Andorra"]


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
