package org.franco.proyecto.product.interfaces;

import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.model.ProductCategory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll() throws InvalidProductException;

    Optional<Product> findById(Long id);

    void save(Product product) throws SQLException;

    void delete(Long id) throws SQLException;

    List<Product> findByCategory(ProductCategory category);

    void update(Optional<Product> product) throws ProductNotFoundException, SQLException;

    boolean existsById(Long id);

}