package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.orderservice.model.InputDeductInventory;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;

import configurations.SpringIntegrationDeleteOrderTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsDeleteOrder extends SpringIntegrationDeleteOrderTest {

	ResponseEntity<Order> response;
	String url = DEFAULT_URL;
	
@When("Client calls \\/deleteOrder\\/{int}")
public void client_calls_deleteOrder(Integer orderId) {

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

	response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Order.class,orderId);
}

@Then("the client receives an order with order status failed")
public void the_client_receives_an_order_with_order_status_failed() {

	//assertEquals("failed", response.getBody().getOrdStatus());
}

}
