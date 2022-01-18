package com.example.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.exception.CustomerNotFoundException;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Order.OrdStatusEnum;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Order addOrder(Order order) {
		Order addedOrder = null;
		try {
			addedOrder = orderRepository.save(order);
		} catch (Exception e) {
			System.out.println(e);
		}
		return addedOrder;
	}
	
	public Order getOrderById(int id) {
		Order order = null;
		try {
			order = orderRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomerNotFoundException("order not found");
		}
		return order;
	}
	
	public Order deleteOrderById(int id) {
		Order deletedOrder = null;
		try {
			Order order = orderRepository.findById(id).get();
			order.setOrdStatus(OrdStatusEnum.FAILED);
			deletedOrder = orderRepository.save(order);
		} catch (Exception e) {
			throw new CustomerNotFoundException("order not found");
		}
		return deletedOrder;
	}
}
