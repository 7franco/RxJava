package org.franco.proyecto.programacionReactiva;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReactiveScanner {
    static void main(String[] args) {

        PublishSubject<String> inputStream = PublishSubject.create();

        inputStream.subscribe(
                item -> System.out.println("Recibido: "+ item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Finalizado ....")
        );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un texto o 'salir' para terminar la app:");
        while (true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("salir")){
                inputStream.onComplete();
                break;
            }
            inputStream.onNext(input);
        }

        scanner.close();








    }
}
