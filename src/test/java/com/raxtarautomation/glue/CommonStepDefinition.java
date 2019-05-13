package com.raxtarautomation.glue;

import java.io.IOException;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.pageclass.DashBoardPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonStepDefinition {
	DashBoardPage dashBoardPage;

	@Before
	public void BeforeScenario() throws IOException {
		BaseClass.initdriver();
//		System.out.println("Before each scenario");
	}

	@After
	public void AfterScenario() throws IOException {
		dashBoardPage = new DashBoardPage(BaseClass.getDriverInstance());
		try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dashBoardPage.logout();
		BaseClass.getDriverInstance().close();
//		System.out.println("After every scenario");
	}

}
