package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	@CacheLookup
	WebElement myAccount;
	
	@FindBy (linkText="Register")
	@CacheLookup
	WebElement resister;
	
	@FindBy (xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	@CacheLookup
	WebElement login;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public void clickOnResister() {
		resister.click();
	}
	
	public void clickOnLogin() {
		login.click();
	}

}
