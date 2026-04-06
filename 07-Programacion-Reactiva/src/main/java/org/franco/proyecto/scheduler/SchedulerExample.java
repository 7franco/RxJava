package org.franco.proyecto.scheduler;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class SchedulerExample {

    static void main(String[] args) {
        List<String> students = Arrays.asList("Ana","Luis","Carlos","Sofía");
        List<String> teachers = Arrays.asList("Prof. Gomez","Prof. Díaz","Prof. Luis","Prof. Sofía");

        String searchQuery = "Luis";

        Observable<String> studentSearch = Observable.fromIterable(students)
                .filter(name -> name.contains(searchQuery))
                .doOnNext(s -> System.out.println(" Estudiante encontrado: "+ s + " en hilo"+ Thread.currentThread().getName()));

        Observable<String> teacherSearch = Observable.fromIterable(teachers)
                .filter(name -> name.contains(searchQuery))
                .doOnNext(t -> System.out.println("Profesor encontrado: " + t + " en hilo: "+ Thread.currentThread().getName()));

        Observable.merge(studentSearch, teacherSearch)
                .subscribe(result -> System.out.println("Resultado Final: "+ result +" en hilo: "+ Thread.currentThread().getName()));

    }
}
