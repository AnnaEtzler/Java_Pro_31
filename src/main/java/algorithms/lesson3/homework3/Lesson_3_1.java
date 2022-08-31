package algorithms.lesson3.homework3;

public class Lesson_3_1 {
    public static void main(String[] args) {
        int[] arr = {96, 20, 5, 15, 7, 156};
        int maxElement = maxArray(arr, 0, arr.length);
    }

    private static int maxArray(int[] array, int index, int end) {
        if(array.length < 2){
            return array.length == 0 ? -1 : array[0];
        }

        if(index == end-1){
            return array[index];
        }
        int mid = (end + index) / 2;
        int maxLeft = maxArray(array, index, mid);
        int maxRight = maxArray(array,mid,end);

        return Math.max(array[index], Math.max(maxLeft, maxRight));
    }
}
