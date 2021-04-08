package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginFunctionality extends BaseClass{
	

	@Test(groups= {"regression","master"})
	public void loginFunctionality() {
	logger.info("started TC_002_LoginFunctionality");
	
	driver.get(rp.getString("appURL"));
	driver.manage().window().maximize();
	
	HomePage hp = new HomePage(driver);
	hp.clickOnMyAccount();
	hp.clickOnLogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail("jaydip.sheladiya1994@gmail.com");
	lp.setPassword("Kaushal53183");
	lp.clickLogin();
	
	boolean status = lp.elementIsPresent();
	
	if(status==true)
	{
		Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
	}
	}

}
