package com.example.CustomerService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Repository.CustomerRepository;
import com.example.CustomerService.Service.CustomerService;
import com.example.demo.base.api.GetCustomerApi;
import com.example.demo.base.model.Customer;
import com.example.demo.base.model.ExceptionResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class GetCustomerByIdController implements GetCustomerApi {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepository customerRepository;

	@ApiOperation(value = "get customer By customerId", nickname = "getCustomerCustomerIdGet", notes = "you can get customer by customerId ", response = Customer.class, tags = {
			"customers", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search results matching criteria", response = Customer.class),
			@ApiResponse(code = 404, message = "search customer not found", response = ExceptionResponse.class) })
	@RequestMapping(value = "/getCustomer/{customerId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerCustomerIdGet(
			@ApiParam(value = "", required = true) @PathVariable("customerId") Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
