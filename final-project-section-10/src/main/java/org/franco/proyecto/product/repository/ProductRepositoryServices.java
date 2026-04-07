package org.franco.proyecto.product.repository;

import org.franco.proyecto.category.persistence.CategoryDao;
import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.model.ProductCategory;
import org.franco.proyecto.product.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryServices implements ProductRepository {

    private final List<Product> products ;
    private final ProductDAO productDAO;
    private final CategoryDao categoryDao;

    public ProductRepositoryServices(Connection connection, CategoryDao categoryDao) throws SQLException {
        productDAO = new ProductDAO(connection, categoryDao);
        products = productDAO.findAll();
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Product> findAll() throws InvalidProductException {
        if (products.isEmpty()){
            throw new InvalidProductException("La lista esta vacia");
        }
        return products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

    public Optional<Product> findByIdDB(Long id) throws SQLException {
        return productDAO.findById(id);
    }

    @Override
    public void save(Product product) throws SQLException {
        productDAO.save(product);
        products.add(product);
    }

    @Override
    public void delete(Long id) throws SQLException {
        products.removeIf(product -> product.getId().equals(id));
        productDAO.delete(id);
    }

    @Override
    public List<Product> findByCategory(ProductCategory category){
        return products.stream().filter(product -> product.getCategory().equals(category)).toList();
    }

    @Override
    public void update(Optional<Product> product) throws ProductNotFoundException, SQLException {
        if(product.isPresent()){
            Long idToUpdate = product.get().getId();
            int index = findIndexById(idToUpdate);
            if(index != -1){
                products.set(index, product.get());
                productDAO.update(product.get());
            }else{
                throw new ProductNotFoundException("El producto que quiere actualizar no existe");
            }
        }else{
            throw new ProductNotFoundException("El producto que quiere actualizar no existe");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return products.stream().anyMatch(product -> product.getId().equals(id));
    }

    private int findIndexById(Long id){
        for (int i=0; i < products.size(); i++){
            if(products.get(i).equals(id)){
                return i;
            }
        }
        return -1;
    }

}
