package com.example.CustomerService.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CustomerService.Exception.CustomerServiceException;
import com.example.model.CustomerAmount;
import com.example.model.InputCustomer;

@SpringBootTest
public class CustomerValidatorUtilTest {
	
	@ParameterizedTest
	@CsvSource(value={"null, null, 0, null",
			          "a, null, 0, null",
			          "null, a, 0, null",
			          "null, null, 50, null",
			          "null, null, 0, a"
			         }, 
	                 nullValues={"null"})
	void testValidateCustomerWithException(String customerName, String customerAddress, BigDecimal debitAvailable, String modeOfPayment) {
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName(customerName);
		inputCustomer.setCustomerAddress(customerAddress);
		inputCustomer.setDebitAvailable(debitAvailable);
		inputCustomer.setModeOfPayment(modeOfPayment);
		assertThrows(CustomerServiceException.class, () -> {
			CustomerValidator.validateCustomer(inputCustomer);
		});
	}
	
	@ParameterizedTest
	@CsvSource(value={"1,0"})
		void testValidateAmountWithException(int customerId,BigDecimal value) {
		CustomerAmount customerAmount = new CustomerAmount();
		customerAmount.setCustomerId(customerId);
		customerAmount.setValue(value);
		assertThrows(CustomerServiceException.class, () -> {
			CustomerValidator.validateAmount(customerAmount);
		});
	}
}
