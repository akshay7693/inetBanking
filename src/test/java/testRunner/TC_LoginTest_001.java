package testRunner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseTest {

	
	@Test
	public void loginTest() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Entered Username");
		
		lp.setPwd(password);
		log.info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Home")) {
			
			Assert.assertTrue(true);
			log.info("Login test passed");
		}
		else {			
			captureScreenshots(driver,"loginTest");
			Assert.assertTrue(false);
			log.info("Login test failed");
		}
		
		
		
	}
	
	
	
}
