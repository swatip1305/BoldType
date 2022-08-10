package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageConstants.ConstantsVariables;

public class checkoutPage {
	
	WebDriver pdriver;
     
	
	@FindBy(className = ConstantsVariables.listofItems_elemts)
	List<WebElement> itemsInCart;
	
	@FindBy (id = ConstantsVariables.checkoutbtn)
	WebElement checkout_btn; 
	
	@FindBy (id = ConstantsVariables.firstName)
	WebElement Custmr_Fname;
	
	@FindBy (id = ConstantsVariables.lastName)
	WebElement Custmr_Lname;
	
	@FindBy (id = ConstantsVariables.zipCode)
	WebElement Custmr_zipc;
	
	@FindBy (id = ConstantsVariables.continuebtn)
	WebElement continue_btn;
	
	@FindBy(id = ConstantsVariables.finishbtn)
	WebElement PlaceOrder_btn;
	
	@FindBy(className = ConstantsVariables.Ordercomplete)
	WebElement Order_Conf_msg;
	
	public  checkoutPage(WebDriver driver) {
		this.pdriver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void verifyItemsOnCheckout() {
		
		  Assert.assertNotNull(itemsInCart);
		
	}
	
	public void ContinueCheckout() {
		checkout_btn.click();
	}
	
	public void addCustomerDetails(String f_name, String l_name, String z_code) throws InterruptedException {
		Custmr_Fname.sendKeys(f_name);
		Custmr_Lname.sendKeys(l_name);
		Custmr_zipc.sendKeys(z_code);
		//pdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 Thread.sleep(2000);
		continue_btn.click();
	}
	
	public void paymentProcess() {
		
		//pdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PlaceOrder_btn.click();
	}
	
	public void orderCompleted() {
		
		String ActualOrdertxt = Order_Conf_msg.getText();
		String ExpectedOrdertxt = "THANK YOU FOR YOUR ORDER";
		Assert.assertEquals(ActualOrdertxt, ExpectedOrdertxt);
		
	}

}
