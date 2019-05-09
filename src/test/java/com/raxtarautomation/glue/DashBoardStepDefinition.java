package com.raxtarautomation.glue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.DashBoardPage;
import com.raxtarautomation.pageclass.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardStepDefinition extends BaseClass {

	LoginPage login;
	DashBoardPage dashBoardPage;

	

	 @Given("^I am logged in to the application$")
	 public void loginToApplication() throws IOException
	 {
	 BaseClass.initdriver();
	 login = new LoginPage(driver);
	 login.login(prop.getProperty("userName"), prop.getProperty("password"));
	
	 }
	
	 @Then("^I see the overview page by default$")
	 public void verifyOverViewPage()
	 {
	 dashBoardPage= new DashBoardPage(driver);
	 Assert.assertTrue(dashBoardPage.isDashBoardPageDiaplayed(), "The DashBoard is not diaplayed");
	 }
	
	 @And("^I see the count of \"(.*?)\"$")
	 public void verifyDashBoardScreen(String dashBoardItemName)
	 {
	 dashBoardPage= new DashBoardPage(driver);
	 Assert.assertTrue(dashBoardPage.isAllDashBoardItemsAreDiaplayed(dashBoardItemName),
	 "The dashBoard is not diaplayed");
	 }

	 
	 @When("^I click on hoists menu$")
	 public void clickingOnHoistsMenu()
	 {
		 dashBoardPage= new DashBoardPage(driver);
		 dashBoardPage.clickOnHoist();
	 }
	 
	 
}
