package com.raxtarautomation.glue;

import java.util.Map;

import org.testng.Assert;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.HoistsPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HoistsStepDefinition extends BaseClass {
	
	HoistsPage hoistsPage=new HoistsPage(BaseClass.getDriverInstance());
	
	
	
	@Then("^I see the hoist overview screen$") 
	public void verifyHoistOverViewScreen()
	{

		 Assert.assertTrue(hoistsPage.isHositPageDisplayed(),
				 "The Hoists page is not diaplayed");
	}

	
	@And("^I see the records sorted with Number column$")
	public void verifySortedNumberColumn()
	{

		 Assert.assertTrue(hoistsPage.isSortedWithNumberColumn(),
				 "The column number is not sorted");
	}
	
	@And("^for first record I click on \"(.*?)\" button$")
	public void clickOnEditOrDeleteButton(String buttonName)
	{
		hoistsPage.clickOnEditOrDeleteButtonInHositMenu(buttonName);
	}
	
	@Then("^I see the Edit Hoist popup screen open$") 
	public void verifyPopUpScreen()
	{
		Assert.assertTrue(hoistsPage.isPopUpScreenDisplayed(),
				 "The pop up screen is not displayed");
	}
	
	@And("^Fill the below details and click on Submit Button$")
	public void fillHoistDetails(DataTable testData) throws InterruptedException
	{
		Map<String, String>data=testData.asMap(String.class, String.class);
		hoistsPage.fillHoistDetailsforHoistAndSubmit(data);
	}
	
	@Then("^the pop up should be diaplyed with Sucessfully Submitted message$") 
	public void verifyHoistEditDetailsSubmission()
	{
		Assert.assertTrue(hoistsPage.isHoistDetailsSubmitted("Success!"), "Hoist details are not submitted");
	}
	
	
	@When("^the close button is clicked in the pop up$")
	
		public void closePopUp() throws InterruptedException
		{
		hoistsPage.closeButtonInPopUp();
		}
	
	
	@Then("^I see the Delete Hoist popup screen open$")
	public void verifyDeletePopUp()
	{
		Assert.assertTrue(hoistsPage.isDeletePopUpDisplayed(), "Delete pop up is not displayed");
	}
	
	
	@When("I click on the \"(.*?)\" button the pop up")
	public void acceptDelete(String buttonName)
	{
		hoistsPage.closeDeletePopUp(buttonName);
	}
	
	@Then("^the hositDetails will be deleted$")
	public void verifyHositDetailsDeleted()
	{
		Assert.assertTrue(hoistsPage.isHoistDetailsDeleted(), "Hosit Details are not deleted");
	}
	
	@Then("^the hositDetails should not be deleted$") 
	public void VerifyHoistDetails()
	{
		Assert.assertTrue(hoistsPage.isHoistDetailsNotDeleted(), "Hosit Details are  deleted");
	}
	
	}

