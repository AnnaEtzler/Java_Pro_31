package algorithms.lesson3.homework3;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.reflect.Array.get;

//мея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
//который будет находиться на k-й позиции в конечном отсортированном массиве.
//Массив 1 - 100 112 256 349 770
//Массив 2 - 72 86 113 119 265 445 892
//к = 7
//Вывод : 256
//Окончательный отсортированный массив -
//72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//7-й элемент этого массива равен 256.
public class Homework_3_2 {


    public static void main(String[] args) {
        int[] m = {100, 112, 256, 349, 770};
        int[] n = {72, 86, 113, 119, 265, 445, 892};
        int k = 7;


        int[] array = merge(m,n);

        System.out.println(Arrays.toString(array));
        System.out.println(get(array, k));


    }

    private static int[] merge(int[] m, int[] n) {
        int[] result = new int[m.length + n.length];
        int countM = 0;
        int countN = 0;
        int countResult = 0;
        while (countResult < result.length) {
            if (countM == m.length) {
                result[countResult] = n[countN];
                countN++;
                countResult++;
                continue;
            }
            if (countN == n.length) {
                result[countResult] = m[countM];
                countM++;
                countResult++;
                continue;
            }
            if (m[countM] <= n[countN]) {
                result[countResult] = m[countM];
                countM++;
            } else {
                result[countResult] = n[countN];
                countN++;
            }
            countResult++;
        }

        return result;
    }
}
