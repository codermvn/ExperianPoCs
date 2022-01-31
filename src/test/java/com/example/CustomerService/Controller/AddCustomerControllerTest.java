package com.example.CustomerService.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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

import com.example.CustomerService.Service.CustomerService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.InputCustomer;

@WebMvcTest(value = AddCustomerController.class)
public class AddCustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	String example = "{\r\n"
			+ "	    \"customerName\": \"Mainak\",\r\n"
			+ "	    \"modeOfPayment\": \"cash\",\r\n"
			+ "	    \"customerAddress\": \"Kolkata\",\r\n"
			+ "	    \"debitAvailable\":20000\r\n"
			+ "	}\r\n"
			+ "	";
	
	@Test
	void testCreateCustomerPost() throws Exception {
		
		InputCustomer inputCustomer = new InputCustomer();
		inputCustomer.setCustomerName("Mainak");
		inputCustomer.setCustomerAddress("Kolkata");
		BigDecimal val = new BigDecimal(20000);
		inputCustomer.setDebitAvailable(val);
		inputCustomer.setModeOfPayment("cash");
		
		Customer customer = new Customer();

		Mockito.when(customerService.addCustomer(inputCustomer)).thenReturn(customer);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/createCustomer")
				.accept(MediaType.APPLICATION_JSON).content(example)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(200, response.getStatus());
	}
}
