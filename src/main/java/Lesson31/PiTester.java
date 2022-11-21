package Lesson31;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class PiTester {

    private static int yes = 0;
    private static int no = 0;
    private static Random random = new Random();

    public static void main(String[] args) {
        runner(2);
        yes = 0;
        no = 0;
        runner(5);
        yes = 0;
        no = 0;
        runner(10);
        yes = 0;
        no = 0;
        runner(20);
        yes = 0;
        no = 0;
        runner(50);



    }

    private synchronized static void addYes() {
        yes++;
    }

    private synchronized static void addNo() {
        no++;
    }

    static void runner(int numberOfThreads) {
        long before = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        IntStream.range(0, 1_000_000)
                .forEach(
                        i -> service.submit(new PiRunnable())
                );

        service.shutdown();
        try {
            service.awaitTermination(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {

        }
        long after = System.currentTimeMillis();
        System.out.println("n: " + numberOfThreads + " pi: " + 4.0 * yes / (yes + no) +
                " y: " + yes + " n: " + no + " s: " + (yes + no) + " time " + (after - before));
    }

    static class PiRunnable implements Runnable {
        @Override
        public void run() {
            double x = random.nextDouble();
            double y = random.nextDouble();
            double r = Math.sqrt(x * x + y * y);
            if (r <= 1.0)
                //yes++;
                addYes();
            else
                //no++;
                addNo();
        }
    }

}