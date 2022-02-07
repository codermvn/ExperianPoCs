package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.base.model.Order;

import configurations.SpringIntegrationGetOrderById;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsGetOrderById extends SpringIntegrationGetOrderById {

	ResponseEntity<Order> response;
	String url = DEFAULT_URL;
	
@When("Client calls \\/getOrder\\/{int}")
public void client_calls_getOrder(Integer orderId) {
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);

	/*
	 * Map<String, Integer> params = new HashMap<String, Integer>();
	 * params.put("qty", qty);
	 */

	Order order = new Order();
	order.setOrderId(orderId);

	HttpEntity<Order> requestEntity = new HttpEntity<Order>(order, headers);
	System.out.println("url = " + url);

	response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order.class,orderId);
}

@Then("the client receives an Order")
public void the_client_receives_an_Order() {
	//assertEquals(525,response.getBody().getCustomerId());
}

}
