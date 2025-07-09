package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass  {

	@Test(groups={"master"})
	public void verify_productSearch() throws InterruptedException {
		logger.info("************Starting test TC004_SearchProductTest ************" );
		
		logger.info("Login into the account");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(pro.getProperty("Email"));
		lp.setPassword("pswd");
		
		logger.info("search product in the searchbox field");
		SearchPage sp =new SearchPage(driver);
		hp.enterProductName("Mac");
		hp.clickSearch();
		sp.selectCategory("Desktops");
		sp.clickSubCategory();
		sp.clickSearchBtn();
		sp.selectProduct();
		
		logger.info("*************TC004_SearchProductTest test is finished*************");
		
	}
}
