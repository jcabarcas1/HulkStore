package com.api.repository;

import com.api.entity.KardexDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("kardex_detail_repository")
public interface KardexDetailRepository extends JpaRepository<KardexDetailEntity, Serializable>{
    //  Structure created for future implementations
}