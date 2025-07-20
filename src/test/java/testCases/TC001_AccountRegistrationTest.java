package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	public void verifyAccountRegistration() {
		
		logger.info("************* Starting test TC001_AccountRegistrationTest *************");
		try
		{
		HomePage home=new HomePage(driver);
		
		logger.info("Click on MyAccount link");
		home.clickMyAccount();
		
		logger.info("Click on Register link");
		home.clickRegister();
		
		AccountRegisterPage actRegister=new AccountRegisterPage(driver);
		
		logger.info("Providing customer details randomely");
		actRegister.setFirstName(randomString()); //randomString()
		actRegister.setLastName(randomString()); //randomString()
		actRegister.setEmail(randomAlphaNumeric()+"@gmail.com"); //randomAlphaNumeric()+"@gmail.com"
		actRegister.settelephoneNo(randomNumber());
		
		String pwd=randomString();
		
		actRegister.setpassword(pwd);
		actRegister.setConfirmPwd(pwd);
		actRegister.clickYes();
		actRegister.clickAgree();
		actRegister.clickContinue();
		
		logger.info("Validating expected msg");
		if(actRegister.checkConfirmationMsg().equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			actRegister.clickConformBtn();
		}
		else{
			logger.error("Test Failed");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
			Assert.fail();
			e.getMessage();
		}
		
		logger.info("***************Test passed**************");
	}

}
