package com.api.service;

import com.api.converter.ProductConverter;
import com.api.entity.KardexDetailEntity;
import com.api.entity.KardexHeaderEntity;
import com.api.entity.ProductEntity;
import com.api.model.ProductModel;
import com.api.repository.KardexDetailRepository;
import com.api.repository.KardexHeaderRepository;
import com.api.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {

	// Mock repositories
	@Mock
	public ProductRepository repository;
	@Mock
	public KardexHeaderRepository kardexHeaderRepository;
	@Mock
	public KardexDetailRepository kardexDetailRepository;
	@Mock
	public ProductConverter productConverter;

	// Services
	@InjectMocks
	public ProductService service;

	// Store product tests
	@Test
	public void testStoreProductFromAllData() {

		ProductEntity product = new ProductEntity();
		product.setStock(5);
		product.setDescription("Dummy description");
		product.setName("My product");
		product.setPrice(1000);
		ProductEntity productResponse = product;
		productResponse.setIdProduct(1);
		when(repository.save(product)).thenReturn(productResponse);
		ProductEntity responseService = (ProductEntity) service.storeProduct(product).getBody().getData();

		assertTrue(responseService.equals(productResponse));

	}

	@Test(expected = Exception.class)
	public void testStoreProductWithNameNull() {

		ProductEntity product= new ProductEntity();
		product.setName(null);

		when(repository.save(product)).thenThrow(new Exception());

		ProductEntity responseService = (ProductEntity) service.storeProduct(product).getBody().getData();

	}

	// Buy products tests
	@Test
	public void testBuyProductFromAllData() throws Exception {

		KardexDetailEntity kardexDetailEntity = new KardexDetailEntity();
		kardexDetailEntity.setProduct(new ProductEntity(1, "My Product", null, 0, 0, new ArrayList<>()));
		kardexDetailEntity.setKardexHeader(new KardexHeaderEntity());
		kardexDetailEntity.setQuantity(5);

		when(kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader()))
				.thenReturn(kardexDetailEntity.getKardexHeader());
		when(kardexDetailRepository.save(kardexDetailEntity))
				.thenReturn(kardexDetailEntity);
		when(repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct()))
				.thenReturn(kardexDetailEntity.getProduct());
		when(repository.save(kardexDetailEntity.getProduct()))
				.thenReturn(kardexDetailEntity.getProduct());

		assert(service.buyProduct(kardexDetailEntity).getStatusCode() == HttpStatus.OK);

	}

	@Test(expected = Exception.class)
	public void testBuyProductNotExist() throws Exception {

		KardexDetailEntity kardexDetailEntity = new KardexDetailEntity();
		kardexDetailEntity.setProduct(new ProductEntity(1, "My Product", null, 0, 0, new ArrayList<>()));
		kardexDetailEntity.setKardexHeader(new KardexHeaderEntity());
		kardexDetailEntity.setQuantity(5);

		when(kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader()))
				.thenReturn(kardexDetailEntity.getKardexHeader());
		when(kardexDetailRepository.save(kardexDetailEntity))
				.thenReturn(kardexDetailEntity);
		when(repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct()))
				.thenReturn(null);
		when(repository.save(kardexDetailEntity.getProduct()))
				.thenReturn(kardexDetailEntity.getProduct());

		service.buyProduct(kardexDetailEntity);

	}

	// Sell products tests
	@Test
	public void testSellProductFromAllData() throws Exception {

		KardexDetailEntity kardexDetailEntity = new KardexDetailEntity();
		kardexDetailEntity.setProduct(new ProductEntity(1, "My Product", null, 0, 10, new ArrayList<>()));
		kardexDetailEntity.setKardexHeader(new KardexHeaderEntity());
		kardexDetailEntity.setQuantity(5);

		when(kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader()))
				.thenReturn(kardexDetailEntity.getKardexHeader());
		when(kardexDetailRepository.save(kardexDetailEntity))
				.thenReturn(kardexDetailEntity);
		when(repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct()))
				.thenReturn(kardexDetailEntity.getProduct());
		when(repository.save(kardexDetailEntity.getProduct()))
				.thenReturn(kardexDetailEntity.getProduct());

		assert(service.sellProduct(kardexDetailEntity).getStatusCode() == HttpStatus.OK);

	}

	@Test(expected = Exception.class)
	public void testSellProductWithoutStockData() throws Exception {

		KardexDetailEntity kardexDetailEntity = new KardexDetailEntity();
		kardexDetailEntity.setProduct(new ProductEntity(1, "My Product", null, 0, 0, new ArrayList<>()));
		kardexDetailEntity.setKardexHeader(new KardexHeaderEntity());
		kardexDetailEntity.setQuantity(5);

		when(kardexHeaderRepository.save(kardexDetailEntity.getKardexHeader()))
				.thenReturn(kardexDetailEntity.getKardexHeader());
		when(kardexDetailRepository.save(kardexDetailEntity))
				.thenReturn(kardexDetailEntity);
		when(repository.findByIdProduct(kardexDetailEntity.getProduct().getIdProduct()))
				.thenReturn(kardexDetailEntity.getProduct());
		when(repository.save(kardexDetailEntity.getProduct()))
				.thenReturn(null);

		service.sellProduct(kardexDetailEntity);

	}

	// Get products tests
	@Test
	public void testGetAllProducts() throws Exception {

		when(repository.findAll()).thenReturn(new ArrayList<ProductEntity>());
		when(productConverter.productList(new ArrayList<ProductEntity>())).thenReturn(new ArrayList<ProductModel>());
		assert(service.getAllProducts().getStatusCode() == HttpStatus.OK);

	}

}

