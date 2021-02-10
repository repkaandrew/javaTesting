package ua.repka;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Standard realization trough runnable
        Runnable task1 = () -> {
            System.out.println("Hello from new thread");
        };
        new Thread(task1).start();

        // Callable realization
//        FutureTask<String> future = new FutureTask<>(new Callable<String>() {
////            @Override
////            public String call() throws Exception {
////                return "Hello from callable";
////            }
////        });
        FutureTask<String> future = new FutureTask<>(()->"Hello from callable");
        new Thread(future).start();
        System.out.println(future.get());
        System.out.println("Hello from main thread");

        //CompletableFuture
        AtomicLong longValue = new AtomicLong(0);
        Runnable task2 = () -> longValue.set(new Date().getTime());
        Function<Long, Date> dateConverter = (longvalue) -> new Date(longvalue);
        Consumer<Date> printer = date -> {
            System.out.println(date);
            System.out.flush();
        };
        // CompletableFuture computation
        CompletableFuture.runAsync(task2)
                .thenApply((v) -> longValue.get())
                .thenApply(dateConverter)
                .thenAccept(printer)
                .get();
    }
}
