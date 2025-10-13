package org.franco.proyecto.product.controller;

import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.service.ProductService;
import org.franco.proyecto.product.utils.Validates;

import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(Product product) throws InvalidProductException {
        Validates.validateObject(product, "El producto no puede ser un dato nulo");
        productService.saveProduct(product);
    }

    public void removeProduct(Long id) throws ProductNotFoundException, InvalidProductException {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        productService.deleteProducto(id);
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productService.getAllProducts();
    }

    public Optional<Product> getProductByid(Long id) throws InvalidProductException {
        Validates.validateNumber(id, "El ID no puede ser nulo");
        return productService.getProductById(id);
    }

    public void updateProduct(Product product) throws ProductNotFoundException, InvalidProductException {
        Validates.validateObject(product, "El producto no puede ser un dato nulo");
        productService.updateProducto(product);
    }

}
