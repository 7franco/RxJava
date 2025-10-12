package org.franco.proyecto.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExamplesCollections {

    static void main(String[] args) {
        List<String> names = Arrays.asList("Margaret", "Paola","Krismary");

        names.forEach(System.out::println);

//        Consumer<String> name = (String n) -> System.out.println(n);
        Consumer<String> name = System.out::println;
        names.forEach(name);

        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        numbers.removeIf(n -> n % 2 == 0);

        System.out.println(numbers);


        List<String> words = new ArrayList<>(List.of("Java","Stream","Lambda"));


        words.replaceAll(word -> word.toUpperCase());

        System.out.println(words);
    }
}
