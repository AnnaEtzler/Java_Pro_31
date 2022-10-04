package lesson17;




public class Homework_17 {
    public static void main(String[] args) {
        String s = "aaaabbcccdaaa";
        String result = encode(s);
        System.out.println(result);
        String result2 = decode(result);
        System.out.println(result2);
        int [] array = {5,7,12, 4,3};
        int number = 12;
        System.out.println(test(array, number));

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


}
