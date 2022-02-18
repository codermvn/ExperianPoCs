package stepDefinitions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.example.model.Product;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ScenarioOutlineFeatureConfig extends ScenarioConfig {

	protected RestTemplate restTemplate = new RestTemplate();
	
	protected final String GET_PRODUCT_BY_ID_URL = "http://localhost:8085/getProduct/{productId}";

	String getProdByIdUrl = GET_PRODUCT_BY_ID_URL;
	
	@Given("Client calls getProduct with product id as {int}")
	public void client_calls_get_product_with_product_id_as(Integer productId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		Product product = new Product();
		product.setProductId(productId);

		HttpEntity<Product> requestEntity = new HttpEntity<Product>(product, headers);
		System.out.println("url = " + getProdByIdUrl);

		restTemplate.exchange(getProdByIdUrl, HttpMethod.GET, requestEntity, Product.class, productId);
	}

	@Then("the client receives the product")
	public void the_client_receives_the_product() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
}
