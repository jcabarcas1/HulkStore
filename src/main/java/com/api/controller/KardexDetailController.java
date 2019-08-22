package com.api.controller;

import com.api.entity.KardexDetailEntity;
import com.api.entity.KardexHeaderEntity;
import com.api.entity.ProductEntity;
import com.api.resource.ResponseHTTP;
import com.api.service.KardexDetailService;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/kardex")
public class KardexDetailController {

    @Autowired
    @Qualifier("kardex_detail_service")
    public KardexDetailService service;

    @PutMapping()
    public ResponseEntity<ResponseHTTP> storeKardexDetail(@RequestBody @Valid KardexDetailEntity kardexDetailEntity) {

        return service.storeKardexDetail(kardexDetailEntity);

    }

}