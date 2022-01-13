package com.example.CustomerService.Controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Service.CustomerService;
import com.example.demo.base.api.CreateCustomerApi;
import com.example.demo.base.model.Customer;
import com.example.demo.base.model.ExceptionResponse;
import com.example.demo.base.model.InputCustomer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class AddCustomerController implements CreateCustomerApi {

	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "create customer", nickname = "createCustomerPost", notes = "create customer ", response = Customer.class, tags = {
			"customers", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful operation", response = Customer.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class),
			@ApiResponse(code = 409, message = "Customer already exists", response = ExceptionResponse.class) })
	@RequestMapping(value = "/createCustomer", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomerPost(
			@ApiParam(value = "Customer to add") @Valid @RequestBody InputCustomer inputCustomer) throws SQLException  {
		
			customerService.createCustomerWithRuntimeException(inputCustomer);
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
}