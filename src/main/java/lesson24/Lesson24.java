package lesson24;

import java.util.*;
import java.util.function.Function;

public class Lesson24 {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,9,8,7,6,5,4,3,2,1,0);
        int result  = sumLastN(list,5);
        System.out.println(result);
        List<String> months = List.of("january", "february", "march", "june", "march");
        System.out.println(filterList(months, "r")); // {"january", "february", "march"}

        List<String> names = List.of("Max", "Masha", "Daria", "Alex", "Sam");
        System.out.println(getStringLengthFrequency(names)); // {3:2, 4:1, 5:2}

        Car c1 = new Car("Mitsubishi", "Lancer", 33_000);
        Car c2 = new Car("Mitsubishi", "Lancer Evo 4", 64_000);
        Car c3 = new Car("Subaru", "WRX STI", 62_000);
        Car c4 = new Car("Subaru", "Forrester", 23_000);
        Car c5 = new Car("Nissan", "GTR", 73_000);
        Car c6 = new Car("Mitsubishi", "Gallant", 14_000);
        List<Car> cars = List.of(c1,c2,c3,c4,c5,c6);
        System.out.println(sortCars(cars));



    }
    public static int sumLastN(List<Integer> list, int n){
        int skip = Math.max(list.size()-n, 0);
        return list.stream().skip(skip).reduce(0, Integer::sum);
    }

    public static Set<String> filterList(List<String> list, String pattern ){
        Set<String> res = new HashSet<>();
        list.stream().filter(x -> x.contains(pattern)).forEach(x -> res.add(x));
        return res;
       // return list.stream().filter(s -> s.contains(pattern)).collect(Collectors.toSet());
    }

    public static Map<Integer, Integer> getStringLengthFrequency(List<String> list)
    {
        Map<Integer, Integer> res = new HashMap<>();
        for(String word: list)
        {
            Integer count = res.get(word.length());
            if(count == null)
                count = 0;
            count++;
            res.put(word.length(), count);
        }
        return res;
    }

    public static TreeMap<String, List<Car>> sortCars(List<Car> cars){
        TreeMap<String, List<Car>> res = new TreeMap<>();
        cars.forEach(x ->
        {
            if(res.containsKey(x.maker)){
                List<Car> lc = res.get(x.maker);
                lc.add(x);
                lc.sort((o1, o2) -> (int) (  o2.price - o1.price));
                res.put(x.maker, lc);
            }
            else {
                List<Car> l = new LinkedList<>();
                l.add(x);
                res.put(x.maker, l);
            }


        });


        return res;
    }
}


