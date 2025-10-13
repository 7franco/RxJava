package org.franco.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    static void main(String[] args) {
//        ExecutorService executor0 = Executors.newFixedThreadPool(2);
//        executor0.execute(() -> System.out.println("Tarea A"+ Thread.currentThread().getName()));
//        executor0.execute(() -> System.out.println("Tarea B"+ Thread.currentThread().getName()));
//        executor0.execute(() -> System.out.println("Tarea C"+ Thread.currentThread().getName()));
//        executor0.shutdown();


        Runnable task = () ->{
            System.out.println("Ejecutando la tarea "+Thread.currentThread().getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Tarea completada en el hilo " + Thread.currentThread().getName());

        };
        System.out.println("Ejecutando newFixedThreadPool");
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        for (int i=1; i <= 5 ; i++){
            fixedPool.execute(task);
        }
        fixedPool.shutdown();


        System.out.println("Ejecutando newCachedThreadPool");
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        for (int i=1; i <= 5 ; i++){
            cachedPool.execute(task);
        }
        cachedPool.shutdown();

        System.out.println("Ejecutando newSingleThreadExecutor");
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        for (int i=1; i <= 5 ; i++){
            singlePool.execute(task);
        }
        singlePool.shutdown();

    }
}
