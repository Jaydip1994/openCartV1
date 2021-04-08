package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass{
	
	
	
	@Test(groups= {"sanity","master"})
	public void test_account_registration() {
		
		logger.info("started TC_001_AccountRegistration");
		
		try
		{
		
		driver.get(rp.getString("appURL"));
		
		driver.manage().window().maximize();
		
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnResister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName("Jaydip");
		regPage.setLastName("Sheladiya");
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone("123456789");
		regPage.setPassword("abcxyz");
		regPage.setConfirmPassword("abcxyz");
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		String confmsg = regPage.getConfirmationmsg();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"TC_001_AccountRegistration");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.info("account registration failed");
		}
		
		logger.info("finished TC_001_AccountRegistration");
	}
	
	
}
