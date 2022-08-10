package pageDefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.WebDriverMng;
import PageObjects.checkoutPage;
import PageObjects.productPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CheckoutPageDefinitions {
	WebDriver driver = WebDriverMng.getWebDriver();
	
	
	@When("User selects products")
	public void user_select_products() throws InterruptedException {
		productPage pp = new productPage(driver);
		pp.addItemsToCard();
	      
      	}
	
	@Then("the products is added into the cart")
	public void the_products_is_added_into_the_cart() {
	    
		productPage pp = new productPage(driver);
		pp.VerifyProductAddedToCard();
		
	}

	@Then("User click on cart icon")
	public void user_click_on_cart_icon() throws InterruptedException {
		productPage pp = new productPage(driver);
		pp.navigateToCartPage();
	}


	@And("User verifies products in the cart")
	public void user_verifies_products_in_the_cart() {
	  checkoutPage cp = new checkoutPage(driver);
	  cp.verifyItemsOnCheckout();
	  
	}

	@And("user clicks on checkout button")
	public void user_clicks_on_checkout_button() {
		  checkoutPage cp = new checkoutPage(driver);
		  cp.ContinueCheckout();
		  
	}
	
	

	@When("User enters Customer (.*), (.*) and(.*)$")
	public void user_enters_Customer_information( String Firtname, String LastName, String ZipCode) throws InterruptedException {
		 checkoutPage cp = new checkoutPage(driver);
		  cp.addCustomerDetails(Firtname,LastName,ZipCode);
	}


	@And("User clicks on finish button")
	public void user_clicks_on_finish_button() {
		checkoutPage cp = new checkoutPage(driver);
		  cp.paymentProcess();
	}

	@Then("order is placed successfully")
	public void order_is_placed_successfully() {
		checkoutPage cp = new checkoutPage(driver);
		  cp.orderCompleted();
	}

}
