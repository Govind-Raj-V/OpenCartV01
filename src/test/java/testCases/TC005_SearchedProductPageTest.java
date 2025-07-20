package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_SearchedProductPageTest extends BaseClass {

	@Test(groups= {"master"})
	public void verifyAddToCart() {
		
		logger.info("********** Starting test TC005_SearchedProductPageTest **********");
		try {
			
		System.out.println("Enter the product that you want to search :");
		String product=sc.next();
		
		HomePage hp=new HomePage(driver);
		hp.enterProductName(product);
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		if(sp.isProductVisible(product)) {
			sp.selectProduct(product);
			sp.setQuantity("2");
			sp.clickAddToCartBtn();
		}
		
		Assert.assertEquals(sp.checkConfMsg(product), true);
		
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC005_SearchedProductPageTest");
	}
}
