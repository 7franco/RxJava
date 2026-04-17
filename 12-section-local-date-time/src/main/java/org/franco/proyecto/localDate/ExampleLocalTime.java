package org.franco.proyecto.localDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class ExampleLocalTime {

    static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Hora: " + now.getHour());
        System.out.println("Minuto: " + now.getMinute());
        System.out.println("Seg: " + now.getSecond());

        LocalTime coffeBreak = LocalTime.of(16,30);

        System.out.println(coffeBreak);

        System.out.println("Suma: "+  coffeBreak.plus(1, ChronoUnit.MINUTES));

        System.out.println("Suma: "+  coffeBreak.plusMinutes(10));
        System.out.println("Restar: "+  coffeBreak.minusMinutes(25));

        System.out.println(LocalTime.of(7,40).isBefore(LocalTime.parse("08:30")));


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        String time = coffeBreak.format(dateTimeFormatter);

        System.out.println(time);

        LocalTime max = LocalTime.MAX;
        LocalTime mini = LocalTime.MIN;
        LocalTime min = LocalTime.MIDNIGHT;

        System.out.println(max);
        System.out.println(mini);
        System.out.println(mini);


    }
}
