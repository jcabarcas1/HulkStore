package com.api.repository;

import com.api.entity.KardexHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("kardex_header_repository")
public interface KardexHeaderRepository extends JpaRepository<KardexHeaderEntity, Serializable>{
    //
}