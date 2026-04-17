package org.franco.proyecto.localDate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class ExampleOperaciones {
    static void main(String[] args) {
//        LocalDate today = LocalDate.now();
//        LocalDate tenDaysLater = today.plusDays(10);
//        LocalDate fiveDaysBefore = today.minusDays(5);
//
//        System.out.println(today);
//        System.out.println(tenDaysLater);
//        System.out.println(fiveDaysBefore);
//
//        LocalTime now = LocalTime.now();
//        LocalTime twoHoursLater = now.plusHours(2);
//        LocalTime fiveMinutesBefore = now.minusMinutes(5);
//
//        System.out.println(now);
//        System.out.println(twoHoursLater);
//        System.out.println(fiveMinutesBefore);

//        LocalDate today = LocalDate.now();
//        LocalDate deliberyDate = LocalDate.of(2026,4,8);
//        if (today.isBefore(deliberyDate)){
//            System.out.println("Aun no llego la fecha de entrega");
//        } else if (today.isAfter(deliberyDate)) {
//            System.out.println("Ya paso la fecha de entrega");
//        }else {
//            System.out.println("Hoy es la fecha de entrega");
//        }

//        LocalDate start = LocalDate.of(2026,01,25);
//        LocalDate end = LocalDate.of(2026,03,28);
//        Period diff = Period.between(start, end);
//        System.out.println("Diferencia: "+ diff.getMonths()+" meses "+ diff.getDays()+" dias");

        LocalTime start = LocalTime.of(9,15);
        LocalTime end = LocalTime.of(14,45);

        Duration diff = Duration.between(start, end);
        long hours = diff.toHours();
        long minutes = diff.toMinutes() % 60;
        System.out.println("Diferencia: "+ hours+" horas y "+minutes+" minutos");
    }
}
