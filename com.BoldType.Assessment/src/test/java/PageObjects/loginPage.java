package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageConstants.ConstantsVariables;

public class loginPage {

	WebDriver ldriver;
	@FindBy(id = ConstantsVariables.usernamefield)
	WebElement username_txt;

	@FindBy(id = ConstantsVariables.passwordfield)
	WebElement password_txt;

	@FindBy(id = ConstantsVariables.loginbtn)
	WebElement login_btn;
	
	@FindBy(className = ConstantsVariables.mainPageHeader)
	WebElement homePageheader;

	public loginPage() {

		this.ldriver = WebDriverMng.getWebDriver();

		PageFactory.initElements(ldriver, this);

	}
	
	public void provideValidCred(String username, String pwd) {
	
		username_txt.sendKeys(username);
		 password_txt.sendKeys(pwd);
	}
	
	public void loginAction() {
		login_btn.click();
	}
	
	public String applicationPageValidation() {
		return homePageheader.getText();
	}
}