package selenium;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumTest {

	private static RemoteWebDriver driver;

	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
	}

	@Test
	public void testKittens() { 
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("kittens");
		driver.findElement(By.name("q")).submit();
		assertEquals("kittens - Google Search", driver.getTitle());
	}

	@AfterAll
	public static void tearDown() {
		driver.quit();
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
