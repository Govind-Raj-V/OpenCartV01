package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTest extends BaseClass {
	
	@Test(dataProvider= "LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verifyLoginDD(String Email,String pwd, String exRslt) {
		
		logger.info("************* Starting test TC003_LoginDDTest *************");
		 try {
		HomePage home=new HomePage(driver);
		
		logger.info("Click on MyAccount link");
		home.clickMyAccount();
		
		logger.info("Click on Login link");
		home.clickLogin();
		
		logger.info("Providing login data");
		LoginPage login=new LoginPage(driver);
		login.setEmail(Email);
		login.setPassword(pwd);
		login.clickLogin();
		Thread.sleep(5000);
		
		MyAccountPage myAcc=new MyAccountPage(driver);
		String PageTitle=checkTitle();

		if (exRslt.equalsIgnoreCase("Valid")) {

			logger.info("Login with valid data");
			
			if (PageTitle.equalsIgnoreCase("My Account")) {
				
				logger.info("login with valid data is Successful");
				myAcc.clickLogout();
				Assert.assertTrue(true);
			} else {
				logger.info("login with valid data is Unsuccessful");
				Assert.assertTrue(false);
			}
		}
		if (exRslt.equalsIgnoreCase("Invalid")) {
			
			logger.info("Passing Invalid data");
			
			if(PageTitle.equalsIgnoreCase("MY Account")) {
				
				logger.info("Logged in with invalid data is successful");
				myAcc.clickLogout();
				Assert.assertFalse(true);
			}
			else {
				logger.info("Logged in with invalid data is Unsuccessful");
				Assert.assertFalse(false);
			}
		}
		 }catch(Exception e) {
			 Assert.fail();
		 }	
		logger.info("**************TC003_LoginDDTest test Finished**************** ");
	}
}
