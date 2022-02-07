package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.orderservice.model.InputProduct;
import com.example.orderservice.model.Product;

import configurations.SpringIntegrationAddProductTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsAddProduct extends SpringIntegrationAddProductTest{

	ResponseEntity<Product> response;
	String url = DEFAULT_URL;

@When("Client calls \\/addProduct with  productName {string}, productPrice {int},company {string}, inventory as {int}")
public void client_calls_addProduct_with_productName_productPrice_company_inventory_as
(String productName, BigDecimal productPrice, String company, Integer inventory) {

	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	/*
	 * Map<String, Integer> params = new HashMap<String, Integer>();
	 * params.put("qty", qty);
	 */
    InputProduct  InputProduct = new  InputProduct();
    InputProduct.setProductName(productName);
    InputProduct.setProductPrice(productPrice);
    InputProduct.setCompany(company);
    InputProduct.setInventory(inventory);
    
	HttpEntity<InputProduct> requestEntity = new HttpEntity<InputProduct>(InputProduct, headers);
	System.out.println("url = " + url);

	response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Product.class);
}

@Then("new product is added into inventory")
public void new_product_is_added_into_inventory() {
	assertEquals("Laptop", response.getBody().getProductName());
}

}
