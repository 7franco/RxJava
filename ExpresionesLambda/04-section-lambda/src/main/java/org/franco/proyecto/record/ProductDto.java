package org.franco.proyecto.record;

public record ProductDto(String name, double price) {

    public static String ATRIBUTO = "hola";

    public ProductDto {
    }

    public ProductDto(String name) {
        this(name, 0);
    }

    public static void methodStatic(){
        System.out.println("Hola soy un metodo estatico");
    }
}
