package org.franco.proyecto.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

    static void main() {
        Consumer<String> printUpper = (s) -> System.out.println(s.toUpperCase());

        printUpper.accept("Buenas tardes");

        BiConsumer<String, Integer> repeat = (word, times) ->{
          for (int i =0 ; i<times; i++){
              System.out.println(word);
          }
        };
        repeat.accept("Hola", 3);
    }
}
