package org.franco.proyecto.example06;

import java.util.List;
import java.util.Optional;

public class Main {

    static void main(String[] args) {

        //Ejemplo 4
        String maybeName = null;

        Optional.ofNullable(maybeName).ifPresentOrElse(
                name -> System.out.println("Nombre encontrado: "+ name),
                () -> System.out.println("No se encontró ningun nombre")
        );

        //Ejemplo 5

        List<Optional<String>> optionalList = List.of(
                Optional.of("Hola"),
                Optional.empty(),
                Optional.of("Chao")
        );

        optionalList.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);


    }
}
