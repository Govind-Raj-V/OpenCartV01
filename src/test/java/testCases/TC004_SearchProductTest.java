package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass  {

	@Test(groups={"master"})
	public void verify_productSearch() throws InterruptedException {
		logger.info("************Starting test TC004_SearchProductTest ************" );
		
		try {
		logger.info("search product in the searchbox field");
		HomePage hp=new HomePage(driver);
		hp.enterProductName("Mac");
		hp.clickSearch();
		
		logger.info("Identifiying the product");
		SearchPage sp =new SearchPage(driver);
		
		sp.selectCategory("Desktops");
		sp.clickSubCategory();
		sp.clickProductDescription();
		sp.clickSearchBtn();
		Assert.assertTrue(sp.isProductVisible("iMac"));
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*************TC004_SearchProductTest test is finished*************");
		
	}
}
