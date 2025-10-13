package org.franco.proyecto.product.view;

import org.franco.proyecto.product.controller.ProductController;
import org.franco.proyecto.product.exceptions.InvalidProductException;
import org.franco.proyecto.product.exceptions.ProductNotFoundException;
import org.franco.proyecto.product.model.Product;
import org.franco.proyecto.product.model.ProductCategory;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductView {

    private final ProductController productController;
    private final Scanner scanner;

    public ProductView(ProductController productController) {
        this.productController = productController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        while (true){
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("4. Eliminar Producto por ID");
            System.out.println("5. Modificar Producto por ID");
            System.out.println("6. Salir");
            System.out.println("Opcion: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> findByIdProduct();
                case 4 -> deleteProduct();
                case 5 -> updateProduct();
                case 6 -> {
                    scanner.close();
                    return;
                }
            }
        }
    }

    public void addProduct() {
        try {
            long id = readValidLong("Ingrese el ID del producto",0);
            String nameProduct = readNonEmptyString("Ingrese el nombre del producto");
            double price = readValidDouble("Ingrese el precio del producto",10);
            int stock = readValidInteger("Ingrese el stock del producto", 1);
            String categoryString = readNonEmptyString("Ingrese la categoria del producto: \n ELECTRÓNICOS, COMIDAS, LIBROS, OTROS");
            ProductCategory category = ProductCategory.valueOf(categoryString.trim().toUpperCase());
            Product product = new Product(id,nameProduct,price,stock, category);
            productController.addProduct(product);
        }catch (InvalidProductException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("La categoria no existe");
        }
    }

    public void showAllProducts(){
        try {
            List<Product> products = productController.getAllProducts();
            products.forEach(this::showProduct);
        }catch (InvalidProductException e){
            System.out.println(e.getMessage());
        }
    }

    private void findByIdProduct(){
        long id = readValidLong("Ingrese el ID del producto",0);
        try {
            Optional<Product> product = productController.getProductByid(id);
            if (product.isPresent()){
                Product product1 = product.get();
                showProduct(product1);
            }else {
                System.out.println("EL producto no se encuentra en la BD");
            }
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateProduct(){
        long id = readValidLong("Ingrese el ID del producto",0);
        try {
            Optional<Product> product = productController.getProductByid(id);
            if (product.isPresent()){
                System.out.println("Producto a modificar");
                Product product1 = product.get();
                showProduct(product1);

                System.out.println("Seleccione el campo que desea modificar");
                System.out.println("1. Nombre");
                System.out.println("2. Precio ");
                System.out.println("3. Stock");
                System.out.println("4. Categoria");
                System.out.println("5. TODOS");
                System.out.println("6. Salir");

                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option){
                    case 1 -> product.get().setName(readNonEmptyString("Ingrese el nuevo nombre:"));
                    case 2 -> product.get().setPrice(readValidDouble("Ingrese el nuevo precio:", 0));
                    case 3 -> product.get().setStock(readValidInteger("Ingrese el nuevo stock del producto:", 0));
                    case 4 -> {
                        String categoryString = readNonEmptyString("Ingrese la categoria del producto: \n ELECTRÓNICOS, COMIDAS, LIBROS, OTROS");
                        product.get().setCategory(ProductCategory.valueOf(categoryString.trim().toUpperCase()));
                    }
                    case 5 -> {
                        product.get().setName(readNonEmptyString("Ingrese el nuevo nombre:"));
                        product.get().setPrice(readValidDouble("Ingrese el nuevo precio:", 0));
                        product.get().setStock(readValidInteger("Ingrese el nuevo stock del producto:", 0));
                        String categoryString = readNonEmptyString("Ingrese la categoria del producto: \n ELECTRÓNICOS, COMIDAS, LIBROS, OTROS");
                        product.get().setCategory(ProductCategory.valueOf(categoryString.trim().toUpperCase()));
                    }
                    case 6 -> {
                        return;
                    }
                }
                productController.updateProduct(product1);

            }else {
                System.out.println("EL producto no se encuentra en la BD");
            }
        } catch (InvalidProductException | ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private void deleteProduct(){
        long id = readValidLong("Ingrese el ID del producto",0);
        try {
            productController.removeProduct(id);
        } catch (ProductNotFoundException | InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showProduct(Product product){
        System.out.println("\nProducto:");
        System.out.println("Id: "+product.getId());
        System.out.println("Nombre: "+product.getName());
        System.out.println("Precio: "+product.getPrice());
        System.out.println("Stock: "+product.getStock());
        System.out.println("Categoria: "+product.getCategory());
        System.out.println("-------------------------------------");
    }

    private String readNonEmptyString(String message){
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine().trim();
            if(input.length() < 3){
                System.out.println("El valor no puede ser vacio o el nombre es muy corto");
            }
        }while (input.length() < 3);
        return input;
    }

    private Long readValidLong(String message, long min){
        long value;
        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Long.parseLong(input);

                if(value < min){
                    System.out.println("Debe ser al menos:"+ min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    private int readValidInteger(String message, long min){
        int value;
        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(input);

                if(value < min){
                    System.out.println("Debe ser al menos:"+ min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }

    private double readValidDouble(String message, long min){
        double value;
        do {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);

                if(value < min){
                    System.out.println("Debe ser al menos:"+ min);
                    continue;
                }
                return value;
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }


}
