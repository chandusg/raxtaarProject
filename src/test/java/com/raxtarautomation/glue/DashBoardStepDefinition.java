package com.raxtarautomation.glue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.DashBoardPage;
import com.raxtarautomation.pageclass.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardStepDefinition {
	LoginPage login;
	DashBoardPage dashBoardPage;
	WebDriver driverInstance;

	public DashBoardStepDefinition() {
		driverInstance = BaseClass.getDriverInstance();
		dashBoardPage = new DashBoardPage(driverInstance);
	}

	@Given("^I am logged in to the application$")
	public void loginToApplication() throws IOException {
		login = new LoginPage(driverInstance);
		login.login(BaseClass.getProperty("userName"), BaseClass.getProperty("password"));

	}

	@Then("^I see the overview page by default$")
	public void verifyOverViewPage() {
		Assert.assertTrue(dashBoardPage.isDashBoardPageDiaplayed(), "The DashBoard is not diaplayed");
	}

	@And("^I see the count of \"(.*?)\"$")
	public void verifyDashBoardScreen(String dashBoardItemName) {
		Assert.assertTrue(dashBoardPage.isAllDashBoardItemsAreDiaplayed(dashBoardItemName),
				"The dashBoard is not diaplayed");
	}

	@When("^I click on hoists menu$")
	public void clickingOnHoistsMenu() {
		dashBoardPage.clickOnHoist();
	}

}
