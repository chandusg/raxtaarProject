package com.raxtarautomation.common;

import com.raxtarautomation.common.BaseClass;

public class FileReaderManager extends BaseClass{

	
	public static String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
