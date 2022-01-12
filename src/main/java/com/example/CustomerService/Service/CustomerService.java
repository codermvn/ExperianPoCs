package com.example.CustomerService.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Repository.CustomerRepository;
import com.example.demo.base.model.Customer;
import com.example.demo.base.model.Customer.StatusEnum;
import com.example.demo.base.model.InputCustomer;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer getCustomerById(int id) {
		Customer customer = null;
		try {
			customer = customerRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomerNotFoundException("customer not found");
		}
		return customer;
	}

	public Customer addCustomer(@Valid InputCustomer inputCustomer) {
		Customer customer = new Customer();
		customer.setStatus(StatusEnum.ACTIVE);
		customer.setCustomerName(inputCustomer.getCustomerName());
		customer.setCustomerAddress(inputCustomer.getCustomerAddress());
		customer.setDebitAvailable(inputCustomer.getDebitAvailable());
		customer.setModeOfPayment(inputCustomer.getModeOfPayment());
		return customerRepository.save(customer);
	}
}
