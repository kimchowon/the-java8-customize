package com.chocho.study.chapter01.chapter01_2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 1-2.java 8에서 제공하는 함수형 인터페이스
 */
public class Main {

    public static void main(String[] args) {
        // 1.Function
        Plus10 plus10 = new Plus10();
        Integer sum = plus10.apply(5);
        System.out.println("sum = " + sum);

        // 객체 생성 없이 바로 인터페이스 사용
        Function<Integer, Integer> plus10_2 = (number) -> number + 10;
        Integer sum2 = plus10_2.apply(5);
        System.out.println("sum_2 = " + sum2);

        // Function 인터페이스의 compose 메소드
        Function<Integer, Integer> multiply2 = (number) -> number * 2;

        // multiply2 함수를 인자로 넘겨줌. compose 메소드는 고차 함수
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println("multiply2AndPlus10 = " + multiply2AndPlus10.apply(2));

        // andThen 메소드
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2);
        System.out.println("plus10AndMultiply2 = " + plus10AndMultiply2.apply(2));

        // 2.BiFunction
        BiFunction<Integer, Integer, Integer> plusTwoNumbers = (number1, number2) -> number1 + number2;
        System.out.println("plusTwoNumbers = " + plusTwoNumbers.apply(4, 5));

        // 3.Consumer
        Consumer<String> printName = (name) -> System.out.println("My name is " + name);
        printName.accept("chowon");

        // 4.Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println("get10 = " + get10.get());

        // 5.Predicate
        Predicate<String> startWithChowon = (s) -> s.startsWith("chowon");
        System.out.println("startWithChowon = " + startWithChowon.test("chowon9696"));

        Predicate<Integer> isEven = (i) -> i % 2 == 0;
        System.out.println("isEven = " + isEven.test(6));

        // 6.UnaryOperator
        UnaryOperator<Integer> plus10_3 = (number) -> number + 10; // Function<Integer, Integer> plus10을 더 간단하게 나타낼 수 있다.
        System.out.println("plus10_3 = " + plus10_3.apply(5));

        // 7.BinaryOperator
        BinaryOperator<Integer> multiplyTwoNumbers = (number1, number2) -> number1 * number2;
        System.out.println("multiplyTwoNumbers = " + multiplyTwoNumbers.apply(10, 20));
    }
}