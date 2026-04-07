package org.franco.proyecto.product.persistence;

import org.franco.proyecto.category.model.Category;
import org.franco.proyecto.category.persistence.CategoryDao;
import org.franco.proyecto.db.ConnetionPool;
import org.franco.proyecto.product.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO {

    private final CategoryDao categoryDao;

    public ProductDAO(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public Product save(Connection connection, Product product) throws SQLException {
        String sql = "INSERT INTO products (name, price, stock, category_id) "+
                "VALUES (?, ?, ?, ?)  RETURNING id";
        try(
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
                ){

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());
            int rows = statement.executeUpdate();
            if(rows>0){
                try(ResultSet generatedKey = statement.getGeneratedKeys()){
                    if(generatedKey.next()){
                        product.setId(generatedKey.getLong(1));
                        System.out.println("Producto ingresado correctamente!...");
                    }
                }
            }
        }
        return product;
    }

    public List<Product> findAll(Connection connection) throws SQLException {
        String sql = "SELECT p.ID, p.NAME, p.PRICE, p.stock, p.category_id, c.NAME as category_name\n" +
                " FROM products p JOIN categories c on p.category_id = c.id";
        List<Product> products = new ArrayList<>();
        try(
                PreparedStatement statement = connection.prepareStatement(sql)
                ){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Product product = mapResult(resultSet);
                products.add(product);
            }
            System.out.println("Consultados...");
        }

        return products;
    }

    public void update(Connection connection, Product product) throws SQLException {
        String sql = "UPDATE products SET name=?, price=?, stock=?, category_id=? " +
                " WHERE id = ?";
        try(
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getStock());
            statement.setLong(4, product.getCategory().getId());
            statement.setLong(5, product.getId());
            int rows = statement.executeUpdate();
            showMessage(rows, "Producto actualizado correctamente...", "No se encontro el producto para actualizar...");
        }
    }

    public void delete(Connection connection, Long id) throws SQLException {
        String sql = "DELETE FROM products where id=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            int rows = statement.executeUpdate();
//            showMessage(rows, "Producto fue eliminado correctamente...","No se encontro el producto para elimininar...");
        }
    }

    public boolean existById(Connection connection, Long id){
        if(id == null)return false;
        String sql = "Select Count(*) from products where id=?";
        List<Category> products = new ArrayList<>();
        try(
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return resultSet.getInt(1) > 0;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return false;
    }

    public Optional<Product> findById(Connection connection, Long id) throws SQLException {
        String sql = "SELECT p.ID, p.NAME, p.PRICE, p.stock, p.category_id, c.NAME as category_name\n" +
                " FROM products p JOIN categories c on p.category_id = c.id " +
                " WHERE p.id=?";
        try(
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }
            System.out.println("Consultados...");
        }

        return Optional.empty();
    }

    public List<Product> findByCategoryId(Connection connection, Long categoryId) throws SQLException {
        String sql = "SELECT p.ID, p.NAME, p.PRICE, p.stock, p.category_id, c.NAME as category_name\n" +
                " FROM products p JOIN categories c on p.category_id = c.id " +
                " WHERE p.category_id=?";
        List<Product> products = new ArrayList<>();
        try(
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1, categoryId);
            try(ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    products.add(mapResult(resultSet));
                }
            }
            System.out.println("Consultados...");
        }

        return products;
    }

    private void showMessage(int rows, String messageOk, String messageError){
        if(rows > 0) {
            System.out.println(messageOk);
        }else if (messageError.isBlank()){
            System.out.println(messageError);
        }
    }

    private Product mapResult(ResultSet resultSet) throws SQLException {
        Long idCat = resultSet.getLong("category_id");
        String nameCat = resultSet.getString("category_name");
        Category category = new Category(idCat, nameCat);
        Product product = new Product(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock"),
                category

        );

        return product;
    }
}
