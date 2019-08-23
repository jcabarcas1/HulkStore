package com.api.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.api.entity.ProductEntity;
import com.api.model.ProductModel;

@Component("product_converter")
public class ProductConverter {

    public ProductModel convertProduct(ProductEntity productEntity) {

        ProductModel product = new ProductModel(productEntity);
        return product;

    }

    public List<ProductModel> productList(List<ProductEntity> productsEntity){

        List<ProductModel> products = new ArrayList<ProductModel>();
        for (ProductEntity productEntity : productsEntity) {
            ProductModel product = new ProductModel(productEntity);
            products.add(product);
        }
        return products;

    }

}