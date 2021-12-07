package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"pretty", "html:target/cucumber.html"}, // nice output to a file
	features = "src/test/resources/cuke", // where your features are stored
	stepNotifications = true, // so that JUnit will display the test steps
	monochrome = true // makes the console output more readable
)
public class CukeRunner {

}
