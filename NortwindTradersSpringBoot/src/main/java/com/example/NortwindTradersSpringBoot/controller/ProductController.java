package com.example.NortwindTradersSpringBoot.controller;


import com.example.NortwindTradersSpringBoot.model.Product;
import com.example.NortwindTradersSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> getAllCustomers() {
        return productService.getAllProduct();
    }
}
