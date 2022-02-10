package com.chocho.study.chapter11;

/**
 * Concurrent 프로그래밍
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 멀티 쓰레드 프로그래밍 방법
        // 1.Thread 상속
       /* HelloThread helloThread = new HelloThread();
        helloThread.start();

        System.out.println("hello : " + Thread.currentThread().getName());*/

        // 2.Runnable 구현
/*        Thread thread = new Thread(() -> System.out.println("world : " + Thread.currentThread().getName()));
        thread.start();
        System.out.println("hello : " + Thread.currentThread().getName());*/

        // 3.쓰레드 주요 기능
        // 1) sleep: 현재 쓰레드 멈춰두기
/*        Thread currentThread = new Thread(() -> {
           try {
               Thread.sleep(1000L);
           } catch (InterruptedException e) { // 현재 쓰렏가 자고 있는데 깨웠을 때 catch문 실행
               e.printStackTrace();
           }
            System.out.println("Thread: " + Thread.currentThread().getName());
        });
        currentThread.start();

        System.out.println("hello : " + Thread.currentThread().getName());*/

        // 2) interrupt: 다른 쓰레드 깨우기
/*        Thread interruptThread = new Thread(() -> {
            while (true) {
                System.out.println("Thread : " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("exit!");
                    return;
                }
            }
        });

        interruptThread.start();

        System.out.println("hello : " + Thread.currentThread().getName());
        Thread.sleep(1000L);
        interruptThread.interrupt();*/

        // 3) join: 다른 쓰레드 기다리기
        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000L);
            }catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        thread.join();
        System.out.println(thread + "is finished.");
    }

    static class HelloThread extends Thread {

        @Override
        public void run() {
            System.out.println("world : " + Thread.currentThread().getName());
        }
    }
}
