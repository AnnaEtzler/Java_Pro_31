package Lesson31;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SynchroTest {
    public static int data [] = {0};
private static final Object lock = new Object();
     public static void add(){
         synchronized (lock) {
             int j = data[0];
             j++;
             data[0] = j;
         }
    }

    public static void main(String[] args) throws InterruptedException {
       Runnable r = new MyRunnable();
        //new Thread(r).start();
        //Arrays.stream(data).forEach(System.out::println);

       // IntStream.range(0, 5).forEach(i -> new Thread(r).start());
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(data[0]);

    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            add();
            for (int i = 0; i < 1000000; ++i){
                add();

            }
            System.out.println("поток финиш");
        }
    }
}
