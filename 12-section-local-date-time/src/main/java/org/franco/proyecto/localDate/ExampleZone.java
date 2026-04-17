package org.franco.proyecto.localDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExampleZone {

    static void main(String[] args) {

        //ZoneId.getAvailableZoneIds().stream()
        //        .sorted()
        //        .forEach(System.out::println);

        /*ZoneId.getAvailableZoneIds().stream()
                .filter(id -> id.toLowerCase().contains("guayaquil"))
                .sorted()
                .forEach(System.out::println);
        ;*/

        ZoneId guayaquil = ZoneId.of("America/Guayaquil");
        System.out.println(guayaquil);

        ZonedDateTime nowGuayaquil = ZonedDateTime.of(2026,4,16,15,30,0,0,guayaquil);
        System.out.println(nowGuayaquil);

        ZonedDateTime madrid = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
        System.out.println(madrid);
    }

}
