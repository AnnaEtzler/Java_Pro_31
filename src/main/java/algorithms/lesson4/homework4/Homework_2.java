package algorithms.lesson4.homework4;
//Даны две строки , пример abcde и dgk, слить строки в одну используя только один проход в цикле,
//элементы должны сливаться через 1, те первый элемент с первой строки, второй со второй, третий с первой и тд.
//Если какая-то строка больше чем другая, то остаток переписываем в результат.
//Метод аналогичен слиянию массивов в merge sort, но без учета сравнения элементов.

import java.util.Arrays;

public class Homework_2 {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "dgk";

        String[] result = new String[s1.length() + s2.length()]; //a d b g c k d e
        int count1 = 0;
        int count2 = 0;
        int countResult = 0;
        while (countResult < result.length) {
            if (count1 == s1.length()) {
                result[countResult] = String.valueOf(s2.charAt(count2));
                count2++;
                countResult++;
                continue;
            }
            if (count2 == s2.length()) {
                result[countResult] = String.valueOf(s1.charAt(count1));
                count1++;
                countResult++;
                continue;
            }
            if (count1 <= count2) {
                result[countResult] = String.valueOf(s1.charAt(count1));
                count1++;
            } else {
                result[countResult] = String.valueOf(s2.charAt(count2));
                count2++;
            }
            countResult++;
        }

        System.out.println(Arrays.toString(result));
    }

}
