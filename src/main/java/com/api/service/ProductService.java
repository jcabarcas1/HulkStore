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
@Transactional(rollbackFor = Exception.class)
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
        response.setData(repository.save(product));
        response.setMessage("Producto creado exitosamente.");
        return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.CREATED);

    }

    public ResponseEntity<ResponseHTTP> buyProduct(KardexDetailEntity kardexDetailEntity) throws Exception {

        ResponseHTTP response = new ResponseHTTP();
        kardexDetailEntity.getKardexHeader().setOperationType("buy");
        kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader());
        ProductEntity productEntity = repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct());
        if (productEntity != null) {
            productEntity.setStock(productEntity.getStock() + kardexDetailEntity.getQuantity());
            repository.save(productEntity);
        } else {
            throw new Exception("No existe el producto al cual esta intentando comprar.");
        }
        kardexDetailRepository.save(kardexDetailEntity);
        response.setMessage("Compra realizada exitosamente.");
        return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);

    }

    public ResponseEntity<ResponseHTTP> sellProduct(KardexDetailEntity kardexDetailEntity) throws Exception {

        ResponseHTTP response = new ResponseHTTP();
        kardexDetailEntity.getKardexHeader().setOperationType("sell");
        kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader());
        ProductEntity productEntity = repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct());
        if (productEntity != null) {
            int newStock = productEntity.getStock() - kardexDetailEntity.getQuantity();
            if (newStock < 0) {
                throw new Exception("No hay suficientes productos en stock.");
            }
            productEntity.setStock(newStock);
            repository.save(productEntity);
        }
        kardexDetailRepository.save(kardexDetailEntity);
        response.setMessage("Venta realizada exitosamente.");
        return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);

    }

    public ResponseEntity<ResponseHTTP> getAllProducts() {

        ResponseHTTP response = new ResponseHTTP();
        response.setData(converter.productList(repository.findAll()));
        response.setMessage("Se recuperaron exitosamente los productos.");
        return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);

    }

    public ResponseEntity<ResponseHTTP> getFindByIdProduct(int idProduct) {

        ResponseHTTP response = new ResponseHTTP();
        try {
            ProductEntity product = repository.findByIdProduct(idProduct);
            if (product == null) {
                response.setMessage("No se pudo encontrar este producto.");
                return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
            } else {
                response.setData(converter.convertProduct(product));
                response.setMessage("Se recuperaron exitosamente los productos.");
                return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }

    }

}