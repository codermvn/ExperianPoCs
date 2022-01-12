package com.example.CustomerService.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.base.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	Customer findByCustomerName(String name);
}
