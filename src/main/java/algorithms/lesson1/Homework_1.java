package algorithms.lesson1;
//First level: Задача на сортировку : Отсортировать по алфавиту список студентов группы.
//        1.Задать массив строк с произвольными фамилиями студентов, достаточно будет массива из 10-15 элементов.
//        (изначально, элементы в массиве должны быть в произвольном порядке)
//        2.Используя Bubble sort отсортировать все элементы массива по алфавиту , в порядке от A до Z.
//        Для тех кто будет использовать Java, посмотрите на метод compareTo у класса String, который возвращает
//        целочисленное значение для сравниваемых строк, это может быть число меньше 0,0, число больше 0, в зависимости от того как две строки равны между собой, при сравнении именно будет использоваться именно лексикографический порядок, то что нужно.
//        3.Отсортированный массив вывести в консоль, в виде : на отдельной строке : порядковый номер в списке - фамилия.
//        4.Результат можно прислать в в виде ссылки не решение на гитхабе или ссылки на файловый архив.

import java.util.Arrays;

public class Homework_1 {
    public static void main(String[] args) {
        String[] surname = {"Volkov", "Davalina", "Efimov", "Gigulev", "Baigugina", "Ershov", "Boldin", "Annushkina", "Pivovarov"};
        for (int i = 0; i < surname.length; ++i) {

            for (int j = 0; j < surname.length - i - 1; ++j) {
                if ( 0 < surname[j].compareTo(surname[j + 1])) {
                    String temp = surname[j];
                    surname[j] = surname[j + 1];
                    surname[j + 1] = temp;


                }
            }
        }
        int count = 0;
       for (String s: surname){
           System.out.println(++count + ") " + s);
       }

        System.out.println();


       //Second level: Выполнить аналогичное задание с помощью сортировки Выбором(Selection).

        for (int i = 0; i < surname.length; ++i){
            int maxPos = i;
            for (int j = i; j < surname.length; ++j){
                if ( 0 > surname[j].compareTo(surname[maxPos])){
                    maxPos = j;
                }
            }
            String temp = surname[i];
            surname[i] = surname[maxPos];
            surname[maxPos] = temp;
        }

        int count2 = 0;
        for (String s: surname){
            System.out.println(++count2 + ") " + s);
        }
    }





}
