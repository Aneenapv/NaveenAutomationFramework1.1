package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPage extends TestBase{
	
	public AccountLoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="input-email")
	WebElement emailField;
	
	@FindBy(id="input-password")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(css="#account-login div.alert")
	WebElement alertBanner;
	
	@FindBy(css="div.alert.alert-success")
	WebElement alertSuccessBanner;
	
	@FindBy(xpath="//a[text()='Forgotten Password']")
	WebElement forgottenPassswordLink;
	
	
	
	private void enterEmail(String email)
	{
		 emailField.sendKeys(email);
	}
	
	private void enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
	}
	
	private void clickLoginButton()
	{
		loginButton.submit();
	}
	
	public String getTextFromAlertBanner()
	{
		return alertBanner.getText();
	}
	
	public String getTextFromAlertSuccessBanner()
	{
		return alertSuccessBanner.getText();
	}
	
	public ForgotYourPasswordPage clickForgotPassword()
	{
		forgottenPassswordLink.click();
		return new ForgotYourPasswordPage();
	}
	
	public MyAccountPage loginToMyAccount(String email, String pwd)
	{
		enterEmail(email);
		enterPassword(pwd);
		clickLoginButton();
		return new MyAccountPage();
	}
	
	
	
	

}
