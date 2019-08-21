package com.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "products")
@Entity
public class ProductEntity implements Serializable {

    // Constants

    private static final long serialVersionUID = 6786812770459917642L;

    // Attributes

    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "deleted_at")
    private Date deletedAt;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "kardex_detail",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_kardex")
    )
    public List<KardexEntity> kardexList = new ArrayList<>();


    // Constructors

    public ProductEntity(int idProduct, String name, String description, int price, int stock) {

        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;

    }

    public ProductEntity() {

        this.idProduct = 0;
        this.name = "";
        this.description = "";
        this.stock = 0;
        this.price = 0;

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

    public List<KardexEntity> getKardexList() {

        return kardexList;

    }

    public void setKardexList(List<KardexEntity> kardexList) {

        this.kardexList = kardexList;

    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;

    }

}


