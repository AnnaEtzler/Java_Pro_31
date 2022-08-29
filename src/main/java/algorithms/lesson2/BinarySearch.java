package algorithms.lesson2;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        char [] arr = {'h', 'e', 'l', 'l', 'o'};
        int z = 7;

        extracted(array, z);

    }

    private static void extracted(int[] array, int z) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (array[mid] == z) {
                System.out.println(mid);
                return;
            }
            if (array[mid] > z) {
                high = mid - 1;
            } else low = mid + 1;

        }
    }
}
