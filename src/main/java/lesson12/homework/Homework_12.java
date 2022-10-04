package lesson12.homework;

import java.util.*;
//
//
//Second level: * Напишите в CustomArrayDeque итератор для перебора в обратном направлении
//
//
//
//Напишите в CustomArrayDeque итератор для перебора по убыванию значений элементов.
//
//

public class Homework_12 {

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        Set<String> s2 = new HashSet<>();
        s2.add("a");
        s2.add("b");
        s2.add("c");
        boolean b = checkSets(s1, s2);
        System.out.println(b);

        int[] array = new int[]{8, 8, 8, 8, 8, 8, 8, 1, 2, 5, 6, 8, 7, 4, 4, 4, 4, 7};
        ArrayList result = sequence(array);
        System.out.println(result);


    }

    //First level: Напишите функцию для сравнения двух сетов - boolean checkSets(Set s1, Set s2)
// - использовать любые операции кроме Set.equals()
    public static boolean checkSets(Set<String> s1, Set<String> s2) {
        if(s1 == s2){
            return true;
        }
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.size() != s2.size()){
            return false;
        }
        Iterator iterator = s1.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            String i = (String) iterator.next();
            if (s2.contains(i)) {
                count++;
            }
        }
        return count == s1.size();
        //Set<String> s3 = new HashSet<>(s1);
        //s3.retainAll(s2);
       // return  s3.size() == 0;
    }

    //Напишите  функцию, которая ищет самую длинную последовательность четных чисел
// (расположенных последовательно по порядку) в передаваемом в нее List и возвращает ее в виде Collection.
// Пример [1,2,5,6,8,7,4] -> [6,8]
    public static ArrayList sequence(int[] array) {
        List prev = new ArrayList<>();
        List result = new ArrayList();
        for (int i : array) {
            if (i % 2 == 0) {
                prev.add(i);
            } else {
                if (prev.size() > result.size()) {
                    result.clear();
                    result.addAll(prev);
                }
                prev.clear();
            }
        }
        if (prev.size() > result.size()) {
            result.clear();
            result.addAll(prev);
        }
        return (ArrayList) result;
    }
}
