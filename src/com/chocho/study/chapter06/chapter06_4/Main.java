package com.chocho.study.chapter06.chapter06_4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 6-4.CompletableFuture 1
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 리턴값이 없는 경우: runAsync
        System.out.println("-----<< runAsync >>-----");
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> System.out.println("Hello runAsync: " + Thread.currentThread().getName()));
        runAsyncFuture.get();

        // 리턴값이 있는 경우: supplyAsync
        System.out.println("\n-----<< supplyAsync >>-----");
        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello supplyAsyncFuture: " + Thread.currentThread().getName());
            return "Hello!";
        });

        System.out.println("supplyAsyncFuture = " + supplyAsyncFuture.get());

        // callback 기능
        System.out.println("\n-----<< thenApply >>-----");
        CompletableFuture<String> thenApplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello thenApplyFuture: " + Thread.currentThread().getName());
            return "Hello!";
        }).thenApply((s) -> {
            System.out.println("Hello thenApplyFuture: " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println("thenApplyFuture = " + thenApplyFuture.get());

        System.out.println("\n-----<< thenAccept >>-----");
        CompletableFuture<Void> thenAcceptFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello thenAcceptFuture: " + Thread.currentThread().getName());
            return "Hello!";
        }).thenAccept((s) -> {
            System.out.println("Hello thenAcceptFuture: " + Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        thenAcceptFuture.get();

        System.out.println("\n-----<< thenRun >>-----");
        CompletableFuture<Void> thenRunFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello thenRunFuture: " + Thread.currentThread().getName());
            return "Hello!";
        }).thenRun(() -> {
            System.out.println("Hello thenRunFuture: " + Thread.currentThread().getName());
        });

        thenRunFuture.get();

        System.out.println("\n-----<< 쓰레드풀 변경하기 >>-----");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture<String> modifyThreadPoolFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello modifyThreadPoolFuture: " + Thread.currentThread().getName());
            return "Hello!";
        }, executorService).thenApplyAsync((s) -> {
            System.out.println("Hello modifyThreadPoolFuture: " + Thread.currentThread().getName());
            return s.toUpperCase();
        }, executorService);

        System.out.println("modifyThreadPoolFuture = " + modifyThreadPoolFuture.get());
        executorService.shutdown();
    }
}
