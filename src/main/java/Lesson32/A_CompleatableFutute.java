package Lesson32;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class A_CompleatableFutute {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture <Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread " + Thread.currentThread().getId());
            }
        });
        // блокируемся в текущем потоке и ожидаем результата
        future.get();
        System.out.println("main " + Thread.currentThread().getId());


        /// Возвращение значения
        // supplyAsync выполняется в порожденном потоке и возвращает результат
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply " + Thread.currentThread().getId());
            return "How are you?";
        }).thenApply(
                s -> s + " I'm fine"
        );

        System.out.println(cf.get());
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenAccept(s -> System.out.println(s));
}}

