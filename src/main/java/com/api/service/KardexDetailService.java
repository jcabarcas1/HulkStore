package com.api.service;

import com.api.converter.KardexDetailConverter;
import com.api.converter.ProductConverter;
import com.api.entity.KardexDetailEntity;
import com.api.entity.ProductEntity;
import com.api.repository.KardexDetailRepository;
import com.api.repository.KardexHeaderRepository;
import com.api.repository.ProductRepository;
import com.api.resource.ResponseHTTP;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("kardex_detail_service")
@Transactional
public class KardexDetailService {

    @Autowired
    @Qualifier("kardex_detail_repository")
    public KardexDetailRepository repository;

    @Autowired
    @Qualifier("kardex_header_repository")
    public KardexHeaderRepository kardexHeaderRepository;

    @Autowired
    @Qualifier("product_repository")
    public ProductRepository product_repository;

    @Autowired
    @Qualifier("kardex_detail_converter")
    private KardexDetailConverter converter;

    public ResponseEntity<ResponseHTTP> storeKardexDetail(KardexDetailEntity kardexDetailEntity) {

        ResponseHTTP response = new ResponseHTTP();
        try {
            kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader());
            ProductEntity productEntity = product_repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct());
            if (!productEntity.equals(null)){
                productEntity.setStock(productEntity.getStock() - kardexDetailEntity.getQuantity());
                product_repository.save(productEntity);
            }
            repository.save(kardexDetailEntity);
            response.setMessage("Producto creado exitosamente.");
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            response.setMessage(e.toString());
            response.setDeveloperMessage(e.getLocalizedMessage());
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.BAD_REQUEST);
        }

    }
/*
    public ResponseEntity<ResponseHTTP> updateProduct(ProductEntity product){
        ResponseHTTP response = new ResponseHTTP();
        try {
            boolean exist = repository.existsById(product.getIdProduct());
            if(exist) {
                repository.save(product);
                response.setMessage("Producto actualizado correctamente.");
                return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.OK);
            }
            response.setMessage("El producto que quieres modificar, no se encuentra registrado.");
            return new ResponseEntity<ResponseHTTP>(response, response.getHttpHeaders(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
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

*/

}