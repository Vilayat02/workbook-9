package com.example.NortwindTradersSpringBoot.service;

import com.example.NortwindTradersSpringBoot.dao.ProductDAO;
import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDao;

    @Autowired
    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProduct() {
        return productDao.getAll();
    }
}
