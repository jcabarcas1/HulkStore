package com.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.entity.ProductEntity;
import com.api.resource.ResponseHTTP;
import com.api.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    @Qualifier("product_service")
    public ProductService service;

    @PutMapping()
    public ResponseEntity<ResponseHTTP> storeProduct(@RequestBody @Valid ProductEntity product) {

        return service.storeProduct(product);

    }

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

}