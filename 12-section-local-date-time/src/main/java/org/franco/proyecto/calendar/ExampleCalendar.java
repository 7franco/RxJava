package org.franco.proyecto.calendar;

import java.util.Calendar;
import java.util.Date;

public class ExampleCalendar {
    static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2025);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH,15);

        Date date = calendar.getTime();
        System.out.println(date);

        calendar.set(Calendar.DAY_OF_MONTH,5);
        date = calendar.getTime();
        System.out.println(date);
    }
}
