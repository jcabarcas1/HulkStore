package com.api.service;

import com.api.entity.KardexDetailEntity;
import com.api.repository.KardexDetailRepository;
import com.api.repository.KardexHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.converter.ProductConverter;
import com.api.entity.ProductEntity;
import com.api.repository.ProductRepository;
import com.api.resource.ResponseHTTP;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service("product_service")
@Transactional
public class ProductService {


    @Autowired
    @Qualifier("product_repository")
    public ProductRepository repository;

    @Autowired
    @Qualifier("kardex_header_repository")
    public KardexHeaderRepository kardexHeaderRepository;

    @Autowired
    @Qualifier("kardex_detail_repository")
    public KardexDetailRepository kardexDetailRepository;

    @Autowired
    @Qualifier("product_converter")
    private ProductConverter converter;

    public ResponseEntity<ResponseHTTP> storeProduct(ProductEntity product) {
        ResponseHTTP response = new ResponseHTTP();
        try {
            repository.save(product);
            response.setMessage("Producto creado exitosamente.");
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage(e.getCause().toString());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseHTTP> buyProduct(KardexDetailEntity kardexDetailEntity){

        ResponseHTTP response = new ResponseHTTP();
        try {
            kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader());
            ProductEntity productEntity = repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct());
            if (!productEntity.equals(null)){
                productEntity.setStock(productEntity.getStock() - kardexDetailEntity.getQuantity());
                repository.save(productEntity);
            }
            kardexDetailRepository.save(kardexDetailEntity);
            response.setMessage("Compra realizada exitosamente.");
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage(e.toString());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<ResponseHTTP> getAllProducts() {
        ResponseHTTP response = new ResponseHTTP();
        try {
            response.setData(converter.productList(repository.findAll()));
            response.setMessage("Se recuperaron exitosamente los productos.");
            return new ResponseEntity <ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage(e.getCause().toString());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseHTTP> getFindByIdProduct(int idProduct) {
        ResponseHTTP response = new ResponseHTTP();
        try {
            ProductEntity product = repository.findByIdProduct(idProduct);
            if(product == null) {
                response.setMessage("No se pudo encontrar este producto.");
                return new ResponseEntity<ResponseHTTP> (response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
            }else {
                response.setData(converter.convertProduct(product));
                response.setMessage("Se recuperaron exitosamente los productos.");
                return new ResponseEntity<ResponseHTTP> (response, response.getHttpHeaders(), HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ResponseHTTP> deleteUser(ProductEntity product){
        ResponseHTTP response = new ResponseHTTP();
        try {
            repository.delete(product);
            response.setMessage("Producto eliminado correctamente.");
            return new ResponseEntity<ResponseHTTP> (response, response.getHttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }

    }



}