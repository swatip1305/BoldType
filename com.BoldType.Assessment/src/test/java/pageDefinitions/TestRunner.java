package pageDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions (features= "src/test/java/Features/placeOrder.feature",
glue={"pageDefinitions"})

public class TestRunner {
	


}
