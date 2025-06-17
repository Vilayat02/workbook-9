package com.example.NortwindTradersSpringBoot.dao;

import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SimpleProductDAO implements ProductDAO{
    private List<Product> products;

    public SimpleProductDAO(List<Product> products) {
        this.products = products;
        this.products.add(new Product(2245, "Ketchap", 3, new BigDecimal(4.55)));
        this.products.add(new Product(2934, "Nori", 1, new BigDecimal(2.99)));
        this.products.add(new Product(8031, "Georgian dumplings", 2, new BigDecimal(7.99)));
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public void delete() {

    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }
}
