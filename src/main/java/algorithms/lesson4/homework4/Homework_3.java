package algorithms.lesson4.homework4;

//Дан отсортированный по возрастанию массив, все элементы этого массива уникальные.
//Дано целое число n , написать метод, который вернет n-й отсутствующий элемент в массиве.
//Например дан массив: [4,7,9,10,14]
//n = 1, вернуть первый отсутствующий элемент : ответ 5.
//n = 2, вернуть второй отсутствующий элемент : ответ 6
//n = 3, вернуть третий отсутствующий элемент : ответ 8
public class Homework_3 {
    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 9, 10, 14};
        int n = 7;
        int result = missingElement(array, n);
        System.out.println(result);

    }

    private static int missingElement(int[] array, int n) {
        if (n == 0) {
            return array[0] - 1;
        }
        if (n > array.length) {
            return array[0] + n + array.length - 1;
        }
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            int difference = array[i + 1] - array[i];
            for (int j = 1; j < difference; j++) {
                if (count == n) {
                    return array[0] + count + i;
                }

                count++;
            }


        }
        return 0;
    }

}
