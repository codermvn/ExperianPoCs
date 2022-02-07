package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.orderservice.model.InputDeductInventory;
import com.example.orderservice.model.Product;

import configurations.SpringIntegrationDeductInventoryTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsDeductInventory extends SpringIntegrationDeductInventoryTest {

	ResponseEntity<Product> response;
	String url = DEFAULT_URL;

	@When("Client calls \\/deductInventory\\/{int} with productId as {int}")
	public void client_calls_deductInventory_with_productId_as(Integer qty, Integer productId) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		/*
		 * Map<String, Integer> params = new HashMap<String, Integer>();
		 * params.put("qty", qty);
		 */

		InputDeductInventory inputDeductInventory = new InputDeductInventory();
		inputDeductInventory.setProductId(productId);

		HttpEntity<InputDeductInventory> requestEntity = new HttpEntity<InputDeductInventory>(inputDeductInventory, headers);
		System.out.println("url = " + url);

		response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Product.class,qty);
	}

	@Then("the client receives answer as {int}")
	public void the_client_receives_answer_as(Integer result) {
		//assertEquals(result, response.getBody().getInventory());
	}
}
