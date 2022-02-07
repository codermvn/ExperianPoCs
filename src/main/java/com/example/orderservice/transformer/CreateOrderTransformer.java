package com.example.orderservice.transformer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.model.Customer;
import com.example.orderservice.model.InputOrder;
import com.example.orderservice.model.InputOrderProduct;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Order.OrdStatusEnum;
import com.example.orderservice.model.OrderProduct;
import com.example.orderservice.model.Product;
import com.example.orderservice.service.ProductService;

public class CreateOrderTransformer {
	
	RestTemplate restTemplate;
	
	ProductService productService;
	
	private CreateOrderTransformer(RestTemplate restTemplate,ProductService productService) {
		this.restTemplate = restTemplate;
		this.productService=productService;
	}
	
	public static CreateOrderTransformer getInstance(RestTemplate restTemplate,ProductService productService) {
		return new CreateOrderTransformer(restTemplate,productService);
	}
	
	public Order populateOrder(InputOrder inputOrder, Customer customer) {
		Order order = new Order();
		order.setCustomer(customer);
		BigDecimal totalValue = BigDecimal.ZERO;
		if (!CollectionUtils.isEmpty(inputOrder.getOrderProducts())) {
			
			for (InputOrderProduct eachOrderProduct: inputOrder.getOrderProducts()) {
				
				Integer productId = eachOrderProduct.getProductId();
				Integer quantity = eachOrderProduct.getQuantity();
     			Product product = productService.getProductById(productId);
				
				//Product product = restTemplate.getForObject("http://localhost:8082/getProduct/{productId}", Product.class, productId);
				
				/**
				 * below will deduct inventory for the product
				 */
				//restTemplate.postForObject("http://localhost:8082/deductInventory/{quantity}", productId, Product.class, quantity);
				addProductToOrder(order, product, eachOrderProduct);
				
				totalValue = totalValue.add(product.getProductPrice().multiply(new BigDecimal(quantity)));
			}
		}
		order.setOrderValue(totalValue);
		order.setDate(LocalDate.now());
		order.setTime(LocalTime.now());
		order.setOrdStatus(OrdStatusEnum.PENDING);
		return order;
	}

	public void deductInventoryFromProduct(InputOrder inputOrder) {
		for (InputOrderProduct eachOrderProduct: inputOrder.getOrderProducts()) {
			Integer productId = eachOrderProduct.getProductId();
			Integer quantity = eachOrderProduct.getQuantity();
			productService.deductInventory(productId, quantity);
			//restTemplate.postForObject("http://localhost:8082/deductInventory/{quantity}", productId, Product.class, quantity);
		}
	}
	
	private void addProductToOrder(Order order, Product product, InputOrderProduct eachOrderProduct) {
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setProduct(product);
			orderProduct.setQuantity(eachOrderProduct.getQuantity());
			orderProduct.setOrder(order);
			orderProduct.setDate(LocalDate.now());
			orderProduct.setTime(LocalTime.now());
			System.out.println(LocalDateTime.now());
			order.addOrderProductsItem(orderProduct);
	} 
}

