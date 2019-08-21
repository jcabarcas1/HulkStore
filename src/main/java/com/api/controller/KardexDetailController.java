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
/*
    @PostMapping()
    public ResponseEntity<ResponseHTTP> updateProduct(@RequestBody @Valid ProductEntity product) {

        return service.updateProduct(product);

    }

    @GetMapping("/{id_product}")
    public ResponseEntity<ResponseHTTP> getByIdProduct(@PathVariable("id_product") int idProduct) {

        return service.getFindByIdProduct(idProduct);

    }

    @GetMapping()
    public ResponseEntity<ResponseHTTP> getAllProduct() {

        return service.getAllProducts();

    }

    @DeleteMapping()
    public ResponseEntity<ResponseHTTP> deleteProduct(@RequestBody @Valid ProductEntity product) {

        return service.deleteUser(product);

    }
*/
}