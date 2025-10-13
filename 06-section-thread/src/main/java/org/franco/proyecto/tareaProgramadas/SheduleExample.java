package org.franco.proyecto.tareaProgramadas;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SheduleExample {

    static void main(String[] args) {
        // la forma correcta del schedule
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//        executorService.schedule(()-> {
//            System.out.println("Tarea despues de 4 segundos");
//
//        }, 4, TimeUnit.SECONDS);
//
//        executorService.schedule(()-> {
//            System.out.println("Tarea despues de 5 segundos");
//
//        }, 5, TimeUnit.SECONDS);
//        executorService.shutdown();



        //Mas antiguo
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Tarea de dos segundos");
//                timer.cancel();
//            }
//        }, 2000);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Runnable task = new Runnable() {
            int counter = 0;
            @Override
            public void run() {
                System.out.println("Enviando recordatorio");
                counter++;
                if (counter>3){
                    System.out.println("Se enviaron todos los recordatorios....");
                    executorService.shutdown();
                }
            }
        };

        executorService.scheduleAtFixedRate(task, 0,3,TimeUnit.SECONDS);

    }
}
