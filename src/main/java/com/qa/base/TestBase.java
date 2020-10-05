package com.qa.base;



import java.io.FileInputStream;
	
	import java.util.Properties;
	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

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
	}
			
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			
		}
		
		public void TearDown()
		{
			driver.quit();
		}

	}



