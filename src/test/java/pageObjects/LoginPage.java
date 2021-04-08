package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	@CacheLookup
	WebElement buttonEmail;
	
	@FindBy(id="input-password")
	@CacheLookup
	WebElement buttonPassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	@CacheLookup
	WebElement buttonClick;
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	@CacheLookup
	WebElement displayMsg;
	
	
	public void setEmail(String email) {
		buttonEmail.clear();
		buttonEmail.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		buttonPassword.clear();
		buttonPassword.sendKeys(pass);
	}
	
	public void clickLogin() {
		buttonClick.click();
	}
	
	public boolean elementIsPresent() {
		try
		{
			return(displayMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}
	
	

}
