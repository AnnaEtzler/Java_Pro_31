package algorithms.lesson3.homework3;
//1.Даны два целых числа x и n, напишите функцию для вычисления x^n (x в степени n)
//Первое решение выполнить рекурсивно за временную сложность O(n) - лиейная
//Второе решение это улучшить решение 1 до временной сложности O(log n) логарифмическая

public class Homework_3_1 {

    public static void main(String[] args) {
        int x = 3;
        int n = 4;
        System.out.println(task1_1(x, n));
        System.out.println(task1_2(x, n));


    }

    public static int task1_1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        return x * task1_1(x, n - 1);
    }

    public static int task1_2(int x, int n) {
        String s = Integer.toBinaryString(n);
        String[] array = s.split("");
        int result = x;
        for (int i = array.length - 1; i >= 0; i--) {
            if (Integer.parseInt(array[i]) != 0) {
                result = Integer.parseInt(array[i]) * x;
                result = result * result;
            } else {
                result = result * result;
            }
            result *= result;
        }
        return result;


    }


}
