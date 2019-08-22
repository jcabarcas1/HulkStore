package com.api.controller;

import javax.validation.Valid;

import com.api.entity.KardexDetailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ResponseHTTP> buyProduct(@RequestBody @Valid KardexDetailEntity kardexDetailEntity)
            throws Exception{

        return service.buyProduct(kardexDetailEntity);

    }

    @PutMapping("/sell")
    public ResponseEntity<ResponseHTTP> sellProduct(@RequestBody @Valid KardexDetailEntity kardexDetailEntity)
            throws Exception{

        return service.sellProduct(kardexDetailEntity);

    }

    @GetMapping()
    public ResponseEntity<ResponseHTTP> getAllProducts() {

        return service.getAllProducts();

    }

    @ExceptionHandler({ Exception.class })
    private ResponseEntity handleException(Exception e) {

        ResponseHTTP response = new ResponseHTTP();
        response.setMessage(e.getMessage());
        response.setDeveloperMessage(e.getLocalizedMessage());
        return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);

    }

}