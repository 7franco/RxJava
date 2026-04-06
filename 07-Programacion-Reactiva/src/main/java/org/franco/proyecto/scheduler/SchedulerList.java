package org.franco.proyecto.scheduler;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulerList {

    static void main(String[] args) throws InterruptedException {
        List<String> students = Arrays.asList("Ana","Luis","Carlos","Sofía");
        List<String> teachers = Arrays.asList("Prof. Gomez","Prof. Díaz","Prof. Luis","Prof. Sofía");

        String searchQuery = "Luis";

        Observable<String> studentSearch = Observable.fromIterable(students)
                .filter(name -> name.contains(searchQuery))
                .delay(500, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .doOnNext(s -> System.out.println("Estudiante encontrado: "+ s + " en hilo"+ Thread.currentThread().getName()));

        Observable<String> teacherSearch = Observable.fromIterable(teachers)
                .filter(name -> name.contains(searchQuery))
                .delay(700, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.computation())
                .doOnNext(t -> System.out.println("Profesor encontrado: " + t + " en hilo: "+ Thread.currentThread().getName()));

        Observable.merge(studentSearch, teacherSearch)
                .subscribe(result -> System.out.println("Resultado Final: "+ result +" en hilo: "+ Thread.currentThread().getName()));

        Thread.sleep(2000);
    }
}
