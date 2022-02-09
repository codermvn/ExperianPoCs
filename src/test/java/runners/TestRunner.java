package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*tags= "@SmokeTest or @RegularTest" is same as tags= "@SmokeTest, @RegularTest"*/
/*tags= "@SmokeTest and @RegularTest"*/
/*tags= "not @SmokeTest"*/
/*If you apply a tag above a feature, it will automatically apply this to all the scenarios*/

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = { "stepDefinitions"},
        		plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        		dryRun= false,
        		monochrome= true,
        		tags= "@SmokeTest or @RegularTest")

public class TestRunner {

}
