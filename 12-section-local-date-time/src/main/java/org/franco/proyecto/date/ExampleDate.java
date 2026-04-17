package org.franco.proyecto.date;

import java.util.Date;

public class ExampleDate {
    static void main(String[] args) {
        Date date = new Date();
        System.out.println("Fecha original: "+ date);

        date.setTime(0);
        System.out.println("Fecha modificada: "+ date);


    }
}
