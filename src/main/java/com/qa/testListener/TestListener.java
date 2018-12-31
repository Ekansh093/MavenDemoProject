package com.qa.testListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.extentReport.ExtentReport;

public class TestListener implements ITestListener{

	public void onFinish(ITestContext context) {
		
		System.out.println("*** Test Suite "+ context.getName() +" Ending ***");
		ExtentReport.onFinish();
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("*** Test Suite "+ context.getName() +" Started ***");
		ExtentReport.createInstance();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
		ExtentReport.onFailure("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("*** Test Execution "+ result.getMethod().getMethodName() + " Failed ***");
		ExtentReport.onFailure("*** Test Execution "+ result.getMethod().getMethodName() + " Failed ***");
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("*** Test Method "+ result.getMethod().getMethodName() + " Skipped ***");
		ExtentReport.onSkip("*** Test Method "+ result.getMethod().getMethodName() + " Skipped ***");
	}

	public void onTestStart(ITestResult result) {
	
		System.out.println("*** Test Method "+ result.getMethod().getMethodName() + " Started ***");
		ExtentReport.startTest("*** "+ result.getMethod().getMethodName()+ " ***");
		ExtentReport.passInfo("*** Test Method "+ result.getMethod().getMethodName() + " Started ***");
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("*** Test Method "+ result.getMethod().getMethodName() + " Executed Successfully ***");
		ExtentReport.onSuccess("*** Test Method "+ result.getMethod().getMethodName() + " Executed Successfully ***");
	}

}
