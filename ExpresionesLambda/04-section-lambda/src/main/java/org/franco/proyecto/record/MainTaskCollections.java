package org.franco.proyecto.record;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainTaskCollections {

    static void main(String[] args) {
        List<ProductDto> products = List.of(
                new ProductDto("Notebook", 1200.0),
                new ProductDto("Mouse", 25.5),
                new ProductDto("Keyboard", 55.0),
                new ProductDto("Keyboard", 89.0)
        );

//        List<String> list = products.stream().map(product-> product.name()+"$ "+ String.valueOf(product.price())).toList();

        List<String> list = products.stream()
                .map(product-> new ProductDto(product.name(), product.price()*0.9))
                .map(productDto -> String.format("%s: $%.2f", productDto.name(), productDto.price()))
                .toList();

        System.out.println(list);


        Map<String, List<ProductDto>> byPriceRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price()>50.0 ? "Caro": "Barato"
                ));

        System.out.println(byPriceRange);

        Map<String, Long> countRange = products.stream()
                .collect(Collectors.groupingBy(
                        productDto -> productDto.price()>50.0 ? "Caro": "Barato",
                        Collectors.counting()
                ));
        System.out.println(countRange);

        //2. Reducci'on matem'atica

//        Double total = products.stream()
//                .map(productDto -> productDto.price())
//                .reduce(0.0, (sum, price) ->sum + price);

//        Double total = products.stream()
//                .map(productDto -> productDto.price())
//                .reduce(0.0, (sum, price) -> {
//                    System.out.println("sum: "+ sum+ " price: "+price);
//                    sum = sum + price;
//                    return sum;
//                });

        Double total = products.stream()
                .map(ProductDto::price)
                .reduce(0.0, Double::sum);

        System.out.println(total);

        String productSummary =products.stream()
                .map(p-> p.name() + "( $"+p.price()+" )")
                .reduce("", (s1,s2) -> {
                    if(s1.isEmpty()){
                        return s2;
                    }else{
                        return s1+" | "+s2;
                    }
        });

        System.out.println(productSummary);

        //Conversion entre colecciones

        Set<Double> uniquePrices = products.stream()
                .map(ProductDto::price)
                .collect(Collectors.toSet());

        System.out.println(uniquePrices);

        Map<String, Double> productMap = products.stream()
                .collect(Collectors.toMap(
                        ProductDto::name,
                        ProductDto::price,
                        (oldVal, newVal) -> oldVal
                ));

        System.out.println(productMap);

        List<ProductDto> expensiveProducts = productMap.entrySet().stream()
                .filter(e -> e.getValue() > 60.00)
                .map(e -> new ProductDto(e.getKey(), e.getValue())).toList();

        System.out.println(expensiveProducts);
    }
}
