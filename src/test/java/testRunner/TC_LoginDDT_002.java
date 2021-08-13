package testRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseTest {
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname , String pwd) throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		
		lp.setUserName(uname);
		log.info("username provided");
		lp.setPwd(pwd);
		log.info("password provided");
		lp.clickSubmit();	
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			captureScreenshots(driver,"loginDDT");
			log.warn("Login Failed");
			Assert.assertTrue(false);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();			
		}
		else
		{
			Assert.assertTrue(true);
			hp.clickLogOut();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Login Passed");
		}
		
		
	}
	
	


}
