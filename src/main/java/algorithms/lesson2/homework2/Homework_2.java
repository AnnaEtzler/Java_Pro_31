package algorithms.lesson2.homework2;

//First level: Задача 1. Дан массив, вычислить рекурсивно сумму всех элементов этого массива.
// Итоговую сумму вывести в консоль.
//
//
//Second level: Задача 1. Дан массив, написать рекурсивный метод нахождения максимального элемента в этом массиве.
// Максимальное число вывести в консоль.
public class Homework_2 {

    public static void main(String[] args) {
        int[] array = new int[]{111, 2, 3, 154, 5, 16, 17, 55};
        int i = 0;
        int summ = 0;
        System.out.println(summRekursiv(array, i, summ));

        int max = 0;
        System.out.println(searchMaxElement(array, i, max));

    }

    private static int summRekursiv(int[] array, int i, int summ) {
        summ += array[i];
        if (i == array.length - 1) {
            return summ;
        }
        return summRekursiv(array, i + 1, summ);
    }

    //private static int summArray(int[] array, int index) {
    //    if (index < 0) {
    //        return 0;
    //    }
    //    if (index == 0) {
    //        return array[0];
    //    }
    //
    //    return array[index] + summArray(array, index - 1);
    //}

    private static int searchMaxElement(int[] array, int index, int max) {
        max = Math.max(array[index], max);
        if (index == array.length - 1) {
            return max;
        }
        return searchMaxElement(array, index + 1, max);

    }

    //private static int maxArray(int[] array, int index) {
    //        if (index == 0) {
    //            return array[0];
    //        }
    //        return Math.max(array[index], maxArray(array, index - 1));
    //    }
}
