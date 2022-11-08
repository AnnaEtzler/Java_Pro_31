package Lesson28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericTeter {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>( List.of(1,2,3,4,5) );
        printNumberList(integerList); // не компилируется
// внутри функции из списка только достают элементы
        /*

        List list = new ArrayList();
        list.add("hello");
        String hello = (String) list.get(0);
        System.out.println(hello);
        logValue(233);
        logValue("hjfk");


        OrderedPair<String, String> turkey = new OrderedPair<>("Turkey", "Istanbul");
        OrderedPair<String, String> turkey2 = new OrderedPair<>("Turkey", "Istanbul");
        OrderedPair<String, String> gb = new OrderedPair<>("GB", "London");
        System.out.println(equals(turkey, gb));

        System.out.println(fromArrayToList(new String[] {"Anna", "Bob", "Crishtian"}, string -> string.length() ));

        //fromArrayToList(new String[] {"Anna", "Bob", "Crishtian"});
*/
    }

    public static <T> void printNumberList(List<T> numberList)
    {
        numberList.forEach(
                n -> System.out.println("number is: " + n)
        );}

    public static <T extends Number> List<T> fromArrayToList(T [] a)
    {
        return Arrays.stream(a)
                .peek(n -> System.out.println("number: " + n.doubleValue()))
                .collect(Collectors.toList());
    }

    public static <T,R> List<R> fromArrayToList(T [] a, Function<T,R> mapper){
        return Arrays.stream(a)
                .map(mapper)
                .collect(Collectors.toList());
    }

   /* public static <T> List<T> fromArrayToList(T [] a){
        return Arrays.stream(a).collect(Collectors.toList());
    }*/

    public static <K,V> boolean equals(Pair<K, V> p1, Pair<K, V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static <T> void logValue(T t){
        System.out.println("This is a " + t.getClass().getSimpleName() + " " + t);
    }

    public static void logStringValue(String s){
        System.out.println("This is a String " + s);
    }

    public static void logDoubleValue(Double d){
        System.out.println("This is a Double " + d);
    }

}
