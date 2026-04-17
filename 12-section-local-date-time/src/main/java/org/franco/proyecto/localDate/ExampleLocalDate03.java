package org.franco.proyecto.localDate;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ExampleLocalDate03 {

    static void main(String[] args) {
//        LocalDate date = LocalDate.of(2026,4,7);
//        System.out.println(date);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//        String formatterDate = date.format(formatter);
//        System.out.println(formatterDate);
//
//
//        String dateText = "07/04/2026";
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate parsedDate = LocalDate.parse(dateText, formatter1);
//        System.out.println(parsedDate);

//        try{
//            String dateText = "07 abril 2026";
//            DateTimeFormatter formatter;
//            formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("es", "ES"));
//            LocalDate parsedDate = LocalDate.parse(dateText, formatter);
//            System.out.println(parsedDate.format(formatter));
//        }catch (DateTimeException e){
//            System.out.println("Error formato: "+ e.getMessage());
//        }

        LocalDate date = LocalDate.of(2026,4,7);
        System.out.println("Dia: "+date.getDayOfWeek());
        System.out.println("Mes: "+date.getMonth());
        System.out.println("Year: " + date.getYear());
        System.out.println("Dia of year: " + date.getDayOfYear());
        System.out.println("Era: "+date.getEra());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formatterDate = date.format(formatter);
        System.out.println(formatterDate);

        LocalDate antigua = LocalDate.of(-44, 3,15);
        String formatteDate = date.format(formatter);
        System.out.println(formatteDate);


    }
}
