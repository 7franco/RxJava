package org.franco.proyecto.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStream {

    static void main(String[] args) {
        List<String> fruits = Arrays.asList("Manzana", "Banana", "Kiwi");

        //        List<String> filterFruits = fruits.stream().filter(f -> f.length()>5).collect(Collectors.toList());
        List<String> filterFruits = fruits.stream().filter(f -> f.length()>5).toList();

        System.out.println(fruits);
        System.out.println(filterFruits);

        //Ejemplo stream 1 MAP
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<Integer> integerStream = numbers.stream().map(n-> n * n);
        List<Integer> numbersSquere = integerStream.toList();
        System.out.println(numbersSquere);

        //Ejemplo stream 2 lo mismo MAP
        List<Integer> numbersOther = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> integerStreamOther = numbersOther.stream().map(n-> n * n).toList();
        System.out.println(integerStreamOther);


    }
}
