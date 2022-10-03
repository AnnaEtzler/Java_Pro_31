package lesson12.homework;

public class ExeptionTester {
    public static void main(String[] args) /*throws MyException*/ {
        try {
            fun();
        } catch (MyException e) {
            //
        }
    }
    // Exception (исключение) это спецальная ситуация или ошибка
    // которая возникала в процессе работы программы
    // выбрасываются JVM либо кодом

    // Error выбрасывается JVM
    // например OutOfMemoryError
    // выполнение программы невозможно
    // перехватить нельзя


    // RuntimeException
    // пример IndexOutOfBounds ArithmeticException
    // ошибка програмиста
    // unchecked (не проверяемые) - перехватить можно, но нужно ли?
    // необходимости обрабатывать их нет

    // исключения производные от
    // Exception нужно обрабатывать
    // checked (проверяемые) - нужно ли перехватывать используя try-catch либо пробрасывать дальше
    // где его должна обработать вызвавшая наш код функция
    public static void fun() throws MyException {
//        try {
        System.out.println(divide(14,2));
        System.out.println(divide(10,0));
        System.out.println(divide(3,8));
//        }
//        catch (MyException e)
//        {
//            System.out.println("Caught MyException");
//        }
        System.out.println("Exit");
    }

    public static int divide(int a , int b) throws MyException { // произволный от Exception
        if(b == 0)
            throw new MyException("Division by zero");
        return a/b;
    }

    public static class MyException extends Exception {
        public MyException() {
            super();
        }
        public MyException(String message)
        {
            super(message);
        }
    }
}
