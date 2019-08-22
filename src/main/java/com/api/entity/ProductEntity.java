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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_product")
    private int idProduct;
    //
    @Column(name = "name")
    private String name;
    //
    @Column(name = "description")
    private String description;
    //
    @Column(name = "price")
    private int price;
    //
    @Column(name = "stock")
    private int stock;
    //
    @Column(name = "deleted_at")
    private Date deletedAt;
    //
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KardexDetailEntity> kardexList = new ArrayList<>();

    // Constructors
    public ProductEntity(int idProduct, String name, String description, int price, int stock, List<KardexDetailEntity> kardexList) {

        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.kardexList = kardexList;

    }

    public ProductEntity() {

        this.idProduct = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.stock = 0;
        this.kardexList = new ArrayList<>();

    }

    // Getters & Setters methods
    public static long getSerialVersionUID() {

        return serialVersionUID;

    }

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


