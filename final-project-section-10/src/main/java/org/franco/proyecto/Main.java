package org.franco.proyecto;

import org.franco.proyecto.category.model.Category;
import org.franco.proyecto.category.persistence.CategoryDao;
import org.franco.proyecto.db.ConnetionPool;
import org.franco.proyecto.product.controller.ProductController;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.repository.ProductRepositoryServices;
import org.franco.proyecto.product.service.ProductService;
import org.franco.proyecto.product.view.ProductView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        try(Connection connection = ConnetionPool.getConnection()){
            System.out.println("Coneccion exitosa!");
            CategoryDao categoryDao = new CategoryDao(connection);
            ProductRepository productRepository = new ProductRepositoryServices(connection, categoryDao);
            ProductService productService = new ProductService(productRepository);
            ProductController productController = new ProductController(productService);
            ProductView productView =new ProductView(productController);
            productView.showMenu();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            ConnetionPool.closePool();
        }



//        try(Connection connection = ConnetionPool.getConnection()){
//
//            System.out.println("Conexion exitosa!");
//            // --- PRUEBA DEL CATEGORY DAO ---
//            CategoryDao categoryDao = new CategoryDao(connection);
//            System.out.println("/n ---Probando CategoryDAO ---");
//
//            // 1. Guardar Categorias
//            System.out.println("Guardando categorias...");
//
//            Category çomidas = new Category(null, "Comidas");
//            Category libros = new Category(null, "Libros");
//
//            categoryDao.save(çomidas);
//            categoryDao.save(libros);
//
//            // 2. Listar todas las categorias
//            System.out.println("/n Listando todas las categorias: ");
//            List<Category> allCategories= categoryDao.findAll();
//            allCategories.forEach(System.out::println);
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }finally {
//            ConnetionPool.closePool();
//        }


    }
}

