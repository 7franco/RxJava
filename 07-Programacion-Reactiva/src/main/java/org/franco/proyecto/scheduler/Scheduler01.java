package org.franco.proyecto.scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Scheduler01 {

    static void main(String[] args) throws InterruptedException {
        Observable.just("Hola")
                .subscribeOn(Schedulers.io())
                .doOnNext(s -> System.out.println(s+ " Just: "+ Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .map(s -> s+" mundo")
                .doOnNext(s1 -> System.out.println(s1+ " Map: "+ Thread.currentThread().getName()))
                .subscribe(s -> System.out.println(" Resultado: "+s+" "+ Thread.currentThread().getName()));

        Thread.sleep(1000);
    }
}
