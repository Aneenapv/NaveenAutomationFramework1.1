package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class MonitorsPage extends TestBase{
	
	public MonitorsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#content  div:nth-child(5) div:nth-child(1)  div div:nth-child(2) div.button-group button:nth-child(2)")
	WebElement appleCinemaToWishList;
	
	public void appleCinemaToWishList()
	{
		appleCinemaToWishList.click();
	}
	
	@FindBy(css="#content  div:nth-child(5) div:nth-child(2)  div div:nth-child(2) div.button-group button:nth-child(2)")
	WebElement samsungSyncMasterToWishList;
	
	public void samsungSyncMasterToWishList()
	{
		samsungSyncMasterToWishList.click();
	}
	
	
	@FindBy(xpath="//span[@class='caret']")
	WebElement clickOnMyAccountFromMonitorPage;

	public void  clickOnMyAccountFromMonitorPage()
	{
		 clickOnMyAccountFromMonitorPage.click();
	}
	
	
	
	@FindBy(css="#top-links ul  li.dropdown.open ul.dropdown-menu li:first-of-type a")
	WebElement selectOnMyAccountFromMonitorPage;

	public void  selectOnMyAccountFromMonitorPage()
	{
		 selectOnMyAccountFromMonitorPage.click();
	}
	
	public void monitorsAddedToWishList()
	{
		appleCinemaToWishList();
		samsungSyncMasterToWishList();
		clickOnMyAccountFromMonitorPage();
		selectOnMyAccountFromMonitorPage();
	}

}
