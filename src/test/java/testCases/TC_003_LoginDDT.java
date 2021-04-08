package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.XLUtilities;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void test_loginDDT(String email, String pass, String exp) {
		
		logger.info("started TC_003_LoginDDT");
		
		driver.get(rp.getString("appURL"));
		
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		hp.clickOnMyAccount();
		hp.clickOnLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.clickLogin();
		
		boolean targetPage = lp.elementIsPresent();
		
		if(exp.equals("Valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				AccountRegistrationPage ap = new AccountRegistrationPage(driver);
				ap.clickLogout();
			}
		
		else
		{
			Assert.assertTrue(false);
		}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetPage == true)
			{
				Assert.assertTrue(false);
				AccountRegistrationPage ap = new AccountRegistrationPage(driver);
				ap.clickLogout();
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
		
	}
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		
		XLUtilities xlutils = new XLUtilities(path);
		
		int totalrows = xlutils.getRowCount("Sheet1");
		int totalcolumns = xlutils.getCellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalrows][totalcolumns];
		
		for(int i=1; i<=totalrows; i++)
		{
			for(int j=0; j<totalcolumns; j++)
			{
				loginData[i-1][j] = xlutils.getCellData("Sheet1", i, j);
			}
		}
		
		return(loginData);
	}

}
