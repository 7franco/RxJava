package org.franco.proyecto.product.service;

import org.franco.proyecto.category.model.Category;
import org.franco.proyecto.db.ConnetionPool;
import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.repository.ProductRepositoryServices;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
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
        try(Connection connection = ConnetionPool.getConnection()){
            return productRepository.findByIdDB(connection, id);
        }

    }

    public void saveProduct(Product product) throws InvalidProductException, SQLException {
        ProductValidator.validate(product);
        Connection connection = null;
        try{
            connection = ConnetionPool.getConnection();
            connection.setAutoCommit(false);

            Optional<Category> optionalCategory = ((ProductRepositoryServices) productRepository)
                    .getCategoryDao().findCategoryByName(connection, product.getCategory().getName());

            if(optionalCategory.isPresent()){
                if(!productRepository.existsById(product.getId())){
                    product.setCategory(optionalCategory.get());
                }else{
                    throw new InvalidProductException("El producto que desea agregar, ya existe!");
                }
            }else{
                Optional<Category> optionalNewCategory= ((ProductRepositoryServices) productRepository).getCategoryDao().save(connection, product.getCategory());
                optionalNewCategory.ifPresent(product::setCategory);

            }
            productRepository.save(connection, product);
            connection.commit();
            System.out.println("El producto ha sido agregado.");
        }catch (SQLException | InvalidProductException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection!=null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conextio: "+ e);
                }
            }
        }

    }

    public void deleteProducto(Long id) throws ProductNotFoundException, SQLException, InvalidProductException {
        Connection connection = null;
        try{
            connection = ConnetionPool.getConnection();
            connection.setAutoCommit(false);

            Optional<Product> optionalProduct = productRepository.findById(id);
            if(optionalProduct.isPresent()){
                productRepository.delete(connection, id);
                System.out.println("El producto fue eliminado");
            }else{
                throw new ProductNotFoundException("El producto que desea eliminar no existe");
            }
            connection.commit();
        } catch (SQLException e){
            if (connection != null){
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection!=null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conextio: "+ e);
                }

            }
        }

    }

    public void updateProducto(Product product) throws ProductNotFoundException, InvalidProductException, SQLException {
        Connection connection = null;
        try{
            connection = ConnetionPool.getConnection();
            connection.setAutoCommit(false);
            ProductValidator.validate(product);
            Optional<Product> optionalProduct = ((ProductRepositoryServices)productRepository)
                    .getProductDAO().findById(connection, product.getId());
            if(optionalProduct.isPresent()){
                Optional<Category> category = ((ProductRepositoryServices)productRepository)
                        .getCategoryDao().findCategoryByName(connection, product.getCategory().getName());
                if(category.isPresent()){
                    product.setCategory(category.get());
                    productRepository.update(connection, Optional.of(product));
                    System.out.println("El producto fue actualizado");
                }else{
                    Optional<Category> newCategory = ((ProductRepositoryServices)productRepository).getCategoryDao().save(connection, product.getCategory());
                    newCategory.ifPresent(product::setCategory);

                }
            }
            productRepository.update(connection, Optional.of(product));
            connection.commit();
            System.out.println("El producto fue actualizado");
        }catch (SQLException e){
            if(connection != null){
                connection.rollback();
            }
            throw e;
        }finally {
            if (connection!=null){
                try{
                    connection.setAutoCommit(true);
                    connection.close();
                }catch (SQLException e){
                    System.out.println("Error al cerrar la conextio: "+ e);
                }

            }
        }

    }

}
