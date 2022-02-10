package com.chocho.study.chapter10;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Date와 Time API
 */
public class Main {

    public static void main(String[] args) {
        // 1.현재 시간 표현
        // 현재 시간을 기계용 시간으로 표현
        System.out.println("-----기계용 시간-----");
        Instant machineNow = Instant.now();
        System.out.println(machineNow); // UTC(GMT) 기준 시간 리턴
        System.out.println(machineNow.atZone(ZoneId.systemDefault())); // 로컬 시스템 기준 시간

        // 현재 시간을 인류용 시간으로 표현
        System.out.println("\n-----인류용 시간-----");
        LocalDateTime personNow = LocalDateTime.now();
        System.out.println(personNow);

        // 특정한 시간을 만들기
        System.out.println("\n-----특정 일시 만들기-----");
        LocalDateTime birthday = LocalDateTime.of(1996, Month.APRIL, 24, 16, 0, 0);
        System.out.println(birthday);

        // 특정 zone의 일시 확인하기
        System.out.println("\n-----특정 zone의 일시 확인하기-----");
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        ZonedDateTime nowInNewyork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(nowInNewyork);

        // 2.기간을 표현하는 방법
        // Period - 인류용 시간 비교
        System.out.println("\n-----Period - 인류용 시간 비교-----");
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2022, Month.APRIL, 19);

        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getYears() + "년 " + period.getMonths() + "월 " + period.getDays() + "일");

        Period until = today.until(thisYearBirthday);
        System.out.println(until.getYears() + "년 " + until.getMonths() + "월 " + until.getDays() + "일");

        // Duration - 기계용 시간 비교
        System.out.println("\n-----Duration - 기계용 시간 비교-----");
        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);

        Duration between = Duration.between(now, plus);
        System.out.println(between.getSeconds());

        // 3.포매팅
        System.out.println("\n-----포매팅-----");
        LocalDateTime localDateTime = LocalDateTime.now();

        // 포맷 형식을 직접 만들기
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(localDateTime.format(MMddyyyy));

        // 기존에 정의되어 있는 포맷 형식 사용하기
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        System.out.println(localDateTime.format(isoDate));

        // 4.string 파싱하여 Date 객체 생성
        LocalDate localDate = LocalDate.parse("04/24/1996", MMddyyyy);
        System.out.println(localDate);

        // 5.레거시 API와 호환 (Java 8이전 <--> Java 8)
        // Date -> Instant
        Date date = new Date();
        Instant instant = date.toInstant();

        // Instant -> Date
        Date date2 = Date.from(instant);

        // GregorianCalendar -> LocalDateTime
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime localDateTime1 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // ZonedDateTime -> GregorianCalendar
        ZonedDateTime zonedDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar from = GregorianCalendar.from(zonedDateTime);

        // time Zone 바꾸기
        // Java 8이전: java.util.TimeZone <--> Java 8: java.time.ZoneId
        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();

        // ZoneId -> TimeZone
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);
    }
}
