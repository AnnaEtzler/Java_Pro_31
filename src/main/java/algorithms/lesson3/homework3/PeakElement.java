package algorithms.lesson3.homework3;

public class PeakElement {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 9, 12, 15, 14, 12, 10, 6};

    }

    private int findMax(int [] array, int left, int right){
        if(left == right){
            return array[left];
        }
        if(right-left == 1){
            return Math.max(array[left], array[right]);
        }
        int mid = (left + right) / 2;
        if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
            return array[mid];
        }
        if(array[mid] > array[mid - 1]){
            return findMax(array, mid+1,right);
        } else {
            return findMax(array, left,mid-1);
        }

    }


}
