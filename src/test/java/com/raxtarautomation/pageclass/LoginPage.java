package com.raxtarautomation.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement textBoxuserName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement textBoxPasswrod;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	private WebElement buttonLogin;

	public void login(String userName, String password) {
		textBoxuserName.sendKeys(userName);
		textBoxPasswrod.sendKeys(password);
		buttonLogin.click();
	}

}
