package com.example.orderservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.orderservice.model.Customer;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;

@WebMvcTest(value = CreateOrderController.class)
public class CreateOrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;
	
	String example = "{\r\n"
			+ "  \"customerId\": 190,\r\n"
			+ "  \"orderProducts\": [\r\n"
			+ "    {\r\n"
			+ "      \"productId\": 185,\r\n"
			+ "      \"quantity\": 5\r\n"
			+ "    }\r\n"
			+ " \r\n"
			+ "  ]\r\n"
			+ "}";
	
	//@Test
	void testCreateOrderPost() throws Exception{
		Customer customer = new Customer();
		InputOrder inputOrder = new InputOrder();
		inputOrder.setCustomerId(190);
		inputOrder.setOrderProducts(null);
		Order order = new Order();
			
	//	Mockito.when(orderService.createOrderWithException(inputOrder)).thenReturn(order);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addProduct")
				.accept(MediaType.APPLICATION_JSON).content(example)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
}
