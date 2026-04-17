package org.franco.proyecto.localDate;

import java.time.LocalDate;

public class ExampleLocalDate {

    static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2025,6,10);
        System.out.println("Fecha original: "+localDate);

        LocalDate updateDate= localDate.plusDays(5);
        System.out.println(updateDate);

        System.out.println("Fecha original "+localDate);
    }
}
