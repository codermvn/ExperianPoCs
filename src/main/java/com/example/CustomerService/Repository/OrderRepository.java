package com.example.CustomerService.Repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.base.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

	Order findByCustomerNameAndCustomerAddressAndDebitAvailable(String customerName, String customerAddress,
			BigDecimal debitAvailable);

}