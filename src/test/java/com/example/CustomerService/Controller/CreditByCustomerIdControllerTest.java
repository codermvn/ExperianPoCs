package com.example.CustomerService.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Service.CustomerService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.CustomerAmount;

@SpringBootTest(classes = CreditByCustomerIdController.class)
public class CreditByCustomerIdControllerTest {

	@Autowired
	CreditByCustomerIdController creditByCustomerIdController;

	@MockBean
    private CustomerService customerService;
	
	@Test
	void testCreditPost() throws CustomerNotFoundException{
		
		CustomerAmount customerAmount = new CustomerAmount();
		
		BigDecimal value = new BigDecimal(5000);

		customerAmount.setCustomerId(1);
		customerAmount.setValue(value);
		
		ResponseEntity<Customer> customer = creditByCustomerIdController.creditPost(customerAmount);
		assertNotNull(customer);
	}
}