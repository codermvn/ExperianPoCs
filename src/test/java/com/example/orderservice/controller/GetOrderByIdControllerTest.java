package com.example.orderservice.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.example.model.Order;
import com.example.orderservice.exception.CustomerNotFoundException;
import com.example.orderservice.service.OrderService;

@SpringBootTest(classes = GetOrderByIdController.class)
public class GetOrderByIdControllerTest {

	@Autowired
	GetOrderByIdController getOrderByIdController;
	
	@MockBean
	private OrderService orderService;

	@ParameterizedTest
	@CsvSource(value = {"1","0" })
	void testGetOrderOrderIdGet(int id) throws CustomerNotFoundException {

		ResponseEntity<Order> order = getOrderByIdController.getOrderOrderIdGet(id);
		assertNotNull(order);
	}
}
