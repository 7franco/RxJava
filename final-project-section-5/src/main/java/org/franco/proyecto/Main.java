package org.franco.proyecto;

import org.franco.proyecto.product.controller.ProductController;
import org.franco.proyecto.product.interfaces.ProductRepository;
import org.franco.proyecto.product.repository.ProductRepositoryServices;
import org.franco.proyecto.product.service.ProductService;
import org.franco.proyecto.product.view.ProductView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ProductRepository productRepository = new ProductRepositoryServices();
        ProductService productService = new ProductService(productRepository);
        ProductController productController = new ProductController(productService);
        ProductView productView =new ProductView(productController);
        productView.showMenu();

    }
}
