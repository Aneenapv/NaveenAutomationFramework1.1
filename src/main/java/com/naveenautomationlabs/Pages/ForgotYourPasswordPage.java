package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class ForgotYourPasswordPage extends TestBase{
	
	public ForgotYourPasswordPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-email")
	WebElement emailInputForgot;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(css="div.alert")
	WebElement alertBanner;
	
	public void inputEmail(String email)
	{
		emailInputForgot.sendKeys(email);
	}
	
	public void clickContinueButton()
	{
		continueButton.click();
	}
	
	public String getAlertBanner()
	{
		return alertBanner.getText();
	}
	
	public AccountLoginPage submitForgetPwdRequest(String email)
	{
		inputEmail(email);
		clickContinueButton();
		return new AccountLoginPage();
	}
	
	
	

}
