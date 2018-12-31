package com.qa.extentReport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {

	static ExtentReports extent;
	static ExtentTest logger;
	static String fileSeperator = System.getProperty("file.seperator");
	static String userDir = System.getProperty("user.dir");
	
	public static void createInstance() {
		
		extent= new ExtentReports(userDir+"//Reports//ExtentReport.html",true);	
	}
	
	public static void startTest(String testName) {
		
		logger=extent.startTest(testName);
	}
	
	public static void passInfo(String info) {
			
		logger.log(LogStatus.INFO, info);
		
	}
	
	public static void onSuccess(String info) {
		
		logger.log(LogStatus.PASS, info);
	}
	
	public static void onFailure(String info) {
			
		logger.log(LogStatus.FAIL, info);
	}
	
	public static void onSkip(String info) {
		
		logger.log(LogStatus.SKIP, info);
	}
	
	public static void onFinish() {
		
		extent.endTest(logger);
		extent.flush();
		extent.close();
	}



}
