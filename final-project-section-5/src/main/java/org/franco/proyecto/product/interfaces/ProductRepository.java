package org.franco.proyecto.product.interfaces;

import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll() throws InvalidProductException;

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Long id);

    void update(Optional<Product> product) throws ProductNotFoundException;

    boolean existsById(Long id);

}