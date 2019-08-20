package com.api.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.ProductEntity;

@Repository("product_repository")
public interface ProductRepository extends JpaRepository<ProductEntity, Serializable>{

    ProductEntity findByIdProduct(int idProduct);

}