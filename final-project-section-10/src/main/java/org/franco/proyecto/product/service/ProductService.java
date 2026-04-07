package org.franco.proyecto.product.service;

import org.franco.proyecto.category.model.Category;
import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.repository.ProductRepositoryServices;

import java.sql.SQLException;
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

    public Optional<Product> getProductByIdDB(Long id) throws SQLException {
        return ((ProductRepositoryServices) productRepository).findByIdDB(id);
    }

    public void saveProduct(Product product) throws InvalidProductException, SQLException {
        ProductValidator.validate(product);
        Optional<Category> optionalCategory = ((ProductRepositoryServices) productRepository).getCategoryDao().findCategoryByName(product.getCategory().getName());

        if(optionalCategory.isPresent()){
            if(!productRepository.existsById(product.getId())){
               product.setCategory(optionalCategory.get());
//                productRepository.save(product);
//                System.out.println("Un producto guardado .....");
            }else{
                throw new InvalidProductException("El producto que desea agregar, ya existe!");
            }
        }else{
            Optional<Category> optionalNewCategory= ((ProductRepositoryServices) productRepository).getCategoryDao().save(product.getCategory());
            product.setCategory(optionalNewCategory.get());

        }
        productRepository.save(product);
        System.out.println("El producto ha sido ingresado .....");
    }

    public void deleteProducto(Long id) throws ProductNotFoundException, SQLException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.delete(id);
            System.out.println("El producto fue eliminado");
        }else{
            throw new ProductNotFoundException("El producto que desea eliminar no existe");
        }
    }

    public void updateProducto(Product product) throws ProductNotFoundException, InvalidProductException, SQLException {
        ProductValidator.validate(product);
        Optional<Product> optionalProduct = ((ProductRepositoryServices)productRepository).getProductDAO().findById(product.getId());
        if(optionalProduct.isPresent()){
            Optional<Category> category = ((ProductRepositoryServices)productRepository).getCategoryDao().findCategoryByName(product.getCategory().getName());
            if(category.isPresent()){
                product.setCategory(category.get());
                productRepository.update(Optional.of(product));
                System.out.println("El producto fue actualizado");
            }else{
                throw new ProductNotFoundException("La categoria no existe....");
            }
        }else{
            throw new ProductNotFoundException("El producto que desea actualizar no existe");
        }
    }

}
