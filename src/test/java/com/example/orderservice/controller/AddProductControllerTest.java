package com.example.orderservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.orderservice.model.InputProduct;
import com.example.orderservice.model.Product;
import com.example.orderservice.service.ProductService;

@WebMvcTest(value = AddProductController.class)
public class AddProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;
	
	String example = "{\r\n"
			+ "    \"productName\": \"Mobile\",\r\n"
			+ "    \"productPrice\": 10000,\r\n"
			+ "    \"company\": \"Redmi\",\r\n"
			+ "    \"inventory\":5\r\n"
			+ "}";
	
	@Test
	void testAddProductPost() throws Exception{
		
		InputProduct inputProduct = new InputProduct();
		
		inputProduct.setProductName("Mobile");
		inputProduct.setCompany("Redmi");
		BigDecimal val = new BigDecimal(1000);
		inputProduct.setProductPrice(val);
		inputProduct.setInventory(5);
		
		Product product = new Product();
			
		Mockito.when(productService.addProduct(inputProduct)).thenReturn(product);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addProduct")
				.accept(MediaType.APPLICATION_JSON).content(example)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
	
	@ParameterizedTest
	@CsvSource(value={"1,0","1,2"})
	void testDeductInventoryPost(int productId,int qty) throws Exception{
		
		Product product = new Product();
		
		Mockito.when(productService.deductInventory(productId,qty)).thenReturn(product);
	}
}
