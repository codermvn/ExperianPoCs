package com.example.orderservice.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	Product findByProductNameAndProductPriceAndCompany(String productName, BigDecimal productPrice, String company);
	Product findByProductId(int id);
}