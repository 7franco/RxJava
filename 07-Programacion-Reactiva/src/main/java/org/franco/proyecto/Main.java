package org.franco.proyecto;

import java.util.List;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        List<Integer> number = List.of(1,2,3,4,5);
        long start = System.currentTimeMillis();

        number.parallelStream().map(
                n -> {
                    try {
                        //Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Procesando n[umero: "+n);
                    return n*2;
                }).forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.println("Tiempo total (secuencial): "+ (end -start)+" ms");
    }
}
