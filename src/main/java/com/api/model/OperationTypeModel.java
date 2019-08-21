package com.api.model;

import com.api.entity.OperationTypeEntity;
import com.api.entity.ProductEntity;

import java.util.Date;

public class OperationTypeModel {

    // Attributes

    private int idOperationType;
    private String name;
    private String description;
    private Date deletedAt;

    // Constructors

    public OperationTypeModel() {

        this.idOperationType = 0;
        this.name = "";
        this.description = "";

    }

    public OperationTypeModel(int idOperationType, String name, String description, int price, String preparationTime, String type, int stock) {

        this.idOperationType = idOperationType;
        this.name = name;
        this.description = description;

    }

    public OperationTypeModel(OperationTypeEntity operationType) {

        this.idOperationType = operationType.getIdOperationType();
        this.name = operationType.getName();
        this.description = operationType.getDescription();

    }

    // Getters & Setters methods

    public int getIdOperationType() {
        return idOperationType;
    }

    public void setIdOperationType(int idOperationType) {
        this.idOperationType = idOperationType;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

}