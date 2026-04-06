package org.franco.proyecto.student.service;

import io.reactivex.rxjava3.core.Observable;
import org.franco.proyecto.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void subscribeTo(Observable<Student> stream){
        stream.subscribe(
                student -> {
                    System.out.println("Agregando estudiante...."+ student);
                    students.add(student);
                },
                error -> System.out.println("Error en el stream: "+ error.getMessage()),
                () -> {
                    System.out.println("Stream completo subscribeTo. Estudiants cargados...");
                    students.forEach(System.out::println);
                    showStatistics();
                }
        );
    }

    private void showStatistics(){
        System.out.println("Estad'isticas");
        System.out.println("Total: "+ students.size());
        if (!students.isEmpty()){
            double ageAverage = students.stream()
                    .mapToInt(Student::getAge)
                    .average()
                    .orElse(0);
            System.out.println("Promedio de edad: "+ ageAverage);
        }
    }

    public Observable<Student> verifyStudent(Student student) {
        return Observable.create(emitter -> {
            System.out.println("Verificando .... "+ student.getName());
            Thread.sleep(1000);
            if (student.getAge() >= 18){
                emitter.onNext(student);
            }else {
                System.out.println("El estudiante es menor de edad... "+student.getName());
            }

            emitter.onComplete();
        });
    }

    public Observable<Student> validateName(Student student) {
        return Observable.create(emitter -> {
            System.out.println("Verificando .... "+ student.getName());
            Thread.sleep(1000);
            if (student.getName().length() < 3){
                emitter.onError(new IllegalArgumentException("Error en la longitud del nombre....."));
            }else {
                emitter.onNext(student);
                System.out.println("El estudiante es menor de edad... "+student.getName());
            }

            emitter.onComplete();
        });
    }


}
