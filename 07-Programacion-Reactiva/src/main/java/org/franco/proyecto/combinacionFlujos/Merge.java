package org.franco.proyecto.combinacionFlujos;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

import java.util.concurrent.TimeUnit;

public class Merge {

    static void main(String[] args) throws InterruptedException {
//        Observable<String> student = Observable.just("Juan", "Maria", "Pedro", "Jesus").delay(1, TimeUnit.SECONDS);
//        Observable<String> teacher = Observable.just("Prof. Carlor", "Prof. Ana", "Prof. Franco", "Prof. Jesus");
//        Observable.merge(student, teacher).subscribe(System.out::println);
//        Thread.sleep(2000);

//        Observable<String> student = Observable.just("Juan", "Maria", "Pedro", "Jesus").delay(1, TimeUnit.SECONDS);
//        Observable<String> teacher = Observable.just("Prof. Carlor", "Prof. Ana", "Prof. Franco", "Prof. Jesus");
//        Observable.concat(student, teacher).subscribe(System.out::println);
//        Thread.sleep(2000);

        Observable<String> student = Observable.just("Juan", "Maria", "Pedro", "Jesus");
        Observable<Integer> ages = Observable.just(20,30,40,50);

        Observable.zip(student, ages, (name, age) -> new  Student(name, age))
                .subscribe(
                student0 -> System.out.println()
        );


    }
}
