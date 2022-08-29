package lesson7.homework;

import java.lang.reflect.Array;
import java.util.*;

public class Homework {

    public static void main(String[] args) {



        List<Integer> a1 = Arrays.asList(1,2,3);
        List<Integer> a2 = Arrays.asList(1,4,3);
        System.out.println(arrayListEquals(a1, a2));
        System.out.println(arrayListEquals2(a1, a2));
        List<String> a4 = Arrays.asList( "bbbbb","zzzzzzzzzzzzzz", "e", "e", "zz");
        System.out.println(stroka(a4));
        String [] s = {"d","h","h"};
        System.out.println(deleteDouble(s));

    }

    //ДЗ проф ява
//Напишите функцию, которая последовательно сравнивает между собой элементы из двух передаваемых в нее списков одинаковой длины.
// Если все элементы в списках попарно одинаковы, возвращает true.
// Пример: {1,2,3}, {4,5,6} -> false; {1,2}, {1,2} -> true; {1,2}, {2,1} -> false
    public static boolean arrayListEquals(List a1, List a2) {
        return a1.equals(a2);
    }


    //Напишите функцию, которая последовательно сравнивает элементы двух передаваемых в нее списков одинаковой длины
// и возвращает список строк. Пример: {1,2,3}, {1,4,3}->{"Yes", "No", "Yes"}
    public static List<String> arrayListEquals2(List<Integer> a1, List<Integer> a2) {
        ArrayList <String> arrayList = new ArrayList<>();
        for (int i = 0; i < a1.size(); ++i) {
            if (a1.get(i).equals(a2.get(i))) {
                arrayList.add("Yes");
            } else {
                arrayList.add("No");
            }
        }
        return arrayList;
    }

//* Напишите функцию которая получает на вход список строк и возвращает либо самую короткую либо саму длинную,
// в зависимости от того, какая встретилась раньше.

    public static String stroka(List<String> list) {
        List<String> buffer = new ArrayList<>(list);
        Collections.sort(buffer);
        System.out.println(buffer);
        String min = buffer.get(0);
        String max = buffer.get(buffer.size() - 1);
        int result = Math.min(list.indexOf(min), list.indexOf(max));
        return list.get(result);
    }


//  Напишите функцию, которая удаляет дубликаты из передаваемого в нее массива строк.

    public static String[] deleteDouble(String [] list){
        Set <String> set = new LinkedHashSet<String>(Arrays.stream(list).toList());
        System.out.println(set);
        String [] result = set.toArray(new String[0]);

        return result;


    }
}
