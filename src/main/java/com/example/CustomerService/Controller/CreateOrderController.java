package com.example.CustomerService.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.Controllerapi.CreateOrderApi;
import com.example.CustomerService.Service.CustomerService;
import com.example.CustomerService.Service.OrderService;
import com.example.CustomerService.Service.ProductService;
import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.ExceptionResponse;
import com.example.CustomerService.model.InputOrder;
import com.example.CustomerService.model.InputOrderProduct;
import com.example.CustomerService.model.Order;
import com.example.CustomerService.model.Order.OrdStatusEnum;
import com.example.CustomerService.model.OrderProduct;
import com.example.CustomerService.model.Product;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CreateOrderController implements CreateOrderApi {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;
	
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
		
		Customer customer = customerService.getCustomerById(inputOrder.getCustomerId());
		
		Order order = new Order();
		order.setCustomer(customer);
		BigDecimal totalValue = BigDecimal.ZERO;
		if (!CollectionUtils.isEmpty(inputOrder.getOrderProducts())) {
			
			for (InputOrderProduct eachOrderProduct: inputOrder.getOrderProducts()) {
				Integer productId = eachOrderProduct.getProductId();
				
				Product product = productService.getProductById(productId);
				
				addProductToOrder(order, product, eachOrderProduct);
				
				totalValue = totalValue.add(product.getProductPrice().multiply(new BigDecimal(eachOrderProduct.getQuantity())));
			}
		}
		order.setOrderValue(totalValue);
		order.setOrdStatus(OrdStatusEnum.SUCCESS);
		Order addOrder = orderService.addOrder(order);
		
		return new ResponseEntity<>(addOrder, HttpStatus.OK);
	}

	private void addProductToOrder(Order order, Product product, InputOrderProduct eachOrderProduct) {
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(product);
			orderProduct.setQuantity(eachOrderProduct.getQuantity());
			orderProduct.setOrder(order);
			orderProduct.setDate(LocalDate.now());
			order.addOrderProductsItem(orderProduct);
	}
}
