package org.franco.proyecto.localDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ExampleLocalDateTime {
    static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime currentDateTIme = LocalDateTime.now();

        System.out.println(today);
        System.out.println(now);
        System.out.println(currentDateTIme);
    }
}
