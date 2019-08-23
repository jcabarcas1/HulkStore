package com.api.converter;

import com.api.entity.KardexDetailEntity;
import com.api.entity.KardexHeaderEntity;
import com.api.entity.ProductEntity;
import com.api.model.ProductModel;
import com.api.repository.KardexDetailRepository;
import com.api.repository.KardexHeaderRepository;
import com.api.repository.ProductRepository;
import com.api.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductConverterTests {

	@Autowired
	public ProductConverter converter;

	// Store product tests
	@Test
	public void testConvertProduct() {

		ProductEntity productEntity = new ProductEntity(1, "My Product", null, 0, 10, new ArrayList<>());
		assertEquals(converter.convertProduct(productEntity).getClass(), ProductModel.class);

	}

	// Store product tests
	@Test
	public void testProductList() {

		assertEquals(converter.productList(new ArrayList<ProductEntity>()), new ArrayList<ProductModel>());

	}

}

