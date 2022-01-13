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
import com.example.demo.base.api.CreditApi;
import com.example.demo.base.model.Customer;
import com.example.demo.base.model.CustomerAmount;
import com.example.demo.base.model.ExceptionResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class CreditByCustomerIdController implements CreditApi {

	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "credit amount", nickname = "creditPost", notes = "credit amount ", response = Customer.class, tags = {
			"customers", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "amount credited", response = Customer.class),
			@ApiResponse(code = 500, message = "internal server error", response = ExceptionResponse.class),
			@ApiResponse(code = 404, message = "Customer could not be found", response = ExceptionResponse.class),
			@ApiResponse(code = 400, message = "invalid input, object invalid, incase someone sends negative amount", response = ExceptionResponse.class) })
	@RequestMapping(value = "/credit", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" }, method = RequestMethod.POST)
	public ResponseEntity<Customer> creditPost(
			@ApiParam(value = "amount to be credited") @Valid @RequestBody CustomerAmount customerAmount)
			throws SQLException {

		customerService.creditAmountCustomer(customerAmount);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
}