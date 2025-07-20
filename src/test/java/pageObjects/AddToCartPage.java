package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage extends BasePage {
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Estimate Shipping & Taxes']") WebElement linkAddress;
	@FindBy(id="input-country") WebElement selectCountry;
	@FindBy(name="zone_id") WebElement selectState;
	@FindBy(name="postcode") WebElement txtPostCode;
	@FindBy(id="button-quote") WebElement btnquote;
	@FindBy(name="shipping_method") WebElement rdo_Btn_01;
	@FindBy(id="button-shipping") WebElement btnApplyShipping;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement confMsg;
	@FindBy(xpath="//strong[normalize-space()='Sub-Total:']/following::td[1]") WebElement subTotalTd;
	@FindBy(xpath="//strong[normalize-space()='Flat Shipping Rate:']/following::td[1]") WebElement flatShippingRateTd;
	@FindBy(xpath="//strong[normalize-space()='Total:']/following::td[1]")WebElement totalTd;
	//@FindBy(xpath="//a[@class='btn btn-primary']") WebElement checkoutBtn;
	@FindBy(linkText="Checkout") WebElement checkoutBtn;
	
	public void clickEstimateShipping() {
		linkAddress.click();
	}
	
	public void chooseCountry(String country) {
		Select sltCountry=new Select(selectCountry);
		sltCountry.selectByVisibleText(country);
	}
	
	public void chooseState(String state) {
		Select sltState=new Select(selectState);
		sltState.selectByVisibleText(state);
	}
	
	public void setPostcode(String postcode) {
		txtPostCode.sendKeys(postcode);
	}
	
	public void clickQuoteBtn() {
		btnquote.click();
	}
	
	public void clickShippingRate() {
		rdo_Btn_01.click();
	}
	
	public void clickApplyShipping() {
		btnApplyShipping.click();
	}
	
	public boolean checkConfMsg() {
		
		String str1=confMsg.getText().replaceAll("×|\\n", "").trim();
		String str2="Success: Your shipping estimate has been applied!";
		
		if(str1.equalsIgnoreCase(str2)) {
			return true;
		}
		
		return false;
	}
	
	public double subTotalData() {
		String pricetext=subTotalTd.getText();
		double subTotal=Double.parseDouble(pricetext.replaceAll("[^\\d.]", ""));
		return subTotal;
	}
	
	public double FlatShippingRateData() {
		String pricetext=flatShippingRateTd.getText();
		double flatShippingRate=Double.parseDouble(pricetext.replaceAll("[^\\d.]", ""));
		return flatShippingRate;
	}
	
	public double productTotal() {
		String pricetext=totalTd.getText();
		double total=Double.parseDouble(pricetext.replaceAll("[^\\d.]",""));
		return total;
	}
	
	public void clickCheckout() {
		checkoutBtn.click();
	}
}
