package PageObjects;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageConstants.ConstantsVariables;

public class productPage {
 
	WebDriver pdriver;
	@FindBy(id = ConstantsVariables.item1)
	WebElement product1;
	
	@FindBy(id = ConstantsVariables.item2)
	WebElement product2;
	
	@FindBy(id = ConstantsVariables.item3)
	WebElement product3;
	
	@FindBy(className = ConstantsVariables.cartBadge)
	WebElement ItemsInCart;
	
	@FindBy(className = ConstantsVariables.cartbtn)
	WebElement cart_btn;
	
	@FindBy (className = ConstantsVariables.cartPageHeader)
	WebElement cartPagelogo;
	
	public productPage (WebDriver driver) {
		this.pdriver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void addItemsToCard() throws InterruptedException {
		product1.click();
		product2.click();
		pdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor j = (JavascriptExecutor)pdriver;
		j.executeScript("window.scrollBy(0,250)");
		 Thread.sleep(3000);
		product3.click();
	}	
	public void VerifyProductAddedToCard() {
		String numberofItem = ItemsInCart.getText();
		Assert.assertNotEquals(numberofItem,0);

	}
	
 public void navigateToCartPage() throws InterruptedException {
		cart_btn.click();
		String Actualheader = cartPagelogo.getText();
		 String Expectedheader = "YOUR CART";
		 Assert.assertEquals(Expectedheader, Actualheader);
		 Thread.sleep(1000);
		
	}
	
	
}

