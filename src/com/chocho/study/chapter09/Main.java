package com.chocho.study.chapter09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // java 8이전에 사용하던 날짜 및 시간 클래스
        Date dt = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        // tiemstamp 출력
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);

        // 시간 임의로 변경하기
        Thread.sleep(1000 * 3);
        Date afterSeconds = new Date();
        System.out.println(afterSeconds);

        afterSeconds.setTime(time);
        System.out.println(afterSeconds);

        // java.util.Calendar
        // month는 0부터 시작, 4 -> 4월이 아닌 5월임. 실수할 여지가 많음.
        Calendar chowonBirthday = new GregorianCalendar(1996, 4, 24);

        // 상수로 대체
        chowonBirthday = new GregorianCalendar(1996, Calendar.APRIL, 24);
    }
}
