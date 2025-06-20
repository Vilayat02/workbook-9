package com.example.NortwindTradersSpringBoot.dao;

import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.model.Product;

import java.util.List;

public interface ProductDAO {

    public List<Product> getAll();
    public void delete();
    public void add(Product product);
}
