package com.chocho.study.chapter02.chapter02_1;

/**
 * 2-1.인터페이스 기본 메소드와 스태틱 메소드
 */
public class Main {

    public static void main(String[] args) {
        DefaultFoo defaultFoo = new DefaultFoo("chowon");

        defaultFoo.printName();
        defaultFoo.printNameUpperCase();

        Foo.printAnything();
    }
}
