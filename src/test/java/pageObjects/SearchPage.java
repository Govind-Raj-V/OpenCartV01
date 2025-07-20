package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="button-search") WebElement searchBtn;
	@FindBy(name="category_id") WebElement selectCategory;
	@FindBy(name="sub_category") WebElement checkboxBtnsubCategory;
	@FindBy(id="description") WebElement checkBoxProductDescription;
	@FindBy(xpath="//div[@id='content']/child::div[3]//h4/a") List<WebElement> products;
	@FindBy(id="input-quantity") WebElement inputQuantity;
	@FindBy(id="button-cart") WebElement btnAddToCart;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement confMsg;
	@FindBy(xpath="//div[@id=\"cart\"]/button") WebElement cartBtn;
	@FindBy(xpath="//strong[normalize-space()='View Cart']") WebElement viewCartLink;
	
	public void selectCategory(String filterProd) {
		Select dd=new Select(selectCategory);
		dd.selectByVisibleText(filterProd);
	}
	
	public void clickSubCategory() {
		checkboxBtnsubCategory.click();
	}
	
	public void clickProductDescription() {
		checkBoxProductDescription.click();
	}
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public boolean isProductVisible(String searchProductName) {
		for(WebElement product: products) {
			String productName=product.getText();
			
			if(productName.equalsIgnoreCase(searchProductName)) {
				return true;
			}
		}
		return false;
	}
	public void selectProduct(String selectProductName) {
		for(WebElement product:products) {
			String productName=product.getText();
			try {
			if(productName.equalsIgnoreCase(selectProductName)) {
				product.click();
			}
			}
			catch(Exception e) {
				System.out.println("There is no such product in this name");
			}
		}
	}
	
	public void setQuantity(String Qty) {
		inputQuantity.sendKeys(Qty);
	}
	
	public void clickAddToCartBtn() {
		btnAddToCart.click();
	}
	
	public boolean checkConfMsg(String product) {
		String s1=confMsg.getText().replaceAll("×|\\n", "");
		String s2="Success: You have added "+product+" to your shopping cart!";
		
		if(s1.equalsIgnoreCase(s2)) {
			return true;
		}
		
		return false;
	}
	public void clickCartBtn() {
		cartBtn.click();
	}
	
	public void clickViewCart() {
		viewCartLink.click();
	}
}
