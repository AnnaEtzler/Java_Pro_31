package Lesson31.homework;

import java.util.Random;
import java.util.concurrent.*;

import static Lesson31.homework.Homework.add;

// Вычислите многопоточно число pi - инструкции ниже
//Заведите два целых счетчика -
// один для точек, для которых вычисленное расстояние до начала координат R меньше  1.0 ("yes" счетчик)
// и второй счетчик для тех точек, для которых вычисленное расстояние до начала координат R больше 1.0
//Создайте производный от Runnable класс и внутри run метода напишите:
//Сгенерируйте с помощью генератора случайных чисел два double числа из диапазона [0.0 - 1.0] - x и y координаты точки
//С помощью теоремы Пифагора вычислите для нее расстояние от начала координат - R.
//Если для сгенерированой точки расстояние R до начала координат меньше 1.0 то увеличивайте на единицу счетчик "yes"; если R больше 1.0 увеличивайте на единицу счетчик "no".
//Создайте и запустите 1_000_000 таких Runnable через ExecutorService
//По результатам эксперимента вычислите значение pi как 4.0*yes/(yes+no)
public class Homework {

    private static int  yes = 0;
    private static int  no = 0;

    private static final Object lock = new Object();

    public static void add(double R)
    {
        synchronized (lock) { // синхронизируется на поле lock
            if (R < 1.0) {
                Homework.yes++;
            } else {
                Homework.no++;
            }
        }
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new Thread(new Pi());
        ExecutorService service = Executors.newFixedThreadPool(1_000_000);
        Future future = service.submit(new Pi());
        Thread.sleep(2000);
        double v = 0.4 * yes / (yes + no);
        System.out.println(v);


        service.shutdown();


    }
}


class Pi implements Runnable {



    @Override
    public void run() {
        double x = new Random().nextDouble(1);
        double y = new Random().nextDouble(1);
        double R = Math.sqrt(x * x + y * y);
        add(R);

    }
}