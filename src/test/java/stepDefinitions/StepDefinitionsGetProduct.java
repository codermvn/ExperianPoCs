package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.orderservice.model.Product;

import configurations.SpringIntegrationGetProductTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsGetProduct extends SpringIntegrationGetProductTest{

	ResponseEntity<Product> response;
	String url = DEFAULT_URL;

@When("Client calls \\/getProduct\\/{int}")
public void client_calls_getProduct(Integer productId) {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	/*
	 * Map<String, Integer> params = new HashMap<String, Integer>();
	 * params.put("qty", qty);
	 */

	Product product = new Product();
	product.setProductId(productId);

	HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
	System.out.println("url = " + url);

	response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product.class,productId);
}

@Then("the client receives answer as T-shirt")
public void the_client_receives_answer_as_T_shirt() {
	assertEquals("T-Shirt", response.getBody().getProductName());
}

}
