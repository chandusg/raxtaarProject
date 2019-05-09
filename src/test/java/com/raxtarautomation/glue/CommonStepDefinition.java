package com.raxtarautomation.glue;

import java.io.IOException;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.DashBoardPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefinition extends BaseClass{
	
	
	DashBoardPage dashBoardPage;
	@Before
	public void BeforeScenario() throws IOException
	{
		
//		System.out.println("Before each scenario");
//		BaseClass.initdriver();
	}
	
	
	@After
	public void AfterScenario() throws IOException
	{
		dashBoardPage=new DashBoardPage(BaseClass.getDriverInstance());;
		dashBoardPage.logout();

	}

}
