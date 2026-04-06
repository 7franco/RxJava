package org.franco.proyecto.student;

import org.franco.proyecto.student.controller.StudentController;
import org.franco.proyecto.student.model.Student;
import org.franco.proyecto.student.service.StudentService;
import org.franco.proyecto.student.stream.StudentStream;
import org.franco.proyecto.student.view.StudentConsoleView;

public class App {

    static void main(String[] args) {
        StudentStream stream = new StudentStream();
        StudentService service = new StudentService();

//        stream.getStream().subscribe(
//                item -> System.out.println(item),
//                error -> System.out.println(error.getMessage()),
//                () -> System.out.println("Fin")
//        );
//
//        stream.publish(new Student("Gabriel", 25));
//        stream.publish(new Student("Maria", 50));
//
//        stream.complete();

        StudentController studentController = new StudentController(stream, service);
        StudentConsoleView view = new StudentConsoleView(studentController);
        view.start();


    }
}
