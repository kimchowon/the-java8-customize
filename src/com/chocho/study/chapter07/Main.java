package com.chocho.study.chapter07;

import java.util.OptionalInt;

public class Main {

    public static void main(String[] args) {
        OnlineClass onlineClass = new OnlineClass();
        onlineClass.setProgress(null);

        // primitive 타입용 Optional 객체
        OptionalInt.of(10);
    }
}
