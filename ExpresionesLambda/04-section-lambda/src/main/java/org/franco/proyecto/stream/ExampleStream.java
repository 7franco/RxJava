package org.franco.proyecto.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {
    static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,56,7,8,9);
        Stream<Integer> stramNumbers = numbers.stream();
        stramNumbers.forEach(System.out::println);

        Stream<String> stream = Stream.of("A","B", "C");
        stream.forEach(System.out::println);
        String[] array = {"X", "Y", "Z"};
        Stream<String> stream2 = Arrays.stream(array);
        stream2.forEach(System.out::println);

        Stream<String> holaStream = Stream.generate(()-> "Hola Mundo!!!!").limit(3);
        holaStream.forEach(System.out::println);


        List<String> names = List.of("Margaret","Paola","Jonathan","Franco");
        names.stream()
                .filter(name -> name.length()>3)
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
        System.out.println(names);


        Stream<String> streamUno = Stream.of("Ana","Maria","Anastasia","Madelaine");
        streamUno.forEach(System.out::println);
        List<String> stringsUno = streamUno.toList();
        System.out.println(stringsUno);


    }
}
