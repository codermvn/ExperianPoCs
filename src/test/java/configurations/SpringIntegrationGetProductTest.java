package configurations;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.example.orderservice.OrderServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = OrderServiceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class SpringIntegrationGetProductTest {
 
    protected RestTemplate restTemplate = new RestTemplate();
 
    protected final String DEFAULT_URL = "http://localhost:8085/getProduct/{productId}";
}