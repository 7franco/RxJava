package org.franco.proyecto.calendar;

import java.util.Calendar;

public class ExampleCalendar2 {
    static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2025,6,30);
        System.out.println(cal.getTime());
    }
}
