package com.chocho.study.chapter15;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * CompletableFuture 2
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("-----<< thenCompose >>-----");
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> thenComposeFuture = hello.thenCompose(Main::getWorld);
        System.out.println("thenComposeFuture Result = " + thenComposeFuture.get());

        System.out.println("\n-----<< thenCombine >>-----");
        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> "World");

        // hello와 world를 combine
        // hello와 world의 각각 결과: (h, w)
        // result: h + " " + w
        CompletableFuture<String> combineFuture = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println("combineFuture Result = " + combineFuture.get());

        System.out.println("\n-----<< allOf >>-----");
        CompletableFuture<Integer> number = CompletableFuture.supplyAsync(() -> 10);

        /*CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(hello, number)
                .thenAccept((result) -> {
                    System.out.println(result);
                });

        voidCompletableFuture.get();*/

        List<? extends CompletableFuture<? extends Serializable>> completableFutures = Arrays.asList(hello, number);
        CompletableFuture[] futures = completableFutures.toArray(new CompletableFuture[completableFutures.size()]);

        // allOf의 인자로 array를 넣어준다.
        CompletableFuture<? extends List<? extends Serializable>> result = CompletableFuture.allOf(futures)
                .thenApply(v -> completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList()));

        result.get().forEach(System.out::println);

        System.out.println("\n-----<< anyOf >>-----");
        CompletableFuture<Void> anyOfFuture = CompletableFuture.anyOf(hello, world).thenAccept((s) -> {
            System.out.println(s);
        });

        anyOfFuture.get();

        // 예외 처리
        System.out.println("\n-----<< exceptionally >>-----");
        boolean throwError = true;
        CompletableFuture<String> exceptionallyFuture = CompletableFuture.supplyAsync(() -> {
            // 예외가 발생했다고 가정
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        System.out.println(exceptionallyFuture.get());

        System.out.println("\n-----<< handle >>-----");
        CompletableFuture<String> handleFuture = CompletableFuture.supplyAsync(() -> {
            // 예외가 발생했다고 가정
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((handleResult, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "Error!";
            }
            return handleResult;
        });

        System.out.println(handleFuture.get());
    }

    private static CompletableFuture<String> getWorld(String messge) {
        return CompletableFuture.supplyAsync(() -> messge + " World");
    }
}
