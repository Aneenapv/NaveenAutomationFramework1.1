package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class WishListPage extends TestBase {
	WebDriverWait wait;
	
	public  WishListPage()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="#content div table  tbody tr:first-of-type td:last-of-type a")
	WebElement itemOneRemoved;
	//samsung
	public void itemOneRemoved()
	{
		itemOneRemoved.click();
	}
	
	
	@FindBy(css="#content div table  tbody tr:nth-of-type(2) td:last-of-type a")
	WebElement itemTwoRemoved;
	//apple
	public void itemTwoRemoved()
	{
		itemTwoRemoved.click();
	}
	
	public void wishListRemove()
	{
		 itemOneRemoved();
		 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 itemTwoRemoved();
	}
	
//	@FindBy(xpath="//a[text()='Continue']")
//	WebElement continueWishList;
//	public void continueWishList()
//	{
//		continueWishList.click();
//	}
	
	@FindBy(xpath="//p[text()='Your wish list is empty.']")
	WebElement emptyWishListAlert;
	
	public String getEmptyWishListAlert()
	{
		return emptyWishListAlert.getText().trim();
	}

	
	
	
	
}
