package algorithms.lesson4.homework4;
//Повторить алгоритм сортировки слиянием, результатом должен стать целочисленный массив отсортированный в порядке убывания.
import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] n = {892, 72, 265, 86, 119, 113, 445};
        mergeSort(n, n.length);
        System.out.println(Arrays.toString(n));
    }

    private static void mergeSort(int[] array, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = array[i];
        }
        mergeSort(left, mid);
        mergeSort(right, length - mid);
       //merge(left, right, array);
        merge2(left, right, array);

    }

    private static void merge(int[] one, int[] two, int[] array) {
        int indexOne = 0;
        int indexTwo = 0;

        for (int i = 0; i < array.length; i++) {
            if (indexOne < one.length && indexTwo < two.length) {
                int elementOne = one[indexOne];
                int elementTwo = two[indexTwo];
                if (elementOne < elementTwo) {

                    array[i] = elementOne;
                    indexOne++;
                } else {

                    array[i] = elementTwo;
                    indexTwo++;
                }
                continue;
            }
            if (indexOne < one.length) {
                array[i] = one[indexOne];
                indexOne++;
            }
            if (indexTwo < two.length) {
                array[i] = two[indexTwo];
                indexTwo++;
            }

        }

    }

    private static void merge2(int[] one, int[] two, int[] array){
        int indexOne = 0;
        int indexTwo = 0;
        int i = 0;
        while (indexOne < one.length && indexTwo < two.length){
            if(one[indexOne] < two[indexTwo]){

                array[i++] = one[indexOne++];
            } else {

                array[i++] = two[indexTwo++];
            }
        }

        while (indexOne < one.length){
            array[i++] = one[indexOne++];

        }
        while(indexTwo < two.length){
            array[i++] = two[indexTwo++];
        }

    }
}
