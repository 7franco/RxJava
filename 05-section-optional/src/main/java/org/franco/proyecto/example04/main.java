package org.franco.proyecto.example04;

import java.util.Optional;

public class main {

    static void main(String[] args) {
        Optional<String> dni = Optional.of("1234567");
        Optional<String> result = dni.filter(d -> d.startsWith("1"));
        System.out.println("DNI: "+ result.orElse("No válido"));

        Optional<String> email = Optional.ofNullable("    franco@devtalles.com    ");

        email
                .map(String::trim)
                .filter(e-> e.contains("@"))
                .ifPresent(message -> System.out.println("Enviando correo : "+ message));
        ;

    }

}
