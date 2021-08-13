package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);		
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='password']")
	
	WebElement txtPwd;
	
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//input[@name='btnReset']")
	@CacheLookup
	WebElement btnReset;

	
	public void setUserName(String uName) {
		
		txtUserName.sendKeys(uName);
				
	}
	
	public void setPwd(String pwd) {
	
		txtPwd.sendKeys(pwd);
		
	}
	
	public HomePage clickSubmit() {
		
		btnLogin.click();
		return new HomePage(ldriver) ;
	}
	
	public void clickRest() {
		
		btnReset.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
