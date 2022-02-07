package com.example.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.model.ExceptionResponse;
import com.example.orderservice.model.Product;
import com.example.orderservice.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GetProductByIdController {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "get product By productId", nickname = "getProductProductIdGet", notes = "you can get product by productId ", response = Product.class, tags = {
			"products", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "search results matching criteria", response = Product.class),
			@ApiResponse(code = 404, message = "search customer not found", response = ExceptionResponse.class) })
	@RequestMapping(value = "/getProduct/{productId}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public ResponseEntity<Product> getProductProductIdGet(
			@ApiParam(value = "", required = true) @PathVariable("productId") Integer productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}