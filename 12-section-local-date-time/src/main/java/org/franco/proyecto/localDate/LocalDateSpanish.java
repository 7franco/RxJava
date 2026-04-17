package org.franco.proyecto.localDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateSpanish {
    static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        Month month = localDate.getMonth();

        System.out.println("Numero del mes: "+ month.getValue());

        Locale locale = new Locale.Builder().setLanguage("es").setRegion("ES").build();

        System.out.println("Mes en espa;ol: "+ month.getDisplayName(TextStyle.FULL, locale));

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("NUmero del dia de la semana: "+dayOfWeek.getValue());
        System.out.println(dayOfWeek);
        System.out.println("Dia de la semana en espa;ol: " + dayOfWeek.getDisplayName(TextStyle.FULL, locale));

        System.out.println(month);
    }
}
