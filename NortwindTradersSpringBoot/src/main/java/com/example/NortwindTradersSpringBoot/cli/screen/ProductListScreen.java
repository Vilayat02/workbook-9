package com.example.NortwindTradersSpringBoot.cli.screen;

import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductListScreen {

    public void displayAllProducts(List<Product> products) {
        System.out.println("\n------------\n");
        products.forEach(System.out::println);
    }
}
