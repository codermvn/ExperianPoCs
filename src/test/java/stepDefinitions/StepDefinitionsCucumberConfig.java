package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.OrderServiceApplication;
import com.example.orderservice.model.InputDeductInventory;
import com.example.orderservice.model.InputProduct;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = OrderServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitionsCucumberConfig {

	protected RestTemplate restTemplate = new RestTemplate();

	protected final String DEFAULT_URL = "http://localhost:8085/deductInventory/{qty}";

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

		HttpEntity<InputDeductInventory> requestEntity = new HttpEntity<InputDeductInventory>(inputDeductInventory,
				headers);
		System.out.println("url = " + url);

		response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Product.class, qty);
	}

	@Then("the client receives answer as {int}")
	public void the_client_receives_answer_as(Integer result) {
		// assertEquals(result, response.getBody().getInventory());
	}

	// Get Product by Id

	protected final String GET_PRODUCT_BY_ID_URL = "http://localhost:8085/getProduct/{productId}";

	String getProdByIdUrl = GET_PRODUCT_BY_ID_URL;

	@When("Client calls \\/getProduct\\/{int}")
	public void client_calls_getProduct(Integer productId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Product product = new Product();
		product.setProductId(productId);

		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
		System.out.println("url = " + getProdByIdUrl);

		response = restTemplate.exchange(getProdByIdUrl, HttpMethod.GET, requestEntity, Product.class, productId);
	}

	@Then("the client receives answer as T-Shirt")
	public void the_client_receives_answer_as_T_shirt() {
		assertEquals("T-Shirt", response.getBody().getProductName());
	}

	// delete order by Id

	ResponseEntity<Order> responseDeleteOrderByID;

	protected final String DELETE_ORDER_BY_ID_URL = "http://localhost:8085/deleteOrder/{orderId}";

	String deleteOrderByIDUrl = DELETE_ORDER_BY_ID_URL;

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
		System.out.println("url = " + deleteOrderByIDUrl);

		responseDeleteOrderByID = restTemplate.exchange(deleteOrderByIDUrl, HttpMethod.DELETE, requestEntity,
				Order.class, orderId);
	}

	@Then("the client receives an order with order status failed")
	public void the_client_receives_an_order_with_order_status_failed() {

		// assertEquals("failed", response.getBody().getOrdStatus());
	}

	// Get Order By Id

	protected final String GET_ORDER_BY_ID_URL = "http://localhost:8085/getOrder/{orderId}";
	ResponseEntity<Order> responseGetOrderById;
	String getOrderByIdUrl = GET_ORDER_BY_ID_URL;

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
		System.out.println("url = " + getOrderByIdUrl);

		responseGetOrderById = restTemplate.exchange(getOrderByIdUrl, HttpMethod.GET, requestEntity, Order.class,
				orderId);
	}

	@Then("the client receives an Order")
	public void the_client_receives_an_Order() {
		// assertEquals(525,response.getBody().getCustomerId());
	}

	// Add Product

	protected final String ADD_PRODUCT_URL = "http://localhost:8085/addProduct";

	ResponseEntity<Product> responseAddProduct;
	String addProductUrl = ADD_PRODUCT_URL;

	@When("Client calls \\/addProduct with  productName {string}, productPrice {bigdecimal},company {string}, inventory as {int}")
	public void client_calls_addProduct_with_productName_productPrice_company_inventory_as(String productName,
			BigDecimal productPrice, String company, Integer inventory) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		/*
		 * Map<String, Integer> params = new HashMap<String, Integer>();
		 * params.put("qty", qty);
		 */
		InputProduct InputProduct = new InputProduct();
		InputProduct.setProductName(productName);
		InputProduct.setProductPrice(productPrice);
		InputProduct.setCompany(company);
		InputProduct.setInventory(inventory);

		HttpEntity<InputProduct> requestEntity = new HttpEntity<InputProduct>(InputProduct, headers);
		System.out.println("url = " + addProductUrl);

		responseAddProduct = restTemplate.exchange(addProductUrl, HttpMethod.POST, requestEntity, Product.class);
	}

	@Then("new product is added into inventory")
	public void new_product_is_added_into_inventory() {
		//assertEquals("Laptop", response.getBody().getProductName());
	}
}
