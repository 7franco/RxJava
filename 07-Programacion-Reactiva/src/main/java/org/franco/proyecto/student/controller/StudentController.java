package org.franco.proyecto.student.controller;

import io.reactivex.rxjava3.core.Observable;
import org.franco.proyecto.student.model.Student;
import org.franco.proyecto.student.service.StudentService;
import org.franco.proyecto.student.stream.StudentStream;

public class StudentController {

    private final StudentStream stream;
    private final StudentService service;


    public StudentController(StudentStream stream, StudentService service) {
        this.stream = stream;
        this.service = service;
//        this.service.subscribeTo(
//                stream.getStream()
//                .filter(student -> student.getAge() > 21)
//                .map(student -> new Student(student.getName().toUpperCase(), student.getAge()))
//        );
        this.service.subscribeTo(
                stream.getStream()
                        .flatMap(service:: verifyStudent)
                        .flatMap(student -> service.validateName(student)
                        .onErrorResumeNext(throwable -> {
                            System.out.println("Error: "+ throwable.getMessage());
                            return Observable.<Student>empty();
                        }))
        );
    }

    public boolean processInput(String name, String ageInput){
        try {
            int age = Integer.parseInt(ageInput);
            stream.publish(new Student(name, age));
            return true;
        }catch (NumberFormatException n){
            System.out.println(n.getMessage());
            return false;
        }
    }

    public void finishInput(){
        stream.complete();
    }

}
