package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class LoginPage extends TestBase{
	
	@FindBy(name="uid")
	WebElement e_uname;
	
	@FindBy(name="password")
	WebElement e_pswd;
	
	@FindBy(name="btnLogin")
	WebElement e_loginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage verifyLogin(String uname, String pswd) {
		
		e_uname.sendKeys(uname);
		e_pswd.sendKeys(pswd);
		e_loginBtn.click();
		
		return PageFactory.initElements(driver, HomePage.class);
		
	}
	
	public boolean verifyIncorrectUserId(String uname, String pswd) {
		
		e_uname.sendKeys(uname);
		e_pswd.sendKeys(pswd);
		e_loginBtn.click();
		
		Utility.explicitlyWaitForAlert(driver, 20);
		
		if(driver.switchTo().alert().getText().equals("User or Password is not valid")) {
			driver.switchTo().alert().dismiss();
			return true;
		}
		else {
			driver.switchTo().alert().dismiss();
			return false;
		}
	}

	
	
	
	
	
	
	
	
	
	
}
