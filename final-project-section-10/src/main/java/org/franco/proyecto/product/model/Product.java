package org.franco.proyecto.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.franco.proyecto.category.model.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private double price;
    private int stock;
    private Category category;
//    private ProductCategory category;


    public Product(String name, double price, int stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
}
