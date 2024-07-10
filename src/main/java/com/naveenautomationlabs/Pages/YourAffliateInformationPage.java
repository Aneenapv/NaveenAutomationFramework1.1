package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class YourAffliateInformationPage extends TestBase{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
	public  YourAffliateInformationPage()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//input[@id='input-company']")
	WebElement companyName; 
	
	public void companyName()
	{
		//companyName.clear();
		//companyName.sendKeys("ServicePro");
		fillTransferForm(companyName,"ServicePro");
	}
	
	@FindBy(xpath="//input[@id='input-website']")
	WebElement companyWebsite; 
	
	public void companyWebsite()
	{
		//companyWebsite.clear();
		//companyWebsite.sendKeys("www.servicepro.ca");
		fillTransferForm(companyWebsite,"www.servicepro.ca");
	}
	
	@FindBy(xpath="//input[@id='input-tax']")
	WebElement companyTaxId; 
	
	public void companyTaxId()
	{
		//companyTaxId.clear();
		//companyTaxId.sendKeys("22091");
		fillTransferForm(companyTaxId,"22091");
	}
	
	
	@FindBy(xpath="//input[@value='paypal']")
	WebElement companyPaymentMethod; 
	
	public void companyPaymentMethod()
	{
		companyPaymentMethod.click();
	}
	
	@FindBy(xpath="//input[@id='input-paypal']")
	WebElement companyPaypalEmailAccount; 
	
	public void companyPaypalEmailAccount()
	{
		//companyPaypalEmailAccount.clear();
		//companyPaypalEmailAccount.sendKeys("servicepro@servicepro.ca");
		fillTransferForm(companyPaypalEmailAccount,"servicepro@servicepro.ca");
		
	}
	
//	@FindBy(xpath="//input[@name='agree']")
//	WebElement companyAgree; 
//	
//	public void companyAgree()
//	{
//		companyAgree.click();
//	}
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement companyContinue; 
	
	public void companyContinue()
	{
		companyContinue.click();
	}
	
	
	public void affliateAccount()
	{
		companyName();
		companyWebsite();
		companyTaxId();
		companyPaymentMethod();
	    wait.until(ExpectedConditions.visibilityOf(companyPaypalEmailAccount));
		companyPaypalEmailAccount();
		//companyAgree();
		companyContinue();
	}
	
	
	
	
	
}
