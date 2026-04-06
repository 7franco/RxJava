package org.franco.proyecto.programacionReactiva;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;

import java.util.Scanner;

public class ReactiveIntro {

    static void main(String[] args) {

        //Primer Ejemplo
//        Observable<String> coursStream = Observable.just("HTML", "CSS", "JAVA", "C");
//
//        coursStream.subscribe(
//                item -> System.out.println("Recibido: "+ item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Finalizado ....")
//        );


        //Observable create
//        Observable<String> names = Observable.create( emitter -> {
//            emitter.onNext("Margaret");
//            emitter.onNext("Paola");
//            emitter.onNext("Jonathan");
//            emitter.onNext("Franco");
//            emitter.onError(new IllegalArgumentException("Algo salio mal"));
//        });
//
//        names.subscribe(
//                item -> System.out.println("Name: "+ item)
//        );


//        //Observable onSubcribe
//        ObservableOnSubscribe subscribe = new ObservableOnSubscribe() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {
//                emitter.onNext("Margaret");
//                emitter.onNext("Paola");
//                emitter.onNext("Jonathan");
//                emitter.onNext("Franco");
//                emitter.onError(new IllegalArgumentException("Algo salio mal"));
//            }
//        };
//
//        Observable<String> names2 = Observable.create(subscribe);
//
//        names2.subscribe(
//                item -> System.out.println("Name: "+ item)
//        );

//        //Observable onSubcribe 2
//        ObservableOnSubscribe subscribe = new ObservableOnSubscribe() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {
//                Scanner scanner = new Scanner(System.in);
//                String input;
//                while (true){
//                    System.out.println("Ingrese un nombre.....o 'salir' para dejar la app");
//                    input = scanner.nextLine();
//                    if(input.equalsIgnoreCase("salir")){
//
//                        break;
//                    }
//                    emitter.onNext(input);
//                }
//            }
//        };
//
//        Observable<String> names2 = Observable.create(subscribe);
//
//        names2.subscribe(
//                item -> System.out.println("Name: "+ item)
//        );

        //Observable onSubcribe 3
        ObservableOnSubscribe subscribe = emitter -> {
            Scanner scanner = new Scanner(System.in);
            String input;
            while (true){
                System.out.println("Ingrese un nombre.....o 'salir' para dejar la app");
                input = scanner.nextLine();
                if(input.equalsIgnoreCase("salir")){

                    break;
                }
                emitter.onNext(input);
            }
        };

        Observable<String> names2 = Observable.create(subscribe);

        names2.subscribe(
                item -> System.out.println("Name: "+ item)
        );
    }
}
