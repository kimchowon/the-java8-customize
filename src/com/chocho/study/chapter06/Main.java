package com.chocho.study.chapter06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring 으로 시작하는 수업");
        List<OnlineClass> startWithSpringClasses = springClasses.stream()
                .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                .collect(Collectors.toList());

        startWithSpringClasses.forEach(s -> System.out.println(s.toString()));

        System.out.println(" ");
        System.out.println("close 되지 않은 수업");
        List<OnlineClass> notClosedClasses = springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                //.filter(onlineClass -> onlineClass.isClosed() == false)
                .collect(Collectors.toList());

        notClosedClasses.forEach(s -> System.out.println(s.toString()));

        System.out.println(" ");
        System.out.println("수업 이름만 모아서 스트림 만들기");
        List<String> titleList = springClasses.stream()
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());

        titleList.forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> chowonEvents = new ArrayList<>();
        chowonEvents.add(springClasses);
        chowonEvents.add(javaClasses);

        System.out.println(" ");
        System.out.println("두 수업 목록에 들어 있는 모든 수업 아이디 출력");
        List<Integer> idList = chowonEvents.stream()
                .flatMap(Collection::stream)
                .map(OnlineClass::getId)
                .collect(Collectors.toList());

        idList.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        List<Integer> numberList = Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .collect(Collectors.toList());

        numberList.forEach(System.out::println);

        System.out.println(" ");
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean containsTest = javaClasses.stream()
                .anyMatch(jc -> jc.getTitle().contains("Test"));

        System.out.println(containsTest);

        System.out.println(" ");
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> containSpringTitleList = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());

        containSpringTitleList.forEach(s -> System.out.println(s));

        System.out.println(" ");
        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목 개수 구하기");
        long count = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .count();

        System.out.println(count);
    }
}
