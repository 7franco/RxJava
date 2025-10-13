package org.franco.proyecto.example05;

import java.util.List;
import java.util.Optional;

public class Main {

    static void main(String[] args) {
        List<String> names = List.of("Jonathan", "Margaret","Teddy", "Andrea");
        Optional<String> first = names.stream().findFirst();

        first.ifPresent(name -> System.out.println("El primero es " + name));

        //Ejemplo 2

        List<String> emptyList = List.of();

        Optional<String>  firstEmpty = emptyList.stream().findFirst();

        System.out.println("Esta presente? "+ firstEmpty.isPresent());

        //ejemplo 3

        record  Product(String name, double price){}

        List<Product> products = List.of(
                new Product("TV", 1000.0),
                new Product("Netbook", 400.0)
        );

        Optional<Product> maybeTV = products.stream()
                .filter(p -> p.name.equalsIgnoreCase("tv2"))
                .findFirst();

        Product result = maybeTV.orElse(new Product("Generico", 0));
        System.out.println("Resultado: "+ result.name +"-$"+ result.price);
    }
}
