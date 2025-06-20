package com.example.NortwindTradersSpringBoot.model;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String name;
    private int categoryId;
    private BigDecimal price;

    public Product(int productId, String name, int categoryId, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", price='" + price;
    }
}
