package com.api.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "kardex_headers")
@Entity
public class KardexHeaderEntity implements Serializable {

    // Constants

    private static final long serialVersionUID = 6786812770459917642L;

    // Attributes

    @Id
    @Column(name = "id_kardex_header")
    private int idKardexHeader;

    @Column(name = "document_buyer")
    private String documentBuyer;

    @Column(name = "document_seller")
    private String documentSeller;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @OneToMany(mappedBy = "kardexHeader", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<KardexDetailEntity> kardexList = new ArrayList<>();

    // Constructors

    public KardexHeaderEntity(int idKardexHeader, String documentBuyer, String documentSeller, String operationType, Date createdAt) {

        this.idKardexHeader = idKardexHeader;
        this.documentBuyer = documentBuyer;
        this.documentSeller = documentSeller;
        this.operationType = operationType;
        this.createdAt = createdAt;

    }

    public KardexHeaderEntity() {

        this.idKardexHeader = 0;
        this.documentBuyer = "";
        this.documentSeller = "";
        this.operationType = "";
        this.createdAt = new Date();

    }

    // Getters & Setters methods


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdKardexHeader() {
        return idKardexHeader;
    }

    public void setIdKardexHeader(int id) {
        this.idKardexHeader = id;
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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}


