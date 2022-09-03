package algorithms.lesson5;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] array = {34,54,22,78,9,3,5,15};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    private static void quickSort(int [] array, int start, int end){

        if(start < end){

        int indexPivot = getIndexPivot(array,start,end);
        quickSort(array,start,indexPivot-1);
        quickSort(array,indexPivot+1, end);
        }

    }

    private static int getIndexPivot(int [] array, int start, int end){
        int pivot = array[end];
        int indexPivot = start;
       for(int i = start; i < end; i++){
           if(array[i] <= pivot){
               int temp = array[indexPivot];
               array[indexPivot] = array[i];
               array[i] = temp;
               indexPivot++;

           }

       }
        int temp = array[indexPivot];
        array[indexPivot] = array[end];
        array[end] = temp;
        return indexPivot;
    }



}
