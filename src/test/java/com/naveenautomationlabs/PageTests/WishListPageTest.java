package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MonitorsPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.WishListPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class WishListPageTest extends TestBase {


	AccountLoginPage loginPage;
	MyAccountPage myAccountPage;
	MonitorsPage monitorsPage;
	WishListPage wishListPage;


	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage= new AccountLoginPage();
	}
   
	@Test
	public void loginAndValidateMyAccountInformation()
	{
		MyAccountPage myAccountPage =loginPage.loginToMyAccount("centanvin68@gmail.com","Password@1234");
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText,"Not matching with My Account text");
		
		 MonitorsPage monitorsPage =myAccountPage.componentsAndMonitor();
		 monitorsPage.monitorsAddedToWishList();
		 
		 WishListPage wishListPage= myAccountPage.clickOnWishList();
		 wishListPage.wishListRemove();
	    
	  
		String EmptyWishListAlertText= wishListPage.getEmptyWishListAlert();
		Assert.assertEquals("Your wish list is empty.",EmptyWishListAlertText ,"Not matching wish list text");
	}
	

	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}


}
