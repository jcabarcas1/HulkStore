package com.api.model;

import com.api.entity.KardexDetailEntity;
import com.api.entity.ProductEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductModel implements Serializable {

    // Attributes
    private int idProduct;
    private String name;
    private String description;
    private int price;
    private int stock;
    private Date deletedAt;
    private List<KardexDetailEntity> kardexList = new ArrayList<>();

    // Constructors
    public ProductModel(int idProduct, String name, String description, int price, int stock, List<KardexDetailEntity> kardexList) {

        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.kardexList = kardexList;

    }

    public ProductModel(ProductEntity productEntity) {

        this.idProduct = productEntity.getIdProduct();
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.price = productEntity.getPrice();
        this.stock = productEntity.getStock();

    }

    public ProductModel() {

        this.idProduct = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.stock = 0;
        this.kardexList = null;

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

    public List<KardexDetailEntity> getKardexList() {

        return kardexList;

    }

    public void setKardexList(List<KardexDetailEntity> kardexList) {

        this.kardexList = kardexList;

    }

}


