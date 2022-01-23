package com.chocho.study.chapter01;

public class Foo {

    public static void main(String[] args) {
        // java8 이전
        // 익명 내부 클래스(anonymous inner class)
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("Hello. Functional Interface.");
            }
        };
        runSomething.doIt();

        // java8부터 람다 형태로 줄여서 쓸 수 있다.
        RunSomething runSomething2 = () -> System.out.println("Hello. Functional Interface.");
        runSomething2.doIt();

        // 메소드 코드가 한줄 이상인 경우
        RunSomething runSomething3 = () -> {
            System.out.println("Hello.");
            System.out.println("Functional Interface.");
        };
        runSomething3.doIt();
    }
}
