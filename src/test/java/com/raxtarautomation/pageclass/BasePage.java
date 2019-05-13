package com.raxtarautomation.pageclass;

import com.raxtarautomation.common.BaseClass;

public class BasePage {
	
	public LoginPage getLoginPage()
	{
		return new LoginPage(BaseClass.getDriverInstance());
	}
	
	public HoistsPage getHoistPage()
	{
		return new HoistsPage(BaseClass.getDriverInstance());
	}
	
	public DashBoardPage getDashBoardPage()
	{
		return new DashBoardPage(BaseClass.getDriverInstance());
	}

	
}
