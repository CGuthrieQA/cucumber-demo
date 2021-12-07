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
//		driver = new ChromeDriver();
		driver = new ChromeDriver(chromeCfg());
		
//		Dimension dimension = new Dimension(1920, 1080);
//		driver.manage().window().setSize(dimension);
//
//		driver.manage().window().maximize();

	}
	
//	@Disabled("Do not run")
//	@BeforeEach
//	public void waitABit() { // throws Exception {
//	//Thread.sleep(3000);
//	
//	
//	//page load timeout
//	System.out.println("10 second page load timeout");
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//	
//
//	//implicit wait timeout
//	System.out.println("3 second implicit wait timeout");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//
//
//	//scripted timeout
//	System.out.println("5 second scripted timeout");
//	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
//	
//	
//	//non-depricated web driver wait 
//	System.out.println("1 second web driver wait");
//	new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.
//														elementToBeClickable(By.name("q")));
//														//presenceOfElementLocated(By.name("q")));
//														//visibilityOfElementLocated(By.name("q")));
//	}
//	
//	@Disabled("Do not run")
//	@Test
//	public void testTitle() {
//		System.out.println("testing google title");
//		driver.get("https://google.com");
//		assertEquals("Google", driver.getTitle());
//	}

	@Test
	public void testKittens() { 
		System.out.println("testing Kittens");
		driver.get("https://google.com");
		
		
		
		driver.findElement(By.name("q")).sendKeys("kittens");
		driver.findElement(By.name("q")).submit();
		
		assertEquals("kittens - Google Search", driver.getTitle());
	}

	@AfterAll
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
		//cOptions.setHeadless(true);
		
//		cOptions.addArguments("--window-size=800,600");
//		cOptions.addArguments("--start-maximized");
//		cOptions.addArguments("--headless");

		return cOptions;
	}

}
