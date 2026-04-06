package org.franco.proyecto.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObserverExample01 {


    static void main() {
//        Observable<List<String>> courserStream = Observable.just(Arrays.asList("HTML", "CSS", "JAVA", "C"));
        Observable<String> courserStream = Observable.fromIterable(
                Arrays.asList("HTML", "CSS", "JAVA", null,"C").stream().filter(Objects::nonNull).collect(Collectors.toSet())
        );

        //        courserStream.subscribe(
//                item -> System.out.println("Recibe: "+item),
//                throwable -> System.out.println(throwable.getMessage()),
//                () -> System.out.println("Fin")
//        );

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Estoy suscrito al curso!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Recibi: "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Fin del Stream");
            }
        };

        Observer<String> observer2 = new Observer<String>() {
            private Disposable disposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
                System.out.println("Estoy suscrito al curso soy observer2!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                if(s.equalsIgnoreCase("C")){
                    this.disposable.dispose();
                }else{
                    System.out.println("Soy Observer2 Recibi: "+s);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("Fin del Stream Observer2");
            }
        };


        courserStream.subscribe(observer);
        courserStream.subscribe(observer2);

    }
}
