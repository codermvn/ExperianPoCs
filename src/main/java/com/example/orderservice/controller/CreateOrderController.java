package com.example.orderservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.orderservice.controllerapi.CreateOrderApi;
import com.example.orderservice.model.Customer;
import com.example.orderservice.model.ExceptionResponse;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import com.example.orderservice.transformer.CreateOrderTransformer;
import com.example.orderservice.util.OrderValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CreateOrderController implements CreateOrderApi {

	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "create Order", nickname = "createOrderPost", notes = "create Order ", response = Order.class, tags = {
			"orders", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "order added successfully", response = Order.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class) })
	@RequestMapping(value = "/createOrder", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	public ResponseEntity<Order> createOrderPost(
			@ApiParam(value = "Order to add") @Valid @RequestBody InputOrder inputOrder) {
		
		OrderValidator.validateOrder(inputOrder);
		
		Customer customer = restTemplate.getForObject("http://localhost:8082/getCustomer/{customerId}", Customer.class, inputOrder.getCustomerId());
		
		Order order = CreateOrderTransformer.getInstance(restTemplate).populateOrder(inputOrder, customer);
		Order addOrder = orderService.addOrder(order);
		
		return new ResponseEntity<>(addOrder, HttpStatus.OK);
	}
}
