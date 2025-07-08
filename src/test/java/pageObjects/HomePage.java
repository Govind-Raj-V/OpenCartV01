package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement MyAccountLink;
	@FindBy(linkText="Register") WebElement RegisterLink;
	@FindBy(linkText="Login") WebElement LoginLink;
	
	public void clickMyAccount() {
		MyAccountLink.click();
	}
	
	public void clickRegister() {
		RegisterLink.click();
	}
	
	public void clickLogin() {
		LoginLink.click();
	}

}
