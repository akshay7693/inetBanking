package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {
	
	WebDriver ldriver;
	
	public HomePage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement lnklogOut;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddCust;
	
	
	
	public LoginPage clickLogOut() {
		lnklogOut.click();
		return new LoginPage(ldriver);
	}
	
	public AddCustomerPage clickAddCustomer() {
		lnkAddCust.click();
		return new AddCustomerPage(ldriver);
	}

}
