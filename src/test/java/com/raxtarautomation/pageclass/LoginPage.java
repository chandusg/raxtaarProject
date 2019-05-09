package com.raxtarautomation.pageclass;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raxtarautomation.common.BaseClass;
public class LoginPage extends BaseClass {
	
//WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		BaseClass.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement textBoxuserName;
	
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement textBoxPasswrod;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement buttonLogin;
	
	
	public void login(String userName, String password)
	{
		textBoxuserName.sendKeys(userName);
		textBoxPasswrod.sendKeys(password);
		buttonLogin.click();
	}
	
	
}
