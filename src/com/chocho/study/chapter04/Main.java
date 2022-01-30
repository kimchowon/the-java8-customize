package com.chocho.study.chapter04;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 메소드 레퍼런스
 */
public class Main {

    public static void main(String[] args) {
        // 인라인으로 결과를 람다에서 직접 구현하는 방법
        UnaryOperator<String> hi = (s) -> "hi, " + s;

        // 메소드 레퍼런스 - static 메소드 참조
        UnaryOperator<String> hi2 = Greeting::hi;

        // 메소드 레퍼런스 - 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        // 메소드 레퍼런스 -> 생성자 참조(매개변수 없는 생성자)
        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        // 메소드 레퍼런스 -> 생성자 참조(매개변수 있는 생성자)
        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting chowonGreeting = newGreeting2.apply("chowon");
        System.out.println("name = " + chowonGreeting.getName());

        // 임의 객체의 인스턴스 메소드 참조
        String[] names = {"namsook", "chowon", "hyunho"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
