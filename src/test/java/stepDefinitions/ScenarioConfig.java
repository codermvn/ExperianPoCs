package stepDefinitions;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.orderservice.OrderServiceApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = OrderServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ScenarioConfig {

}
