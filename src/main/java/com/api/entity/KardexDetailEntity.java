package com.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "kardex_details")
@Entity
public class KardexDetailEntity implements Serializable {

    // Constants

    private static final long serialVersionUID = 6786812770459917642L;

    // Attributes

    @Id
    @Column(name = "id")
    private int id;
    //
    @Column(name = "quantity")
    private int quantity;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private ProductEntity product;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kardex_header")
    private KardexHeaderEntity kardexHeader;

    // Constructors

    public KardexDetailEntity(int id, int quantity, ProductEntity product, KardexHeaderEntity kardexHeader) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.kardexHeader = kardexHeader;
    }

    // Getters & Setters methods

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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


