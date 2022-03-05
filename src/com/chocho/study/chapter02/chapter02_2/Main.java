package com.chocho.study.chapter02.chapter02_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * 2-2.자바8 API에 추가된 기본 메소드와 스태틱 메소드
 */
public class Main {

    public static void main(String[] args) {

        List<String> name = new ArrayList<>();
        name.add("초원");
        name.add("성학");
        name.add("수진");
        name.add("민수");

        System.out.println("Iterable 인터페이스의 기본 메소드");
        System.out.println("1.forEach()");
        name.forEach(System.out::println);

        System.out.println("2.spliterator()");
        Spliterator<String> spliterator1 = name.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        while (spliterator1.tryAdvance(System.out::println));
        System.out.println("=========");
        while (spliterator2.tryAdvance(System.out::println));

        System.out.println("\nCollection 인터페이스의 기본 메소드");
        System.out.println("1.stream()");
        List<String> k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("K"))
                .collect(Collectors.toList());

        System.out.println("2.removeIf(Predicate)");
        name.removeIf(s -> s.startsWith("K"));
        
        System.out.println("\nComparator 인터페이스의 기본 메소드");
        System.out.println("1.reversed()");
        Comparator<String> comparator = String::compareToIgnoreCase;
        name.sort(comparator.reversed());

        System.out.println("2.thenComparing");
        Comparator<String> comparator2 = Comparator.comparingInt(String::length);
        name.sort(comparator.reversed().thenComparing(comparator2));
    }
}
