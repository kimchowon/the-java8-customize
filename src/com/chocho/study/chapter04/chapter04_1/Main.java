package com.chocho.study.chapter04.chapter04_1;

import java.util.OptionalInt;

/**
 * 4-1.Optional 소개
 */
public class Main {

    public static void main(String[] args) {
        OnlineClass onlineClass = new OnlineClass();
        onlineClass.setProgress(null);

        // primitive 타입용 Optional 객체
        OptionalInt.of(10);
    }
}
