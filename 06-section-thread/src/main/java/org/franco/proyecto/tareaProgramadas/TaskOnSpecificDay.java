package org.franco.proyecto.tareaProgramadas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskOnSpecificDay {

    static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2025,10,12,23,38);
        LocalDateTime now = LocalDateTime.now();

        long delay = Duration.between(now, dateTime).toMillis();
        if (delay <0){
            System.out.println("La fecha ya paso...");
            return;
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        executorService.schedule( ()->{
            System.out.println("Tarea después de 4 segundos");
            executorService.shutdown();
        },4, TimeUnit.MILLISECONDS);

    }
}
