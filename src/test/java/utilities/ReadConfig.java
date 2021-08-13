package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig()  {
		
		File src = new File("./Configuration/config.properties");
		
		try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);		
		} catch(FileNotFoundException e){
			System.out.println("Exception is : " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd = prop.getProperty("password");
		return pwd;
	}
	
	public String getChromePath() {
		String chromePath = prop.getProperty("chromepath");
		return chromePath;		
	}
	
	public String getFirefoxPath() {
		String ffPath = prop.getProperty("firefoxpath");
		return ffPath;		
	}

}
