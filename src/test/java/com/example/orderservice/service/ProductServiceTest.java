package com.example.orderservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.InputProduct;
import com.example.model.Product;
import com.example.orderservice.repository.ProductRepository;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@InjectMocks
	private ProductService productService;

	@Mock
	ProductRepository productRepository;

	//@Test
	void testGetProductById() {
		
		int id=1;
		Product mockproduct = new Product();
		mockproduct.setProductId(id);
		mockproduct.setProductName("Laptop");
		mockproduct.setCompany("HP");
		mockproduct.setInventory(10);
		BigDecimal val = new BigDecimal(50000);
		mockproduct.setProductPrice(val);
		
		doReturn(Optional.of(mockproduct)).when(productRepository).findByProductId(id);
		
		Product product = productService.getProductById(id);
		
		assertNotNull(product,"product with Id : "+id+" not found");
		assertEquals(id,product.getProductId());
		assertEquals(mockproduct.getProductName(),product.getProductName());
		assertEquals(mockproduct.getCompany(),product.getCompany());
		assertEquals(mockproduct.getInventory(),product.getInventory());
		assertEquals(mockproduct.getProductPrice(),product.getProductPrice());
	}
	
	//@Test
	void testAddProduct() {
		
		InputProduct inputProduct = new InputProduct();
		inputProduct.setProductName("Laptop");
		inputProduct.setCompany("HP");
		inputProduct.setInventory(10);
		BigDecimal val = new BigDecimal(20000);
		inputProduct.setProductPrice(val);
		
		Product product =  new Product();
		
		Mockito.when(productService.addProduct(inputProduct)).thenReturn(product);
	}
	
	@Test
	void testDeductInventory() {}
	
	//@Test
	void testCreateProduct() {
		InputProduct inputProduct = new InputProduct();
		inputProduct.setProductName("Laptop");
		inputProduct.setCompany("HP");
		inputProduct.setInventory(10);
		BigDecimal val = new BigDecimal(50000);
		inputProduct.setProductPrice(val);
		
		Product product =  new Product();
		
		Mockito.when(productService.createProduct(inputProduct)).thenReturn(product);
	}
	
}
