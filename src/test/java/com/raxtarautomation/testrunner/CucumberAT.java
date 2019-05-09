package com.raxtarautomation.testrunner;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.raxtarautomation.common.BaseClass;
import com.raxtarautomation.common.FileReaderManager;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
				monochrome = true, 
				features = {"src/test/resources/features"},
				glue = {"com.raxtarautomation.glue"},
				tags= {"@login-feature"})


public class CucumberAT {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getReportConfigPath()));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.5.2");
	     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	     Reporter.setSystemInfo("Execution Browser", BaseClass.prop.getProperty("browser"));
	     Reporter.setSystemInfo("Execution Enivronment", BaseClass.prop.getProperty("environment"));
	     
	}
}
