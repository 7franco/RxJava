package org.franco.proyecto.FlightScheduler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FlightScheduler {

    static void main(String[] args) {
        ZoneId departureZone = ZoneId.of("America/Los_Angeles");
        ZoneId arrivalZone = ZoneId.of("Europe/London");

        ZonedDateTime departureTime = ZonedDateTime.now().plusHours(5);
        System.out.println("Hora de salida en los Angeles: " + departureTime);

        ZonedDateTime arrivalTime = departureTime.plusHours(10).withZoneSameInstant(arrivalZone);
        System.out.println("Hora de llegada a Londres: " + arrivalTime);

        //yyyy-MM-dd HH:mm:ss Z
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("Formateado: " + departureTime.format(formatter));
        System.out.println("Formateado: " + arrivalTime.format(formatter));
    }
}
