package com.chocho.study.chapter03;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 3.람다 표현식
 */
public class Main {
    public static void main(String[] args) {
        // 인자가 없을 때
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get());

        // 인자가 한개일 때
        Consumer<String> printName1 = (name) -> System.out.println("My name is " + name);
        Consumer<String> printName2 = name -> System.out.println("My name is " + name);
    }
}
