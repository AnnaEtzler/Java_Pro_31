package algorithms.lesson3.homework3;
//Имея отсортированный массив arr[] и число x, напишите функцию, которая подсчитывает вхождения x в arr[].
//Ожидаемая временная сложность O(log n)
//arr[] = {1, 1, 2, 2, 2, 2, 3,}
//x = 2
//Вывод: 4 раза

public class Homework_3_3 {

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(search(arr, x));
    }

    private static int search(int[] array, int x) {
        int result = 0;
        if (x == array[array.length / 2]) {
            result = searchAround(array, x, array.length / 2);
        } else {
            int low = 0;
            int high = array.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;

                if (array[mid] == x) {
                    result = searchAround(array, x, mid);
                    return result;
                }
                if (array[mid] > x) {
                    high = mid - 1;
                } else low = mid + 1;

            }
        }
        return result;
    }

    private static int searchAround(int[] array, int x, int mid) {
        int result = 1;
        int left = mid - 1;
        int right = mid + 1;
        if (left >= 0) {
            while (array[left] == x) {
                result++;
                left--;
                if (left == -1) {
                    break;
                }
            }
        }
        if (right < array.length) {
            while (array[right] == x) {
                    result++;
                    right++;
                    if (right == array.length) {
                        break;
                    }
                }
            }
        return result;
    }

}
