package com.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "operation_types")
@Entity
public class OperationTypeEntity implements Serializable {

    // Constants

    private static final long serialVersionUID = 6786812770459917642L;

    // Attributes

    @Id
    @Column(name = "id_operation_type")
    private int idOperationType;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "deleted_at")
    private Date deletedAt;

    // Constructors

    public OperationTypeEntity(int idOperationType, String name, String description) {

        this.idOperationType = idOperationType;
        this.name = name;
        this.description = description;

    }

    public OperationTypeEntity() {

        this.idOperationType = 0;
        this.name = "";
        this.description = "";

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

    public static long getSerialVersionUID() {

        return serialVersionUID;

    }

}


