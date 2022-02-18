package com.example.orderservice.util;

import java.util.Optional;

import com.example.model.InputProduct;
import com.example.orderservice.exception.CustomerServiceException;


public class ProductValidator {
	public static final String BAD_REQUEST_MESSAGE = "bad Request: Required field value is invalid";
	
	public static void validateProduct(InputProduct inputProduct) {
		if (!Optional.ofNullable(inputProduct.getProductName()).isPresent() || !Optional.ofNullable(inputProduct.getProductPrice()).isPresent()
				|| !Optional.ofNullable(inputProduct.getCompany()).isPresent() || !Optional.ofNullable(inputProduct.getInventory()).isPresent()) {
			throw new CustomerServiceException(BAD_REQUEST_MESSAGE);
		}
	}
}
