package com.raxtarautomation.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.raxtarautomation.common.BaseClass;

public class DashBoardPage {

	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Overview')]")
	private WebElement linkOverview;

	@FindBy(xpath = "//a[@class='sidebar-toggle']")
	private WebElement toggleBar;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Hoists']")
	private WebElement hoisetCount;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Users']")
	private WebElement userCount;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Controllers']")
	private WebElement countrolerCount;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Companies']")
	private WebElement companiesCount;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Locations']")
	private WebElement locationCount;

	@FindBy(xpath = "//div[@class='info-box-content']/span[text()='Reports']")
	private WebElement reportCount;

	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	private WebElement logoutButton;

	public boolean isDashBoardPageDiaplayed() {
		return (linkOverview.isDisplayed() && toggleBar.isDisplayed());
	}

	public boolean isAllDashBoardItemsAreDiaplayed(String dashBoardItemName) {
		if (dashBoardItemName.equalsIgnoreCase("hoists")) {
			return hoisetCount.isDisplayed();
		}

		else if (dashBoardItemName.equalsIgnoreCase("users")) {
			return userCount.isDisplayed();
		}

		else if (dashBoardItemName.equalsIgnoreCase("Controllers")) {
			return countrolerCount.isDisplayed();

		}

		else if (dashBoardItemName.equalsIgnoreCase("Companies")) {
			return companiesCount.isDisplayed();
		}

		else if (dashBoardItemName.equalsIgnoreCase("Locations")) {
			return locationCount.isDisplayed();
		} else if (dashBoardItemName.equalsIgnoreCase("Reports")) {
			return reportCount.isDisplayed();
		} else
			return false;

	}

	public void clickOnHoist() {
		hoisetCount.click();
	}

	public void logout() {
		if (logoutButton.isEnabled()) {
			logoutButton.click();
		}

	}

}
