package com.naveenautomationlabs.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class AddressBookPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	public AddressBookPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='New Address']")
	WebElement clickOnNewAddress;
	
	public void clickOnNewAddress()
	{
		clickOnNewAddress.click();
	}
	
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement clickOnFirstName;
	
	public void clickOnFirstName()
	{
		clickOnFirstName.sendKeys("John");
	}
	

	@FindBy(xpath="//input[@name='lastname']")
	WebElement clickOnLastName;
	
	public void clickOnLastName()
	{
		clickOnLastName.sendKeys("George");
	}
	
	
	@FindBy(xpath="//input[@name='address_1']")
	WebElement clickOnAddressLine;
	
	public void clickOnAddressLine()
	{
		clickOnAddressLine.sendKeys("drury crescent");
	}
	
	
	@FindBy(xpath="//input[@name='city']")
	WebElement clickOnCity;
	
	public void clickOnCity()
	{
		clickOnCity.sendKeys("Brampton");
	}
	
	
	@FindBy(xpath="//input[@name='postcode']") 
	WebElement clickOnPostCode;
	
	public void clickOnPostCode()
	{
		clickOnPostCode.sendKeys("L6T 1L2");
	}
	
	
//	@FindBy(xpath="//select[@name='country_id']")  
//	WebElement clickOnCountry;
//	
//	public void clickOnCountry()
//	{
//		
//		Select selectObject1 = new Select(clickOnCountry);
//		selectObject1.selectByVisibleText("Canada");
//	}
//		
//	@FindBy(xpath="//select[@name='zone_id']")
//	WebElement clickOnState;
//	
//	public void clickOnState()
//	{
//		Select selectObject2 = new Select(clickOnState);
//		List<WebElement> options = selectObject2.getOptions();
//		
//		for(WebElement e:options)
//		{
//			//System.out.println(e.getText());
//		}
//		selectObject2.selectByVisibleText("Ontario");
//	}
	
	
	@FindBy(xpath="//select[@name='country_id']")  
	WebElement clickOnCountry;
	@FindBy(xpath="//select[@name='zone_id']")
	WebElement clickOnState;
	
	
	
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clickContinue;
	
	public void clickContinue()
	{
		clickContinue.click();
	}
	
	
	@FindBy(css="div.alert")
	WebElement addressBookSuccessAlertBanner;
	
	public String addressBookSuccessAlertBanner()
	{
		return addressBookSuccessAlertBanner.getText().trim();
		
	}
	
   public void formElementsOnAddressBook()
   {
	clickOnNewAddress();
	clickOnFirstName();
	clickOnLastName();
	clickOnAddressLine();
	clickOnCity();
	clickOnPostCode();
	//wait.until(ExpectedConditions.visibilityOf(clickOnCountry));
	selectDropdown(clickOnCountry,"38","Canada");
	wait.until(ExpectedConditions.textToBePresentInElement(clickOnCountry,"Canada"));
	selectDropdown(clickOnState,"610","Ontario");
	//clickOnCountry();
	//clickOnState();
	clickContinue();
    }
	
	
	
}
