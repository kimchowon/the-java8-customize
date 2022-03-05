package com.chocho.study.chapter04.chapter04_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 4-2.Optional API
 */
public class Main {

    public static void main(String[] args) {
        // Optional 만들기
        Optional<OnlineClass> optional1 = Optional.of(new OnlineClass(1, "spring boot", false));
        Optional<OnlineClass> optional2 = Optional.ofNullable(null);// null 허용
        Optional<Object> optional3 = Optional.empty();

        // Optional에 값의 유무 확인하기
        System.out.println(optional1.isPresent());
        System.out.println(optional2.isPresent());
        System.out.println(optional3.isEmpty());

        // Optional에서 값 가져오기
        OnlineClass onlineClass = optional1.get();
        System.out.println(onlineClass.getTitle());

        // get을 호출하기전 Optional에 값이 있는지 체크 필요
        if (optional2.isPresent()) {
            OnlineClass onlineClass2 = optional2.get();
            System.out.println(onlineClass2.getTitle());
        }

        // Optional.ifPresent
        List<OnlineClass> onlineClassList = new ArrayList<>();
        onlineClassList.add(new OnlineClass(1, "spring boot 3.0", true));
        onlineClassList.add(new OnlineClass(2, "rest api development", false));

        Optional<OnlineClass> optional4 = onlineClassList.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        optional4.ifPresent(oc -> System.out.println(oc.getTitle()));

        // Optional.orElse
        OnlineClass onlineClass2 = optional4.orElse(createEmptyOnlineClass());
        System.out.println("Title Of onlineClass2 : " + onlineClass2.getTitle());

        // Optional.orElseGet
        OnlineClass onlineClass3 = optional4.orElseGet(Main::createEmptyOnlineClass);
        System.out.println("Title Of onlineClass3 : " + onlineClass3.getTitle());

        // Optional.orElseThrow
        Optional<OnlineClass> optional5 = onlineClassList.stream()
                .filter(oc -> oc.getTitle().startsWith("JPA"))
                .findFirst();

/*        OnlineClass onlineClass4 = optional5.orElseThrow();

        // 원하는 에러를 던지고 싶을 때
        optional5.orElseThrow(() -> {
            return new IllegalArgumentException();
        });*/

        // Optional.filter
        Optional<OnlineClass> optional6 = optional4.filter(oc -> oc.getId() > 10);
        System.out.println("isEmpty = " + optional6.isEmpty());

        // Optional.map(Function)
        Optional<Integer> integer = optional4.map(OnlineClass::getId);
    }

    private static OnlineClass createEmptyOnlineClass() {
        System.out.println("create new online class.");
        return new OnlineClass();
    }
}
