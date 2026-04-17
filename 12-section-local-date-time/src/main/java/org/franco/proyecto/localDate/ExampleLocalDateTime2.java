package org.franco.proyecto.localDate;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class ExampleLocalDateTime2 {

    static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(localDateTime.format(formatter));

        localDateTime = LocalDateTime.of(2025, Month.APRIL, 24,20,45,59);

        System.out.println(localDateTime);

        localDateTime = LocalDateTime.parse("2020-12-23T21:23:59");
        System.out.println(localDateTime);

        System.out.println(localDateTime.plusDays(1).plusHours(4));

        String format1 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("Format 1: "+format1);

        String format2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a"));
        System.out.println("Format 2: "+format2);
    }
}
