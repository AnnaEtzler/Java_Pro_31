package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lesson34 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Rate> u = CompletableFuture.supplyAsync(new Supplier<Rate>() {
                    @Override
                    public Rate get() {
                        return Request.getRate(10, "GBP", "USD");
                    }
                })
                .thenApplyAsync(new Function<Rate, Rate>() {
                    @Override
                    public Rate apply(Rate rate) {
                        return Request.getRate(rate.rates.get("USD"), "USD", "EUR");
                    }
                });
        System.out.println(u.get());
    }
}
