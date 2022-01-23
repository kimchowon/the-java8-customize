package com.chocho.study.chapter03;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {

    public void run() {
        int baseNumber = 10; // effective final

        // 람다에서 변수 캡쳐
        IntConsumer printInt = number -> {
          //  int baseNumber = 11; 불가능, 에러 발생
            System.out.println(number + baseNumber); // 람다 캡쳐링
        };

       // baseNumber++; // 변수 값 재할당, 에러 발생
        printInt.accept(10);

        // 내부 클래스에서 변수 캡쳐
        class LocalClass {

            int baseNumber = 11; // 변수 쉐도잉, 내부 클래스 밖에 있는 baseNumber 변수는 가려진다.
            void printBaseNumber() {
                System.out.println(baseNumber); // 11 출력
            }
        }

        // 익명 클래스에서 변수 캡쳐
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber); // 11 출력
            }
        };
        integerConsumer.accept(11);
    }
}
