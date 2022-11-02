package lesson24.homework;




public class Homework24 {


    public static void main(String[] args) {
        String s = "abc Abc Eeer ii j Ik";
        String number = "+123456";
        String s2 = "расходы 20 доходы 50.3 ";
        task1(s);
        task2(number);
        task3(s2);


    }
    //**Если в строке встречается число без десятичной точки , то добавьте этой цифре ".0" .
    // Пример: "расходы 20 доходы 50.3" -> "расходы 20.0 доходы 50.3"

    private static void task3(String s2) {
        String [] array = s2.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : array){
            if (s.matches("\\D+") || s.matches("\\d+\\.\\d+") ) {
                sb.append(s).append(" ");
            }else if (s.matches("\\d+")){
                sb.append(s).append(".").append("0").append(" ");
            } else {
                sb.append(s);
            }
        }
        System.out.println(sb);

     }
    //Напишите метод, который проверяет, что строка является телефонным номером - номер начинается с опционального плюса а дальше 6 цифр
    private static void task2(String number) {
        System.out.println(number.matches("[+]\\d{6}"));
    }

    //Напишите метод, который удаляет из строки все гласные в любом регистре
    private static void task1(String s) {
       // A, E, I, O, U, Y
        String result = s.replaceAll("[aeiouyAEIOUY]","");
        System.out.println(result);
    }
}
