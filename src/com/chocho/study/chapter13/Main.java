package com.chocho.study.chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 13.Callable, Future
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("-----single thread-----");
        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();

        Callable<String> greeting = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> future = singleThreadExecutorService.submit(greeting);

        //Future 작업 상태 확인하기
        System.out.println(future.isDone());
        System.out.println("Started!");

        // Future 작업 취소하기
        // true: 작업 처리중에 interrupt하여 취소, false: 작업이 끝날 때까지 기다렸다가 취소
        // true이던 false이던 cancle하면 이후에 get할 수 없다.- CancellationException 에러 발생
        // future.cancel(true);

        // blocking call: callable을 통해 값이 return 될 때까지 기다린다.
        future.get();

        System.out.println(future.isDone());
        System.out.println("End!");
        singleThreadExecutorService.shutdown();

        // Future.invokeAll: 여러 작업 동시에 실행하기
        System.out.println("-----multi thread-----");
        ExecutorService multiThreadExecutorService = Executors.newFixedThreadPool(4);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> chowon = () -> {
            Thread.sleep(6000L);
            return "chowon";
        };

        List<Future<String>> futures = multiThreadExecutorService.invokeAll(Arrays.asList(hello, java, chowon));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        // Future.invokeAny: 여러 작업 동시에 실행하지만 하나라도 먼저 완료되면 바로 종료시켜버리기
        String invokeAnyResponse = multiThreadExecutorService.invokeAny(Arrays.asList(hello, java, chowon));
        System.out.println("invokeAny : " + invokeAnyResponse);

        multiThreadExecutorService.shutdown();
    }
}
