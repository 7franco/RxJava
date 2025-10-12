package org.franco.proyecto.record;

public class Main {

    static void main(String[] args) {
        Product product = new Product("TV",200.3);
        product.getName();

        //es una clase inmutable
        ProductDto productDto = new ProductDto("Notebook", 100.5);
        productDto.name();
        productDto.price();
        ProductDto.methodStatic();

    }
}
