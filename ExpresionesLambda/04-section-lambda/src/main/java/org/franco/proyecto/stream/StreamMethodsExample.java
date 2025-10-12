package org.franco.proyecto.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethodsExample {
    static void main(String[] args) {
        List<String> names = List.of("Margaret","Paola","Jonathan","Franco","Paola","Franco");
        List<String> longName = names.stream().filter(name -> name.length()>3).toList();
        System.out.println(longName);

        List<Integer> lengthName = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(lengthName);


        List<List<Integer>> list = List.of(List.of(1,2), List.of(3,4));

//        List<Integer> flatNames = list.stream()
//                .flatMap(l -> l.stream())
//                .collect(Collectors.toList());

        List<Integer> flatNames = list.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(flatNames);


        //distinct and sort
        List<Integer> numbers = List.of(3,1,3,5,2,8,6,7,9,8);
        List<Integer> uniqueOrdered = numbers.stream().distinct().sorted().toList();
        System.out.println(uniqueOrdered);

        //set
        Set<String> setName = names.stream()
                .filter(n -> n.length()>5)
                .collect(Collectors.toSet());
        System.out.println(setName);

        //count
        long cantidad = names.stream()
                .filter(n -> n.contains("a"))
                .count();
        System.out.println(cantidad);

        //reduce
        int sum = numbers.stream()
                .reduce(0, (result, number) -> result + number);
        System.out.println(sum);

        //forEach

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
