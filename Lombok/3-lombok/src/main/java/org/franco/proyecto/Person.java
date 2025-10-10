package org.franco.proyecto;

import lombok.*;
/**
 * Normal anotacion
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
*/
//@Data
//@Value //hace la clase inmutable
@Builder
@ToString
public class Person {

    private String name;
    private int age;
    private String lastName;

}
