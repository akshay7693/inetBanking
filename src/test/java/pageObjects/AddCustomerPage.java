package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends HomePage {

	
	static WebDriver ldriver;
	
	
	public AddCustomerPage(WebDriver rdriver) {
		super(ldriver);
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(how = How.XPATH , using="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.XPATH , using="//input[contains(@name,'name')]")
	@CacheLookup
	WebElement txtcustName;
	
	@FindBy(how = How.XPATH , using="//input[@name='rad1' and @value = 'm']")
	@CacheLookup
	WebElement rdMGender;
	
	@FindBy(how = How.ID , using="//input[@name='rad1' and @value = 'f']")
	@CacheLookup
	WebElement rdFGender;
	
	@FindBy(how = How.ID , using="dob")
	@CacheLookup
	WebElement txtDOB;
	
	@FindBy(how = How.XPATH , using ="//textarea[@name='addr']")
	@CacheLookup
	WebElement txtAddr;
	
	@FindBy(how = How.NAME , using ="city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME , using ="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME , using ="pinno")
	@CacheLookup
	WebElement txtPinno;
	
	@FindBy(how = How.NAME , using ="telephoneno")
	@CacheLookup
	WebElement txtTelno;
	
	@FindBy(how = How.NAME , using ="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME , using ="password")
	@CacheLookup
	WebElement txtPwd;
	
	@FindBy(how = How.XPATH , using ="//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.XPATH , using ="//input[@name='res']")
	@CacheLookup
	WebElement btnReset;
	
	public void custName(String custname) {
		txtcustName.sendKeys(custname);
	}
	
	public void custGender(String gender) {
		if(gender.equals("Male")) {
			rdMGender.click();
		}else {
			rdFGender.click();
		}
	}
	
	public void custDOB(String mm , String dd , String yy) {
		txtDOB.sendKeys(mm);
		txtDOB.sendKeys(dd);
		txtDOB.sendKeys(yy);
	}
	
	public void custAddr(String addr) {
		txtAddr.sendKeys(addr);
	}
	
	public void custCity(String city) {
		txtCity.sendKeys(city);
	}
	
	public void custState(String state) {
		txtState.sendKeys(state);
	}
	
	public void custPinno(String pinno) {
		txtPinno.sendKeys(String.valueOf(pinno));
	}
		
	public void custTelno(int telno) {
		txtTelno.sendKeys(String.valueOf(telno));
	}
	
	public void custEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void custPwd(String pwd) {
		txtPwd.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void clickReset() {
		btnReset.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
