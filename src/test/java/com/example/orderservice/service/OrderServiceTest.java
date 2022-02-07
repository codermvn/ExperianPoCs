package com.example.orderservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.orderservice.model.Order;
import com.example.orderservice.repository.OrderRepository;


@SpringBootTest
public class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;

	@Mock
	OrderRepository orderRepository;
	
	@Test
	void testAddOrder() {
		
	}
	
	@Test
	void testGetOrderById(){}

	
	//@ParameterizedTest
	@CsvSource(value={"1","0"})
	void getDeleteOrderById(int id) {
		
		Order order = new Order();
		Mockito.when(orderService.deleteOrderById(id)).thenReturn(order);
	}
	
	@Test
	void testCreateOrderWithException() {}
	
}
