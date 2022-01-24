package com.example.orderservice.listener;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.Order.OrdStatusEnum;
import com.example.orderservice.service.OrderService;

@Component
public class Consumer {

	@Autowired
	OrderService orderService;
	
    @JmsListener(destination = "test.queue")
    public void consume(String message) {
        System.out.println(" Unsuccessful order, order Id: " + message);
        
       Order order = orderService.getOrderById(Integer.parseInt(message));
       
       order.setOrdStatus(OrdStatusEnum.FAILED);
       order.setDate(LocalDate.now());
		order.setTime(LocalTime.now());
       orderService.addOrder(order);
       
    }
}