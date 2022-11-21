package Lesson31;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Класс представляющий собой поток выполнения
        Thread t1 = new Thread() {
            @Override
            public void run() {
                // код в функции run выполняется в порожденном потоке
                // порожденный поток работает пока не закончилась run
                try {
                    Thread.sleep(300); // милисекунды
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long threadId = Thread.currentThread().getId();
                System.out.println("hello from thread " + threadId);
            }
        };
        t1.setDaemon(true); // не будет дожидаться окончания этого потока
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start(); // создает новый поток и запускает в нем метод run


        long mainThreadId = Thread.currentThread().getId();
        System.out.println("hello from main " + mainThreadId);


        Runnable r1 = new MyRunnable2();
    /*    new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();
        new Thread(r1).start();*/

        Callable c = new MyCallable();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future <String> res = service.submit(c);
        Thread.sleep(2000);
        if( res.isDone()){
            System.out.println("result is " + res.get());
        }
        else {
            System.out.println("result is not available");
        }



       // Runnable rr = new MyRunnable2();

      //  IntStream.range(0, 5).forEach(i -> service.submit(rr));
        service.shutdown();
    }
}



class MyRunnable implements Runnable {
    private String text;
    public MyRunnable(String text)
    {
        this.text = text;
    }
    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        System.out.println("hello from runnable " + threadId);
    }
}
class MyRunnable2 implements Runnable{


    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(System.currentTimeMillis() + " number " + Thread.currentThread().getId());

    }
}

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "hello from callble " + System.currentTimeMillis();

    }
}