package com.example.orderservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.orderservice.exception.CustomerNotFoundException;
import com.example.orderservice.model.Product;
import com.example.orderservice.service.ProductService;

@SpringBootTest(classes = GetProductByIdController.class)
public class GetProductByIdControllerTest {

	@Autowired
	GetProductByIdController getProductByIdController;
	
	@MockBean
	private ProductService productService;
	
	@ParameterizedTest
	@CsvSource(value = {"1","0" })
	void testGetProductProductIdGet(int id) throws CustomerNotFoundException {

		ResponseEntity<Product> product = getProductByIdController.getProductProductIdGet(id);
		assertNotNull(product);
	}
}
