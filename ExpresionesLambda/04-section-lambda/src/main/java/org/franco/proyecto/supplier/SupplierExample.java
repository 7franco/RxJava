package org.franco.proyecto.supplier;

import java.util.function.Supplier;

public class SupplierExample {

    static void main() {
        //se puede utilizar como un factory
        Supplier<Person> personFactory = () -> new Person();
        Person p1 = personFactory.get();
        p1.setName("Franco");
        System.out.println(p1.getName());
    }
}
