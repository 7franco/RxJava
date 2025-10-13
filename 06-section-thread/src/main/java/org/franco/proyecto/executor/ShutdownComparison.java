package org.franco.proyecto.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutdownComparison {

    static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i =1 ; i<8; i++){
            final int taskId = i;
            executor.submit(() -> {
                        System.out.println("Tarea Iniciando con executor" + taskId + " " + Thread.currentThread().getName());
                try {
                    //Simulacióm de tiempo de espera API
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("Tarea "+ taskId +" fue interrumpida");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException error){

                    }
                    return;
                }
                System.out.println("Tarea Finalizada");
            });
        }

        Thread.sleep(5000);

        boolean errorExample =true;
        if (errorExample){
            System.out.println("Situación critica");
            executor.shutdownNow();
        }else{
            System.out.println("Finalización ordenada");
            executor.shutdown();
        }



        //awaitTermination
        if(executor.awaitTermination(1, TimeUnit.SECONDS)){
            System.out.println("Terea finalizadas correctamente");
        }else {
            System.out.println("Las tareas NO finalizaron correctamente");
        }





    }
}
