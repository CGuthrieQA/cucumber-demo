package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/cuke/test.feature", // where features are stored
		//glue = "com.qa.cucumber.stepdefs", // where step definitions are stored
		stepNotifications = true, // so that JUnite will display the test steps
		monochrome = true, // make the console output readable
		plugin = {"pretty", "html:target/cucumber.html"} // nice output to html file
)
public class CukeRunner {


}
