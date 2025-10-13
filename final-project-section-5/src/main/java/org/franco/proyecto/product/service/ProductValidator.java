package org.franco.proyecto.product.service;

import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.model.Product;

public class ProductValidator {

    public static void validate(Product product) throws InvalidProductException {
        if (product.getPrice() <= 0){
            throw new InvalidProductException("El precio debe ser mayor a cero");
        }
        if (product.getStock() < 0){
            throw new InvalidProductException("El stock no puede ser negativo");
        }
    }
}
