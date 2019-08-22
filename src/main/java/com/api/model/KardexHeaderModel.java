package com.api.model;

import com.api.entity.KardexDetailEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KardexHeaderModel implements Serializable {

    // Attributes
    private int idKardexHeader;
    private String documentBuyer;
    private String documentSeller;
    private String operationType;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private List<KardexDetailEntity> kardexList = new ArrayList<>();

    // Constructors
    public KardexHeaderModel(int idKardexHeader, String documentBuyer, String documentSeller, String operationType) {

        this.idKardexHeader = idKardexHeader;
        this.documentBuyer = documentBuyer;
        this.documentSeller = documentSeller;
        this.operationType = operationType;

    }

    public KardexHeaderModel() {

        this.idKardexHeader = 0;
        this.documentBuyer = "";
        this.documentSeller = "";
        this.operationType = "";

    }

    // Getters & Setters methods
    public int getIdKardexHeader() {

        return idKardexHeader;

    }

    public void setIdKardexHeader(int idKardexHeader) {

        this.idKardexHeader = idKardexHeader;

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

    public Date getUpdatedAt() {

        return updatedAt;

    }

    public void setUpdatedAt(Date updatedAt) {

        this.updatedAt = updatedAt;

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


