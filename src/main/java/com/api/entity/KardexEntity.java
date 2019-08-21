package com.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "kardex")
@Entity
public class KardexEntity implements Serializable {

    // Constants

    private static final long serialVersionUID = 6786812770459917642L;

    // Attributes

    @Id
    @Column(name = "id_kardex")
    private int idOperationType;
    @Column(name = "document_buyer")
    private String documentBuyer;
    @Column(name = "document_seller")
    private String documentSeller;
    @Column(name = "created_at")
    private Date createdAt;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "kardexList")
    private List<ProductEntity> kardexList = new ArrayList<>();
    @Column(name = "deleted_at")
    private Date deletedAt;

    // Constructors

    public KardexEntity(int idOperationType, String documentBuyer, String documentSeller, Date createdAt) {

        this.idOperationType = idOperationType;
        this.documentBuyer = documentBuyer;
        this.documentSeller = documentSeller;
        this.createdAt = createdAt;

    }

    public KardexEntity() {

        this.idOperationType = 0;
        this.documentBuyer = "";
        this.documentSeller = "";
        this.createdAt = new Date();

    }

    // Getters & Setters methods

    public int getIdOperationType() {

        return idOperationType;

    }

    public void setIdOperationType(int idOperationType) {

        this.idOperationType = idOperationType;

    }

    public String getDocumentBuyer() {

        return documentBuyer;

    }

    public void setDocumentBuyer(String documentBuyer) {

        this.documentBuyer = documentBuyer;

    }

    public String getDocumentSeller() {

        return documentSeller;

    }

    public void setDocumentSeller(String documentSeller) {

        this.documentSeller = documentSeller;

    }

    public Date getCreatedAt() {

        return createdAt;

    }

    public void setCreatedAt(Date createdAt) {

        this.createdAt = createdAt;

    }

    public List<ProductEntity> getKardexList() {

        return kardexList;

    }

    public void setKardexList(List<ProductEntity> kardexList) {

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


