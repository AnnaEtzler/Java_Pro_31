package Lesson11.homework;

import java.util.*;

//First level: Напишите функцию, которая принимет на вход строку, разбивает ее на слова по пробелу
// и на выход отдает коллекцию слов-дубликатов - т.е.,
// слов, которые пристутствуют в строке более чем один раз.
// Пример: "части веб-сайтов которые вы посетили. Узнайте, как вы можете удалить его,
// чтобы исправить проблемы с работой и отображением веб-сайтов" -> ["веб-сайтов", "вы"]
//
//
//Second level: * Напишите функцию, которая принимает на вход строку,
// разбивает ее на слова по пробелу и выводит на экран каждое слово и сколько раз это слово
// встретилось в строке. Пример: "один раз это один раз" распечатать "один":2, "раз":2, "это":1
public class Homework_11 {

    public static void main(String[] args) {
        String s = "части веб-сайтов которые вы посетили. Узнайте, как вы можете удалить его, чтобы исправить проблемы с работой и отображением веб-сайтов" ;
        System.out.println(dublicate(s));


        String s2 = "один раз это один раз и еще один раз это два раза" ;
        System.out.println(dublicate2(s2));

    }
 // задание 1
    private static Collection<String> dublicate(String s) {
        String s1 = s.replaceAll("\\p{P}", "");
        String[] array = s1.split(" ");
        Set<String> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        for (String str : array) {
            if (set.contains(str)) {
                result.add(str);
            }
            set.add(str);
        }
        return result;
    }

    // задание 2
    static class Result{
        private String s;
        private int i;

        public Result(String s, int i) {
            this.s = s;
            this.i = i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public String getS() {
            return s;
        }

        public int getI() {
            return i;
        }

        @Override
        public String toString() {
            return  s + " : " + i;
        }

        public void plusI() {
            i += 1;
        }
    }



    private static Collection<Result> dublicate2(String s2) {
        String s = s2.replaceAll("\\p{P}", "");
        String[] array = s.split(" ");

        List<Result> results = new ArrayList();
        int count = 0;
        for (int i = 0; i < array.length; i++) {

            if(findInResult(array[i], results)){
                // изменить значение
                for(Result r: results){
                    if(r.getS().equals(array[i])){
                        r.plusI();
                    }
                }
            }
            else {
                // создать новый обьект и поместить его в results
                Result r = new Result(array[i], ++count );
                results.add(r);
            }
            count = 0;

        }
        return results;


    }

    private static boolean findInResult(String s, List<Result> results) {
        for (Result r: results){
            if(r.getS().equals(s)){
                return true;
            }
        }
        return false;
    }

}
