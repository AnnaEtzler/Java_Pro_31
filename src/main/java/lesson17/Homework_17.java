package lesson17;

// напишите метод для кодирования строк. Строка состоит только из маленьких латинских букв. Пример: "aaaabbcccdaaa" -> "4a2b3c1d3a"
//* напишите метод для декодирования такой строки
//* напишите метод, который вернет true если в массиве присутствуют два числа, произведение которых даст нужное число. Пример [5,7,12, 2] , 10 -> true
//public static boolean test(int [] a, int b) (о
public class Homework_17 {
    public static void main(String[] args) {
        String s = "aaaabbcccdaaa";
        String result = encode(s);
        System.out.println(result);
    }

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
}
