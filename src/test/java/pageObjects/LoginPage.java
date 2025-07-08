package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="email") WebElement txtEmailID;
	@FindBy(name="password") WebElement txtPwd;
	@FindBy(linkText="Forgotten Password") WebElement ForgotPwd;
	@FindBy(xpath="//input[@value='Login']") WebElement LoginBtn;
	
	public void setEmail(String Email) {
		txtEmailID.sendKeys(Email);
	}
	
	public void setPassword(String Pwd) {
		txtPwd.sendKeys(Pwd);
	}
	
	public void clickForgetPwd() {
		ForgotPwd.click();
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}

}
