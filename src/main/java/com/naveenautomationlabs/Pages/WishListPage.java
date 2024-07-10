package com.naveenautomationlabs.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class WishListPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	
	public  WishListPage()
	{
		PageFactory.initElements(driver,this);
	}

//	@FindBy(css="#content div table  tbody tr:first-of-type td:last-of-type a")
//	WebElement itemOneRemoved;
//	//samsung
//	public void itemOneRemoved()
//	{
//		itemOneRemoved.click();
//	}
//	
//	
//	@FindBy(css="div td:last-of-type a")
//	
//	//@FindBy(css="tr:nth-of-type(2) td:last-of-type a")
//	WebElement itemTwoRemoved;
//	//apple
//	public void itemTwoRemoved()
//	{
//		itemTwoRemoved.click();
//	}
//	
//	
//	public void wishListRemove()
//	{
//		 itemOneRemoved();
//		 itemTwoRemoved();
//	}
	
	
//	@FindBy(css="tbody>tr")
//	List<WebElement> products;
//	public int products()
//	{
//		return products.size();
//	}
	
	
	
	//@FindBy(css="tbody>tr a[data-original-title='Remove']")
	//@FindBy(css="div td:last-of-type a")
	
	@FindBy(css="tr td:last-of-type a")
	List<WebElement>removeIcons;
	
	// removing all the products from wish list by page reinitializing.
	//After remove one product, page is refreshing, so we have to reinitialize the page again.
	//otherwise we get stale reference element exception
	
	public WishListPage removeAllProducts()
	{
		for(WebElement removeIcon: removeIcons)
		{
			try
			{
				removeIcon.click();
			}
			catch(Exception e)
			{
				//return new WishListPage();
				PageFactory.initElements(driver,this);
				removeAllProducts();
			}
		}
		return new  WishListPage();
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
