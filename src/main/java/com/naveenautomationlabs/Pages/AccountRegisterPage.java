package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class AccountRegisterPage extends TestBase {
	
	public  AccountRegisterPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#content h1")
	WebElement registerAccountHeading;
	public String getRegisterAccountHeading()
	{
		return registerAccountHeading.getText();
	}

	@FindBy(id="input-firstname")
	WebElement enterFirstName;
	public void enterFirstName()
	{
		enterFirstName.sendKeys("Neenu");
	}
	
	@FindBy(id="input-lastname")
	WebElement enterLastName;
	public void enterLastName()
	{
		enterLastName.sendKeys("Johny");
	}
	
	@FindBy(id="input-email")
	WebElement enterEmail;
	public void enterEmail()
	{
		enterEmail.sendKeys("njohny@gmail.com");
	}
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement enterTelephone;
	public void enterTelephone()
	{
		enterTelephone.sendKeys("612-808-1234");
	}
	
	@FindBy(id="input-password")
	WebElement enterPassword;
	public void enterPassword()
	{
		enterPassword.sendKeys("Password@1234");
	}
	
	@FindBy(id="input-confirm")
	WebElement enterConfirmPassword;
	public void enterConfirmPassword()
	{
		enterConfirmPassword.sendKeys("Password@1234");
	}
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement clickOnAgree;
	public void clickOnAgree()
	{
		clickOnAgree.click();
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickOnContinue;
	public void clickOnContinue()
	{
		clickOnContinue.click();
	}
	
	public void RegisterFormDetails()
	{
		enterFirstName();
		enterLastName();
		enterEmail();
		enterTelephone();
		enterPassword();
		enterConfirmPassword();
		clickOnAgree();
		clickOnContinue();
	}
	
	
	
	
	

}
