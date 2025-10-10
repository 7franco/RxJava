package org.franco.proyecto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.setName("Margaret");

        Person person = Person.builder().name("Jonathan").age(33).lastName("Franco").build();
        System.out.println(person);

    }
}