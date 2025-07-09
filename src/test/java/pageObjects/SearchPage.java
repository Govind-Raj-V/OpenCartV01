package pageObjects;

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
	@FindBy(linkText="iMac") WebElement product;
	
	public void selectCategory(String filterProd) {
		Select dd=new Select(selectCategory);
		dd.selectByVisibleText(filterProd);
	}
	
	public void clickSubCategory() {
		checkboxBtnsubCategory.click();
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	public void selectProduct() {
		product.click();
	}
}
