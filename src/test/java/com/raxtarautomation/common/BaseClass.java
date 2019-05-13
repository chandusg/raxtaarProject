package com.raxtarautomation.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static Properties prop;
	protected static WebDriver driver;

	private BaseClass() {
	}

	static {
		try {
			prop = new Properties();
			InputStream inputStream = BaseClass.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(inputStream);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static void initdriver() {
		try {
			String browserName = prop.getProperty("browser");

			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", getProperty("chromedriverPath"));
				driver = new ChromeDriver();
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", getProperty("fireFoxdriverPath"));
				driver = new FirefoxDriver();
			}

			driver.get(prop.getProperty("applicationUrl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static WebDriver getDriverInstance() {
		if (null == driver) {
			synchronized (BaseClass.class) {
				if (null == driver)
					initdriver();
			}
		}
		return driver;
	}

	public static void tearDown() {
		driver.close();
	}

	public static String getProperty(String propertyName) {
		return prop.getProperty(propertyName);
	}
}
