package org.franco.proyecto.example01;

import java.util.Optional;

public class Main {

    static void main(String[] args) {

        Optional<String> name = Optional.of("Franco");
        if(name.isPresent()){
            System.out.println("el nombre esta presente");
        }

        String value = null;
        Optional<String> nick = Optional.ofNullable(value);
        if(nick.isPresent()){
            System.out.println("el nombre esta presente");
        }else{
            System.out.println("Vacio");
        }
        Optional<String> enpty = Optional.empty();
        if (enpty.isPresent()){
            System.out.println("el nombre esta presente");
        }else{
            System.out.println("Vacio");
        }

        Optional<String> greeding =Optional.of("Hola mundo");
        greeding.ifPresent(message -> System.out.println("Soy Franco: "+ message));
    }
}
