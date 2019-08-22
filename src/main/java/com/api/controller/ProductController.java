package com.api.controller;

import javax.validation.Valid;

import com.api.entity.KardexDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.entity.ProductEntity;
import com.api.resource.ResponseHTTP;
import com.api.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    @Qualifier("product_service")
    public ProductService service;

    @PostMapping()
    public ResponseEntity<ResponseHTTP> storeProduct(@RequestBody @Valid ProductEntity product) {

        return service.storeProduct(product);

    }

    @PutMapping("/buy")
    public ResponseEntity<ResponseHTTP> buyProduct(@RequestBody @Valid KardexDetailEntity kardexDetailEntity) {

        return service.buyProduct(kardexDetailEntity);

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

}