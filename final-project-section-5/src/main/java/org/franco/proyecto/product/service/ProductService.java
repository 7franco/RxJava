package org.franco.proyecto.product.service;

import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() throws InvalidProductException {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) throws InvalidProductException {
        ProductValidator.validate(product);
        if(!productRepository.existsById(product.getId())){
            productRepository.save(product);
            System.out.println("Un producto guardado .....");
        }else{
            throw new InvalidProductException("El producto que desea agregar, ya existe!");
        }
    }

    public void deleteProducto(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.delete(id);
            System.out.println("El producto fue eliminado");
        }else{
            throw new ProductNotFoundException("El producto que desea eliminar no existe");
        }
    }

    public void updateProducto(Product product) throws ProductNotFoundException, InvalidProductException {
        ProductValidator.validate(product);
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(optionalProduct.isPresent()){
            productRepository.update(optionalProduct);
            System.out.println("El producto fue actualizado");
        }else{
            throw new ProductNotFoundException("El producto que desea actualizar no existe");
        }
    }

}
