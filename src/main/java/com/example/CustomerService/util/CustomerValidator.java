package com.example.CustomerService.util;

import java.util.Optional;

import javax.validation.Valid;

import com.example.CustomerService.Exception.CustomerServiceException;
import com.example.demo.base.model.CustomerAmount;
import com.example.demo.base.model.InputCustomer;

public class CustomerValidator {
	public static final String BAD_REQUEST_MESSAGE = "bad Request: Required field value is invalid";
	
	public static void validateCustomer(InputCustomer inputCustomer) {
		if (!Optional.ofNullable(inputCustomer.getCustomerName()).isPresent() || !Optional.ofNullable(inputCustomer.getCustomerAddress()).isPresent()
				|| !Optional.ofNullable(inputCustomer.getDebitAvailable()).isPresent() || !Optional.ofNullable(inputCustomer.getModeOfPayment()).isPresent()) {
			throw new CustomerServiceException(BAD_REQUEST_MESSAGE);
		}
	}
	
	/**
	 * signum returns -1 for negative and 1 for positive and 0 for 0
	 * @param customerAmount
	 */
	public static void validateAmount(@Valid CustomerAmount customerAmount) {
		if (!Optional.ofNullable(customerAmount.getValue()).isPresent() || customerAmount.getValue().signum() == -1) {
			throw new CustomerServiceException(BAD_REQUEST_MESSAGE);
		}
	}
}
