package cucumber.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {

	private static RemoteWebDriver driver;

	@Before
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}
	
	@Given("that I can access {string}")
	public void that_i_can_access(String string) {
		driver.get("https://" + string);
	}
	
	@When("I search for {string}")
	public void i_search_for(String string) {
		driver.findElement(By.name("q")).sendKeys(string);
		driver.findElement(By.name("q")).submit();
	}
	
	@Then("I should be able to view {string}")
	public void i_should_be_able_to_view(String string) {
		assertEquals(string + " - Google Search", driver.getTitle());
	}

	@After
	public static void tearDown() {
		driver.quit();
		System.out.println("driver closed");
	}

	// Designed to return ChromeOptions to configure new ChromeDrivers in Selenium
	public static ChromeOptions chromeCfg() {
		ChromeOptions cOptions = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

}
