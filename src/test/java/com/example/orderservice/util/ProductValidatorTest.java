package com.example.orderservice.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.InputProduct;
import com.example.orderservice.exception.CustomerServiceException;

@SpringBootTest
public class ProductValidatorTest {

	@ParameterizedTest
	@CsvSource(value={"null, null, 0, null",
	          "a, null, 0, null",
	          "null, a, 0, null",
	          "null, null, 50, null",
	          "null,null,-2000,null"
	          }, 
           nullValues={"null"})
	void validateProduct(String productName, String company, BigDecimal productPrice, Integer inventory) {
		
		InputProduct inputProduct = new InputProduct();
		inputProduct.setProductName(productName);
		inputProduct.setCompany(company);
		inputProduct.setProductPrice(productPrice);
		inputProduct.setInventory(inventory);
		
		assertThrows(CustomerServiceException.class, () -> {
			ProductValidator.validateProduct(inputProduct);
		});
	}
	
}
