package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageConstants.ConstantsVariables;


public class WebDriverMng {

	static WebDriver driver;
	
	
	
	public static WebDriver getWebDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(ConstantsVariables.BaseURL);
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void closeBrowser() {
		driver.quit();
			
	}
	
	public static void waitTime(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
}
