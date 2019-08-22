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

}