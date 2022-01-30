package com.chocho.study.chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream
 */
public class Main {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("chowon");
        names.add("hyunho");
        names.add("namsook");
        names.add("teasik");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);
        names.forEach(System.out::println);

        // 중개 오퍼레이션 만으로는 실행 안됨.
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        System.out.println("-----------------------------------------------------");

        // 종료 오퍼레이션 추가
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        // 스트림 없는 일반 코드 - 병렬 처리가 안된다.
        System.out.println("----------------------일반 코드-----------------------");
        for (String name : names) {
            if (name.startsWith("c")) {
                System.out.println(name.toUpperCase());
            }
        }

        // 스트림의 parallelStream 사용 - 병렬 처리
        System.out.println("----------------------병렬 처리-----------------------");
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
    }
}
