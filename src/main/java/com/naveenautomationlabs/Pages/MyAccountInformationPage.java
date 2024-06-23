package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountInformationPage extends TestBase {
	
	public MyAccountInformationPage()
	{
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement editFirstName;
     
	public void editFirstName()
	{
		editFirstName.clear();
		editFirstName.sendKeys("Akhil");
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickOnContinueMyAccountInformation;
	
	public void clickOnContinueMyAccountInformation()
	{
		clickOnContinueMyAccountInformation.click();
	}
	
	
	public void MyAccountInformation()
	{
		editFirstName();
		clickOnContinueMyAccountInformation();
	}
}
