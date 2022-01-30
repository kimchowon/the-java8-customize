package com.chocho.study.chapter01;

@FunctionalInterface
public interface RunSomething {

    void doIt();

    //  void doIt2(); // Error!. 함수형 인터페이스는 추상메소드를 딱 하나만 가질수 있다.

    // default method
    default void printName() {
        System.out.println("chowon");
    }

    // static method
    static void printAge() {
        System.out.println("27");
    }
}
