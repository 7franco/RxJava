package org.franco.proyecto.postgress;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    static void main(String[] args) {
        PersonService service = new PersonService();
        //Person person = new Person("Franco", LocalDate.of(1992,8,3));
        try{
            //service.savePerson(person);
            Person person = service.findPersonById(1);
            System.out.println(person);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
