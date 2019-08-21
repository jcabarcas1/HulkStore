package com.api.model;

import com.api.entity.KardexHeaderEntity;
import com.api.entity.ProductEntity;

import javax.persistence.*;
import java.io.Serializable;

public class KardexDetailModel implements Serializable {

    // Attributes

    private int id;
    private int quantity;
    private ProductEntity product;
    private KardexHeaderEntity kardexHeader;

    // Constructors

    public KardexDetailModel(int id, int quantity, ProductEntity product, KardexHeaderEntity kardexHeader) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.kardexHeader = kardexHeader;
    }

    // Getters & Setters methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public KardexHeaderEntity getKardexHeader() {
        return kardexHeader;
    }

    public void setKardexHeader(KardexHeaderEntity kardexHeader) {
        this.kardexHeader = kardexHeader;
    }

}


