package com.chocho.study.chapter02.chapter02_1;

public class Main {

    public static void main(String[] args) {
        DefaultFoo defaultFoo = new DefaultFoo("chowon");

        defaultFoo.printName();
        defaultFoo.printNameUpperCase();

        Foo.printAnything();
    }
}
