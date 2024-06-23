package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class ChangePasswordPage extends TestBase {
	
	public ChangePasswordPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement enterPassword;
	
	public void enterPassword()
	{
		enterPassword.sendKeys("Password@1234");
	}
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement enterConfirmPassword;
	
	public void enterConfirmPassword()
	{
		enterConfirmPassword.sendKeys("Password@1234");
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement changePasswordContinue;
	
	public void changePasswordContinue()
	{
		changePasswordContinue.submit();
	}
	
	public void changePassword()
	{
		enterPassword();
		enterConfirmPassword();
		changePasswordContinue();
	}

}
