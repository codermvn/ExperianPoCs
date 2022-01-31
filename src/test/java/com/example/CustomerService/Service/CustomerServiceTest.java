package com.example.CustomerService.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Exception.InsufficientBalanceException;
import com.example.CustomerService.Repository.CustomerRepository;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.CustomerAmount;
import com.example.CustomerService.model.InputCustomer;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest{
	
	@InjectMocks
	private CustomerService customerService;

	@Mock
	CustomerRepository customerRepository;
	
	@Test
	void testGetCustomerById() {
		
		int id=1;
		Customer mockcustomer = new Customer();
		mockcustomer.setCustomerId(id);
		mockcustomer.setCustomerName("Shivangi");
		mockcustomer.setCustomerAddress("Kanpur");
		mockcustomer.setModeOfPayment("cash");
		BigDecimal val = new BigDecimal(2000);
		mockcustomer.setDebitAvailable(val);
		
		doReturn(Optional.of(mockcustomer)).when(customerRepository).findById(id);
		
		Customer customer = customerService.getCustomerById(id);
		
		assertNotNull(customer,"Customer with Id : "+id+" not found");
		assertEquals(id,customer.getCustomerId());
		assertEquals(mockcustomer.getCustomerName(),customer.getCustomerName());
		assertEquals(mockcustomer.getCustomerAddress(),customer.getCustomerAddress());
		assertEquals(mockcustomer.getDebitAvailable(),customer.getDebitAvailable());
		assertEquals(mockcustomer.getModeOfPayment(),customer.getModeOfPayment());
	}
	
	@Test
	void testGetCustomerByIdException()  {
		
		int id=1;
		Customer mockcustomer = new Customer();
		mockcustomer.setCustomerId(id);
		mockcustomer.setCustomerName("Shivangi");
		mockcustomer.setCustomerAddress("Kanpur");
		mockcustomer.setModeOfPayment("cash");
		BigDecimal val = new BigDecimal(2000);
		mockcustomer.setDebitAvailable(val);
		
		Mockito.doThrow(new CustomerNotFoundException("Exception from test class")).when(customerRepository).findById(Mockito.any(Integer.class));
		
		assertThrows(Exception.class, () -> {
			customerService.getCustomerById(id);
		});
	}
	
	@Test
	void testAddCustomer() {
		
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName("Mainak");
		inputCustomer.setCustomerAddress("Kolkata");
		BigDecimal val = new BigDecimal(20000);
		inputCustomer.setDebitAvailable(val);
		inputCustomer.setModeOfPayment("cash");
	
		Customer customer = new Customer();
		
		doReturn(customer).when(customerRepository).save(Mockito.any(Customer.class));
		
	    customerService.addCustomer(inputCustomer);
	}
	
	@Test
	void testCreateCustomerWithRuntimeException() {
		
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName("Mainak");
		inputCustomer.setCustomerAddress("Kolkata");
		BigDecimal val = new BigDecimal(20000);
		inputCustomer.setDebitAvailable(val);
		inputCustomer.setModeOfPayment("cash");
	
		Customer customer =  new Customer();
	
		doReturn(customer).when(customerRepository).save(Mockito.any(Customer.class));
		
		customerService.createCustomerWithRuntimeException(inputCustomer);
	}
	
	@Test
	void testCreateCustomerWithRuntimeExceptionWithException() {
		
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName("Mainak");
		inputCustomer.setCustomerAddress("Kolkata");
		BigDecimal val = new BigDecimal(20000);
		inputCustomer.setDebitAvailable(val);
		inputCustomer.setModeOfPayment("cash");
	
		Customer customer =  new Customer();
	
		doReturn(customer).when(customerRepository).findByCustomerNameAndCustomerAddressAndDebitAvailable(Mockito.anyString(), Mockito.anyString(), Mockito.any(BigDecimal.class));
		
		assertThrows(Exception.class, () -> {
			customerService.createCustomerWithRuntimeException(inputCustomer);
		});
	}

	@Test
	void testCreditAmountCustomer() {
		
		int id=1;
		Customer mockcustomer = new Customer();
		mockcustomer.setCustomerName("a");
		mockcustomer.setCustomerAddress("b");
		BigDecimal val = new BigDecimal(2000);
		mockcustomer.setDebitAvailable(val);
		mockcustomer.setModeOfPayment("cash");
		
		BigDecimal newVal = new BigDecimal(5000);
		mockcustomer.setDebitAvailable(val);
	
		Optional<Customer> customer = Optional.of(mockcustomer);
		
		doReturn(customer).when(customerRepository).findById(id);
		doReturn(customer.get()).when(customerRepository).save(Mockito.any(Customer.class));
		
		CustomerAmount customerAmount = new CustomerAmount();
		customerAmount.setCustomerId(1);
		customerAmount.setValue(newVal);
		
		customerService.creditAmountCustomer(customerAmount);
	}
	
	@Test
	void testDebitAmountCustomer() {
		
		int id=1;
		Customer mockcustomer = new Customer();
		mockcustomer.setCustomerName("a");
		mockcustomer.setCustomerAddress("b");
		BigDecimal val = new BigDecimal(5000);
		mockcustomer.setDebitAvailable(val);
		mockcustomer.setModeOfPayment("cash");
		
		BigDecimal newVal = new BigDecimal(2000);
	
		Optional<Customer> customer = Optional.of(mockcustomer);
		
		doReturn(customer).when(customerRepository).findById(id);
		doReturn(customer.get()).when(customerRepository).save(Mockito.any(Customer.class));
		
		CustomerAmount customerAmount = new CustomerAmount();
		customerAmount.setCustomerId(1);
		customerAmount.setValue(newVal);
	
		customerService.debitAmountCustomer(customerAmount);
	}
	
	@Test
	void testDebitAmountCustomerException() {
		
		int id=1;
		Customer mockcustomer = new Customer();
		mockcustomer.setCustomerName("a");
		mockcustomer.setCustomerAddress("b");
		BigDecimal val = new BigDecimal(2000);
		mockcustomer.setDebitAvailable(val);
		mockcustomer.setModeOfPayment("cash");
		
		BigDecimal newVal = new BigDecimal(5000);
	
		Optional<Customer> customer = Optional.of(mockcustomer);
		
		doReturn(customer).when(customerRepository).findById(id);
		
		CustomerAmount customerAmount = new CustomerAmount();
		customerAmount.setCustomerId(1);
		customerAmount.setValue(newVal);
	
		assertThrows(InsufficientBalanceException.class, () -> {
			customerService.debitAmountCustomer(customerAmount);
		});
	}
}