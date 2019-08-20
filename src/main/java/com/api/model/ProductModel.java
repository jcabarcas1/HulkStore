package com.api.model;

import com.api.entity.ProductEntity;
import java.util.Date;

public class ProductModel {

    // Attributes

    private int idProduct;
    private String name;
    private String description;
    private int price;
    private int stock;
    private Date deletedAt;

    // Constructors

    public ProductModel() {

        this.idProduct = 0;
        this.name = "";
        this.description = "";
        this.stock = 0;
        this.price = 0;

    }

    public ProductModel(int idProduct, String name, String description, int price, String preparationTime, String type, int stock) {

        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;

    }

    public ProductModel(ProductEntity product) {

        this.idProduct = product.getIdProduct();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stock = product.getStock();

    }

    // Getters & Setters methods

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}