package org.franco.proyecto.category.persistence;

import org.franco.proyecto.category.model.Category;
import org.franco.proyecto.db.ConnetionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDao {

//    private final Connection connection;
//    public CategoryDao(Connection connection) {
//        this.connection = connection;
//    }

    public Optional<Category> save(Connection connection, Category category) throws SQLException {
        String sql = "INSERT INTO categories (name)"+
                "VALUES (?)";
        try (
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1, category.getName());
            int rows = statement.executeUpdate();

            if(rows>0){
                try(ResultSet generatedKey = statement.getGeneratedKeys()){
                    if(generatedKey.next()){
                        long id = generatedKey.getLong(1);
                        category.setId(id);
                        return Optional.of(category);

                    }
                }
                System.out.println("La categoria fue creada correctamente...");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    public List<Category> findAll(Connection connection){
        String sql = "SELECT * FROM categories";
        List<Category> categories = new ArrayList<>();
        try (
//                Connection connection =  ConnetionPool.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()

        ){
            while (resultSet.next()){
                Category category = mapResult(resultSet);
                categories.add(category);
            }


            System.out.println("Consultados...");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return categories;
    }

    void update(Connection connection, Category category){
        String sql = "UPDATE categories SET name=? WHERE id = ?";

        try (
                PreparedStatement statement = connection.prepareStatement(sql)
        ){

            statement.setString(1, category.getName());
            statement.setLong(2, category.getId());

            int rows = statement.executeUpdate();
            showMessage(rows, "Categoria actualizada correctamente...", "No se encontro la categoria para actualizar...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    void delete(Connection connection, Long id){
        String sql = "DELETE FROM categories where id=?";

        try (
                PreparedStatement statement = connection.prepareStatement(sql)
        ){

            statement.setLong(1, id);

            int rows = statement.executeUpdate();
            showMessage(rows, "Categoria fue eliminada correctamente...","No se encontro la categoria para elimininar...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Optional<Category> findById(Connection connection, Long id){
        String sql = "Select * from categories where id=?";
        List<Category> categories = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }

            System.out.println("Consultados...");
            return Optional.empty();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Optional<Category> findCategoryByName(Connection connection, String categoryName){
        String sql = "Select * from categories where name=?";
        List<Category> categories = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, categoryName);
            try(ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    return Optional.of(mapResult(resultSet));
                }
            }

            System.out.println("Consultados...");
            return Optional.empty();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }



    private void showMessage(int rows, String messageOk, String messageError){
        if(rows > 0) {
            System.out.println(messageOk);
        }else if (messageError.isBlank()){
            System.out.println(messageError);
        }
    }

    private Category mapResult(ResultSet resultSet) throws SQLException {
        Category category = new Category(
                resultSet.getLong("id"),
                resultSet.getString("name")
        );

        return category;
    }
}
