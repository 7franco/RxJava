package org.franco.proyecto.example03;

import java.util.Optional;

public class main {

    static void main(String[] args) {

        Optional<String> name = Optional.of("Jonathan");
//        Optional<String> nameUpperCase = name.map(n -> n.toUpperCase());
        Optional<String> nameUpperCase = name.map(String::toUpperCase);
        System.out.println("Nombre en May'uscula: "+nameUpperCase.orElse("Sin nombre"));


        Optional<String> name2 = Optional.of("    maRGaRET   ");
//        Optional<String> nameUpperCase = name.map(n -> n.toUpperCase());
        String nameUpperCase2 = name2
                .map(String::trim)
                .map(String::toLowerCase)
                .orElse("Sin nombre");
        System.out.println("Username: "+nameUpperCase2);


        //Flatmap

        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.of("Valor Interno"));

//        Optional<String> resultMap = optionalOfOptional.map(op -> op.orElse("Otra forma de hacerlo pero con map "));
        Optional<String> resultMap = optionalOfOptional.flatMap(op -> op);
        System.out.println(resultMap);

    }
}
