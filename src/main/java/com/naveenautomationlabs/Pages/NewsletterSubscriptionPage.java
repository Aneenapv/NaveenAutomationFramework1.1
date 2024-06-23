package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class NewsletterSubscriptionPage extends TestBase {
	
	public  NewsletterSubscriptionPage()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@checked ='checked']")
	WebElement clickOnYesNewsLetter;
	
	@FindBy(css="div.col-sm-10 label:last-of-type")
	WebElement clickOnNoNewsLetter;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement newsLetterContinue;
	
	@FindBy(css="div.alert.alert-success")
	WebElement newsLetterYesAlertBanner;
	
	
	
	
	public void clickOnYesNewsLetter()
	{
		clickOnYesNewsLetter.click();
	}
	
	public void clickOnNoNewsLetter()
	{
		clickOnNoNewsLetter.click();
	}
	
	
	public void newsLetterContinue()
	{
		newsLetterContinue.submit();
	}
	
	public String getNewsLetterAlertBanner()
	{
		 return newsLetterYesAlertBanner.getText().trim();
	}
	

	
	public void newsLetterSubscription()
	{
		clickOnNoNewsLetter();
		newsLetterContinue();
		
	}
	
}
