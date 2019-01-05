package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class Utility {
	
	static WebDriverWait explicitWait;
	static Alert alert;

			
		public static String getScreenshot(WebDriver driver, String fileName) {
			
			String filePath = TestBase.currentDir+"//configuration//"+fileName+".png";
			File F1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File F2= new File(filePath);
			
			try {
				FileUtils.copyFile(F1,F2);
			} catch (IOException e) {
				
				System.out.println("File is not copied at path :"+ filePath + "/n"
					+"Exception thrown :"+e.getMessage());
				
			}
			
			return filePath;
			
			
		} 
		
		public static boolean isAlertPresent(WebDriver driver) {
			
			try {
				alert = driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException e) {
				
				System.out.println("No alert present exception :"+e.getMessage());
				return false;
			}
		}
		
		public static boolean explicitlyWaitForAlert(WebDriver driver, long timeOutInSeconds ) {
			
			explicitWait = new WebDriverWait(driver, timeOutInSeconds);
			explicitWait.until(ExpectedConditions.alertIsPresent());

			return true;
		}

	

}
