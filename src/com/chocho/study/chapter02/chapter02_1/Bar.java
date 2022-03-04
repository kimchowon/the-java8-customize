package com.chocho.study.chapter02.chapter02_1;

public interface Bar extends Foo{

    // Foo에서 제공하는 default 메소드를 Bar에서는 제공하고 싶지 않다면 다시 추상 메소드로 변경 가능
    void printNameUpperCase();
}
