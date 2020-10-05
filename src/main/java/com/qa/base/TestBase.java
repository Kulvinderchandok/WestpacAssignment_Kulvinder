package com.qa.base;



import java.io.FileInputStream;
	
	import java.util.Properties;
	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Code to pick up browser details for the config file and initiate the browser driver and then launch the URL defined in the config file.
 * Browser and URL paramaters picked up from the config.properties file
 */

public class TestBase {

		
		public WebDriver driver;
		public Properties prop;
		
		public TestBase() {
			
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(
						"C:\\Users\\kc\\eclipse-workspace\\WestpacRetirementCalc\\src\\main\\java\\com\\qa\\config\\config.properties");
				prop.load(ip);
				initialization();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
				
				
		
		public  void initialization()
		{
			String browserName = prop.getProperty("browser");
			
			if (browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\kc\\\\Desktop\\\\driver\\\\chromedriver.exe");


				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(prop.getProperty("url"));
			}

			if (browserName.equals("firefox"))
			{
				System.setProperty("webdriver.firefox.driver", "C:\\\\Users\\\\kc\\\\Desktop\\\\driver\\\\firefoxdriver.exe");


				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.get(prop.getProperty("url"));
			}
		}
		
		public void TearDown()
		{
			driver.quit();
		}

	}



