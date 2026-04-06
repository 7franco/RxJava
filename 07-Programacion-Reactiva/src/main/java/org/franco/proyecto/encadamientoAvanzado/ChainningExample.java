package org.franco.proyecto.encadamientoAvanzado;

import io.reactivex.rxjava3.core.Observable;
import org.franco.proyecto.combinacionFlujos.Student;

public class ChainningExample {

    static void main(String[] args) {
        Observable<Student> studentObservable = Observable.just(
                new Student("Margaret", 17),
                new Student("Franco", 33),
                new Student("Estela", 43)
        );

//        studentObservable
//                .filter(student -> student.getAge() < 21 )
//                .map(student -> student.getName().toUpperCase())
//                .subscribe(System.out::println);

        studentObservable
                .filter(student -> student.getAge() < 21 )
                .flatMap(student -> getSubjectPerStudent(student.getName()))
                .subscribe(
                        subject -> System.out.println("Materia: "+ subject),
                        error -> System.err.println(error.getMessage()),
                        () -> System.out.println("Fin")
                );

    }

    public static Observable<String> getSubjectPerStudent(String name){
        if (name.equalsIgnoreCase("Margaret")){
            return Observable.just("Programación 3", "Lenguaje");
        }
        return Observable.empty();
    }
}





