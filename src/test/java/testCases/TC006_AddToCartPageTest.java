package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC006_AddToCartPageTest extends BaseClass{

	@Test(groups= {"master"})
	public void verifyAddToCartPage() throws InterruptedException {
		
		logger.info("**********TC006_AddToCartPageTest is started**********");
		try {
		String prod=pro.getProperty("product");
		
		HomePage hp=new HomePage(driver);
		hp.enterProductName(prod);
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		if(sp.isProductVisible(prod)) {
			sp.selectProduct(prod);
			sp.clickAddToCartBtn();
		}
		
		if(sp.checkConfMsg(prod)) {
			sp.clickCartBtn();
			sp.clickViewCart();
		}
		
		
		AddToCartPage cart=new AddToCartPage(driver);
		cart.clickEstimateShipping();
		cart.chooseCountry("India");
		cart.chooseState("Tamil Nadu");
		cart.setPostcode("600042");
		cart.clickQuoteBtn();
		cart.clickShippingRate();
		cart.clickApplyShipping();
		
		Thread.sleep(2000);
		
		if(cart.checkConfMsg()==true) {
			
			logger.info("Validating the actual price with the expected price");
			
			double productTotal=cart.subTotalData()+cart.FlatShippingRateData();

			if(cart.productTotal()==productTotal) {
				System.out.println("The product total is :"+cart.productTotal());
				//cart.clickCheckout();
			}
			else {
				Assert.assertTrue(false);
			}
		}
			Assert.assertEquals(cart.checkConfMsg(), true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*********TC006_AddToCartPageTest is finished*************");
	}
}
