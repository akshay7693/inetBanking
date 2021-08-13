package testRunner;

import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseTest {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("username is entered");
		lp.setPwd(password);
		log.info("password is entered");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage adcust = new AddCustomerPage(driver);
		adcust.clickAddCustomer();
		log.info("start filling custumer details .... ");
		adcust.custName("akshay");
		adcust.custGender("Male");
		adcust.custDOB("06", "07", "1993");
		adcust.custAddr("house");
		adcust.custCity("Pune");
		adcust.custState("MH");
		adcust.custPinno(randomNumbers());
		adcust.custTelno(123456789);
		adcust.custEmail(randomEmail());
		adcust.custPwd(randomString());
		adcust.clickSubmit();
		
		Thread.sleep(10000);
		
	
		//driver.getPageSource().contains(baseUrl)
		
		
	}
	
	
	
	
	

}
