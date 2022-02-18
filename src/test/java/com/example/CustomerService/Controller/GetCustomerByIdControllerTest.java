package com.example.CustomerService.Controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Service.CustomerService;
import com.example.model.Customer;

@SpringBootTest(classes = GetCustomerByIdController.class)
public class GetCustomerByIdControllerTest {

	@Autowired
	GetCustomerByIdController getCustomerByIdController;

	@MockBean
	private CustomerService customerService;
	
	@ParameterizedTest
	@CsvSource(value = { "1", "0" })
	void testGetCustomerCustomerIdGet(int id) throws CustomerNotFoundException {

		ResponseEntity<Customer> customer = getCustomerByIdController.getCustomerCustomerIdGet(id);
		assertNotNull(customer);
	}
}