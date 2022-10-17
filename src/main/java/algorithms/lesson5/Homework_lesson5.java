package algorithms.lesson5;

import java.util.Arrays;

//First level: Сделать возможным выбирать различные опорные элементы для быстрой сортировки. Исправить для этого код урока.
//
//
//Second level: Привести пример худшего случая , в каком виде должны быть входные данные.
public class Homework_lesson5 {
    public static void main(String[] args) {

        int[] array = {34, 54, 22, 78, 9, 3, 5, 15};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;
        if (low >= high)
            return;

        int p = low + (high - low) / 2;

        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < array[p]) {
                i++;
            }
            while (array[j] > array[p]) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(array, low, j);
        }


        if (high > i) {
            quickSort(array, i, high);
        }

    }


}
