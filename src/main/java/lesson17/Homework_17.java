package lesson17;


import java.util.Arrays;

public class Homework_17 {
    public static void main(String[] args) {
        String s = "aaaabbcccdaaa";
        String result = encode(s);
        System.out.println(result);
        String result2 = decode(result);
        System.out.println(result2);
        int [] array = {5,7,12, 1,10};
        int number = 10;
        System.out.println("test 1 " + test(array, number));
        System.out.println("test 2 " + test2(array, number));

    }


    // напишите метод для кодирования строк. Строка состоит только из маленьких латинских букв. Пример: "aaaabbcccdaaa" -> "4a2b3c1d3a"
    private static String encode(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sbResult = new StringBuilder();
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < chars.length; i = count) {
            for (int j = i; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                    count2++;
                } else {
                    break;
                }
            }
            sbResult.append(count2).append(chars[i]);
            count2 = 0;
        }
        return sbResult.toString();
    }

    //* напишите метод для декодирования такой строки
    private static String decode(String s) {
        char[] array = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            String zahl = String.valueOf(array[i]);
            int zahlResult = Integer.parseInt(zahl);
            String str = String.valueOf(array[i + 1]);
            for (int j = 0; j < zahlResult; j++) {
                sb.append(str);
            }

        }

        return sb.toString();

    }

    //* напишите метод, который вернет true если в массиве присутствуют два числа, произведение которых даст нужное число. Пример [5,7,12, 2] , 10 -> true
    public static boolean test(int [] array, int number) {
        for(int i = 0; i < array.length; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i]*array[j] == number){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean test2(int [] array, int number) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        int mid = number/2;
        mid = search(array, mid);

        for(int i = 0; i < mid; i++){
            if((array[i]*array[mid] == number) || (array[i] == 1) && (array[search(array,number)] == number)){
                return true;
            }
            mid--;
        }

        return false;
    }

    private static int search(int[] array, int z) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (array[mid] == z) {

                return mid;
            }
            if (array[mid] > z) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return mid;
    }


}
