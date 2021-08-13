package testRunner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;
import utilities.XLUtils;


public class BaseTest {
	
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();	
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver" , readConfig.getChromePath());
			driver = new ChromeDriver();
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver" , readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}else {
			System.out.println("Only chrome and firefox browser is allowed");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		log.info("URL is opened");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

	public void captureScreenshots(WebDriver driver , String tname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String filePath = System.getProperty("user.dir")+"//src//test//java//testData//TestData.xlsx";
		
		int rowCount = XLUtils.getRowCount(filePath, "Sheet1");
		int colCount = XLUtils.getCellCount(filePath, "Sheet1", 1);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i =1 ; i <= rowCount ; i++) {
			for(int j=0 ; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}
	
	public static String randomEmail() {
		
		String email = RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		return email;
	}
	
	public static String randomString() {
		
		String random = RandomStringUtils.randomAlphanumeric(5);
		return random;
	}
	
	public static String randomNumbers() {
		
		String number = RandomStringUtils.randomNumeric(6);
		return number;
		
	}
	
	
	
	
	
	
}
