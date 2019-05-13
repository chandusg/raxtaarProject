package com.raxtarautomation.pageclass;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoistsPage {

	Actions act;
	WebDriverWait wait;

	public HoistsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
	}

	@FindBy(xpath = "//a[contains(text(),'Add hoist')]")
	private WebElement linkaddHoist;

	@FindBy(xpath = "//tr[1]/th[contains(text(),'Number')]/span/i[@class='fa fa-angle-down']")
	private WebElement linksortedNumber;

	@FindBy(xpath = "(//td/span[@class='hoistRowMenuIcon'])[1]")
	private WebElement linkRowMenuIcon;

	@FindBy(xpath = "//div[text()='Edit']")
	private WebElement buttonEdit;

	@FindBy(xpath = "//div[text()='Delete']")
	private WebElement buttonDelete;

	@FindBy(xpath = "//div[@class='modal-header']/h4[contains(text(),'Edit Hoist')]")
	private WebElement buttonEditHoistInPopUP;

	@FindBy(xpath = "//input[@name='hoistNumber']")
	private WebElement textBoxHoistNumber;

	@FindBy(xpath = "//input[@id='ex0_value']")
	private WebElement dropDownType;

	@FindBy(xpath = "//input[@id='ex1_value']")
	private WebElement dropDownCompany;

	@FindBy(xpath = "//input[@id='ex2_value']")
	private WebElement dropDownLocation;

	@FindBy(xpath = "//input[@name='description']")
	private WebElement textBoxDescription;

	@FindBy(xpath = "//input[@id='ex3_value']")
	private WebElement dropDownController;

	@FindBy(xpath = "//div/textarea[@name='note']")
	private WebElement textBoxnote;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//div/strong")
	private WebElement sucessMessage;

	@FindBy(xpath = "//button[contains(text(),'Close')]")
	private WebElement buttonCloseInThePopUp;
	
	@FindBy(xpath="//div[contains(text(),'Go To Hoist Dashboard')]")
	private WebElement buttonbackToHositDashBoard;
	
	@FindBy(xpath="//a[contains(text(),'Info')]")
	private WebElement linkInfo;
	
	@FindBy(xpath="//a[contains(text(),'Position')]")
	private WebElement linkPosition;
	
	@FindBy(xpath="//a[contains(text(),'Status')]")
	private WebElement linkStatus;

	public boolean isHositPageDisplayed() {

		return linkaddHoist.isDisplayed();
	}

	public boolean isSortedWithNumberColumn() {

		return linksortedNumber.isDisplayed();
	}

	public void clickOnEditOrDeleteButtonInHositMenu(String buttonName) {
		linkRowMenuIcon.click();

		if (buttonName.equalsIgnoreCase("Edit")) {
			buttonEdit.click();
		} else if (buttonName.equalsIgnoreCase("Delete")) {
			buttonDelete.click();
		}

	}

	public boolean isPopUpScreenDisplayed() {

		return buttonEditHoistInPopUP.isDisplayed();
	}

	public void fillHoistDetailsforHoistAndSubmit(Map<String, String> data) throws InterruptedException {

		textBoxHoistNumber.clear();
		textBoxHoistNumber.sendKeys(data.get("Number"));
		act.sendKeys(Keys.TAB);
		dropDownType.clear();

		dropDownType.sendKeys(data.get("Type"));
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.TAB);

		dropDownCompany.clear();
		dropDownCompany.sendKeys(data.get("Company"));
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.TAB);
		
		 dropDownLocation.clear(); 
		 dropDownLocation.sendKeys(data.get("Location"));
		 Thread.sleep(2000);
		 act.sendKeys(Keys.ARROW_DOWN); act.sendKeys(Keys.TAB);
		 act.sendKeys(Keys.TAB);
		 

		textBoxDescription.clear();
		textBoxDescription.sendKeys(data.get("Description"));
		act.sendKeys(Keys.TAB);

		dropDownController.clear();
		dropDownController.sendKeys(data.get("Controller"));
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN);
		act.sendKeys(Keys.TAB);
		textBoxnote.clear();
		textBoxnote.sendKeys(data.get("Note"));
		act.sendKeys(Keys.TAB);
		buttonSubmit.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonCloseInThePopUp));

	}

	public boolean isHoistDetailsSubmitted(String message) {

		String sucessMsg = sucessMessage.getText();

		if (sucessMsg.contains(message)) {
			return true;
		} else {
			return true;
		}

	}

	public void closeButtonInPopUp() throws InterruptedException {
		Thread.sleep(10000);
		buttonCloseInThePopUp.click();

	}
	



	public void clickOnHositDashBoard() {
		linkRowMenuIcon.click();
		buttonbackToHositDashBoard.click();
		
	}




	public boolean isHoistDashBoardDiaplayed() {
		
		return linkInfo.isDisplayed()&&  linkPosition.isDisplayed();
	}




	public void clickOnAddHoistButton() throws InterruptedException {
		Thread.sleep(3000);
		linkaddHoist.click();
		
	}
}
