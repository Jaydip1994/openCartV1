package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="input-lastname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(id="input-email")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(id="input-telephone")
	@CacheLookup
	WebElement telephone;
	
	@FindBy(id="input-password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="input-confirm")
	@CacheLookup
	WebElement passwordConfirm;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	@CacheLookup
	WebElement privacyPolicy;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	@CacheLookup
	WebElement buttonContinue;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	@CacheLookup
	WebElement confirmation;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		emailId.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		telephone.sendKeys(tel);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void setConfirmPassword(String confirm) {
		passwordConfirm.sendKeys(confirm);
	}
	
	public void setPrivacyPolicy() {
		privacyPolicy.click();
	}
	
	public void clickContinue() {
		buttonContinue.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
	
	public String getConfirmationmsg() {
		try
		{
			return(confirmation.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}

}
