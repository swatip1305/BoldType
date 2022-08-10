package pageDefinitions;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.WebDriverMng;
import PageObjects.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageDefinitions {
	
	WebDriver driver = null;
	
	@Given("Browser launched successfully")
	public void initiateBrowser() {
		
		
	}
	
	@And("User is on the application login page")
	public void openApplication() throws InterruptedException {
	   Thread.sleep(10);
	}

	@When("User enters valid (.*) and (.*)$")
	public void user_enters_valid_userid_and_password(String userid, String password) throws InterruptedException {
	  loginPage lp = new loginPage();
	   lp.provideValidCred(userid, password);
	   Thread.sleep(1000);
	  
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage lp = new loginPage();
		lp.loginAction();
	   
	}

	@Then("User lands on application home page successfully")
	public void user_lands_on_application_home_page_successfully() throws InterruptedException {
		loginPage lp = new loginPage();
	   String Actual= lp.applicationPageValidation();
	   String Expected = "PRODUCTS";
	   Assert.assertEquals(Actual, Expected);
	   Thread.sleep(1000);
	}

	@Then("Close the browser")
	public void close_the_browser() {
	   WebDriverMng.closeBrowser();
	}
}
