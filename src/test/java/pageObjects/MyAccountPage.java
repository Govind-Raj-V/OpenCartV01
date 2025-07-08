package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement myAccountLink;
	@FindBy(linkText="Order History") WebElement OrdHistoryLink;
	@FindBy(linkText="Order Transactions") WebElement TranscationLink;
	@FindBy(linkText="Order Downloads") WebElement DownloadLink;
	@FindBy(linkText="Logout") WebElement LogoutLink;
	
	public void clickLogout() {
		LogoutLink.click();
	}

}
