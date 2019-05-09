package com.raxtarautomation.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.After;

public class BaseClass {
	public static Properties prop;
	protected static WebDriver driver;
	
	
	public BaseClass() {
		FileInputStream file = null;
		try {
			prop = new Properties();
			/*file = new FileInputStream(
					"classpath:config.properties"); */
			
			InputStream inputStream = BaseClass.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
			
			
			//prop.load(file);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
	public static void initdriver() throws IOException
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverPath"));
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("fireFoxdriverPath"));
			driver= new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("applicationUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public static WebDriver getDriverInstance()
	{
		return driver;
	}
	
	
	
	public static void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	

}
