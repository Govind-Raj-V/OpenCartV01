package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginPageTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verifyLoginPage() {
		
		logger.info("************* Starting test TC002_LoginPageTest *************");
		HomePage home=new HomePage(driver);
		
		logger.info("Click on MyAccount link");
		home.clickMyAccount();
		
		logger.info("Click on Login link");
		home.clickLogin();
		
		logger.info("Providing valid login data");
		LoginPage login=new LoginPage(driver);
		login.setEmail("jfw123@gmail.com");
		login.setPassword("jfw123");
		login.clickLogin();
		
		MyAccountPage myAcc=new MyAccountPage(driver);
		myAcc.clickLogout();
		
		logger.info("************* TC002_LoginPageTest test is passed *************");
	}

}
