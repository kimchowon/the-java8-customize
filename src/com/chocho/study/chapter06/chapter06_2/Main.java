package com.chocho.study.chapter06.chapter06_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 6-2.Executors
 */
public class Main {

    public static void main(String[] args) {

        // 쓰레드를 하나만 가지고 있는 Executor
        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor();

        // execute: 쓰레드 실행 방법 1
        singleThreadExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName());
            }
        });

        // 람다로 표현 가능
        //executorService.execute(() -> System.out.println("Thread: " + Thread.currentThread().getName()));

        // submit: 쓰레드 실행 방법 2
        singleThreadExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread: " + Thread.currentThread().getName());

            }
        });

        // 람다로 표현 가능
        //executorService.submit(() -> System.out.println("Thread: " + Thread.currentThread().getName()));

        singleThreadExecutorService.shutdown();

        // 쓰레드를 여러개 가지고 있는 Executor
        ExecutorService multiThreadExecutorService = Executors.newFixedThreadPool(2);
        multiThreadExecutorService.submit(getRunnable("Hello"));
        multiThreadExecutorService.submit(getRunnable("Chowon"));
        multiThreadExecutorService.submit(getRunnable("The"));
        multiThreadExecutorService.submit(getRunnable("Java"));
        multiThreadExecutorService.submit(getRunnable("Thread"));

        multiThreadExecutorService.shutdown();

        // 주기적인 작업을 실행하는 Executor
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS); // 3초 후에 실행
        scheduledExecutorService.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS); // 1초후에 2초 주기로 출력
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + " " + Thread.currentThread().getName());
    }
}
